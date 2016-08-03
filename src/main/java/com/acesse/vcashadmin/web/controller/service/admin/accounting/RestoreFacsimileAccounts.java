package com.acesse.vcashadmin.web.controller.service.admin.accounting;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.AbstractAccountingService;
import com.acesse.vcashadmin.service.AccountingService;
import com.acesse.vcashadmin.service.dto.FacsimileSearchDto;
import com.acesse.vcashadmin.service.dto.MemberVcashDto;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(URLConstants.Admin.URL + URLConstants.Admin.Accounting.URL)
@AccountingService(sqlDisplay = SQLConstants.RESTORE_ACCOUNTS_DISPLAY_QUERY, sqlDisplayWithMemberId = SQLConstants.RESTORE_ACCOUNTS_WITHAFFID_QUERY)
public class RestoreFacsimileAccounts extends AbstractAccountingService<FacsimileSearchDto> {

    @RequestMapping(value = URLConstants.Admin.Accounting.RestoreFacsimileAccounts, method = RequestMethod.POST)
    public String restoreFacsimileAccounts(
            HttpServletResponse response,
            Model model,
            @RequestParam(name = "ctl00$mainContent$txtStartDate") String startDate,
            @RequestParam(name = "ctl00$mainContent$txtEndDate") String endDate,
            @RequestParam(name = "ctl00$mainContent$txtMemberId", required = false) Integer memberId,
            @RequestParam(name = "ctl00$mainContent$btnSearch", required = false) String search) {

        List ret = processQuery(model, startDate, endDate, memberId, sqlObject -> new FacsimileSearchDto(
                (Integer) sqlObject[0],
                (Integer) sqlObject[1],
                (String) sqlObject[2],
                (String) sqlObject[3],
                (String) sqlObject[4],
                (String) sqlObject[5],
                new Date(((Timestamp) sqlObject[6]).getTime()).toString(),
                (Integer) sqlObject[7],
                (String) sqlObject[8]
        ));

        if (search != null)
            return URLConstants.View.Admin.Accounting.RestoreFacsimileAccounts;
        else
            excelExportUtil.export(response, ret, "RestoreFacsimileAccounts.xls",
                    new String[]{"Member Id", "V-Cash Number", "First Name", "Last Name", "SecureInfo", "Created Date", "Email"});
        return null;
    }

    @RequestMapping(value = URLConstants.Admin.Accounting.RevokeFacsimileAccounts, method = RequestMethod.POST)
    public
    @ResponseBody
    String revokeFacsimileAccounts(@RequestParam(name = "accounts") String accounts) throws IOException {
        String ret = "";
        ObjectMapper mapper = new ObjectMapper();
        JavaType listType = mapper.getTypeFactory().constructParametricType(List.class, MemberVcashDto.class);
        List<MemberVcashDto> memberVcashDtos = mapper.readValue(accounts, listType);

        memberVcashDtos.forEach(idName -> {
            logger.info("Revoking of " + idName.memberid + " : " + dataUtils.restoreOrDeleteDuplicateAccounts(idName.vcashid, idName.vcashid, false, null, null, 1));
        });
        return ret;
    }
}
