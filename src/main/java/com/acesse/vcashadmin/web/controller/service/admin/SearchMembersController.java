package com.acesse.vcashadmin.web.controller.service.admin;

import com.acesse.vcashadmin.constants.ModelConstants;
import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import com.acesse.vcashadmin.service.DataUtils;
import com.acesse.vcashadmin.service.dto.MemberSearchDto;
import com.acesse.vcashadmin.service.dto.SearchListResult;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping(URLConstants.Admin.URL)
public class SearchMembersController extends AbstractController {
    @Autowired
    private DataUtils dataUtils;

    public static class SearchMembersDto {
        public String affiliateId;
        public String vcashNumber;
        public String group;
        public String transNumber;
        public String signupDate;
        public String status;
        public String lastNAme;
        public String firstName;
        public String exactSearch;
        public String email;
    }

    @RequestMapping(value = URLConstants.Admin.SearchMembers, method = RequestMethod.POST)
    public String searchMemebers(
            @RequestParam(name = "ctl00$mainContent$txtMemberID") Integer memberId,
            @RequestParam(name = "ctl00$mainContent$txtVCashNumber") Integer vCashNumber,
            @RequestParam(name = "ctl00$mainContent$txtFirstName") String firstName,
            @RequestParam(name = "ctl00$mainContent$txtLastName") String lastName,
            @RequestParam(name = "ctl00$mainContent$txtEmail") String email,
            @RequestParam(name = "ctl00$mainContent$txtSignUpDate") String signUpDate,
            @RequestParam(name = "ctl00$mainContent$txtTransNumber") Integer transNumber,
            @RequestParam(name = "ctl00$mainContent$ddlMemberStatus") Integer memberStatus,
            @RequestParam(name = "ctl00$mainContent$ddlGroup") Integer group,
            @RequestParam(name = "ctl00$mainContent$chkExactSearch") String exactSearch,
            Model model
    ) {

        model.addAttribute(ModelConstants.SHOW_RESULT, true);

        SearchMembersDto dto = new SearchMembersDto();
        dto.affiliateId = memberId != null ? memberId.toString() : "";
        dto.vcashNumber = vCashNumber != null ? memberId.toString() : "";
        dto.group = group == -1 ? "" : group.toString();
        dto.transNumber = transNumber != null ? transNumber.toString() : "";
        dto.signupDate = signUpDate.trim();
        dto.status = memberStatus == -1 ? "" : memberStatus.toString();
        dto.lastNAme = lastName.trim();
        dto.firstName = firstName.trim();
        dto.exactSearch = String.valueOf(exactSearch.equalsIgnoreCase("1"));
        dto.email = email.trim();

        String json = null;
        try {
            json = new ObjectMapper().writeValueAsString(dto);
        } catch (IOException e) {
            logger.error("Unable to create json", e);
        }

        logger.info("dto = " + json);

        SearchListResult<MemberSearchDto> ret = dataUtils.executeSearchData(serviceBaseUrl + "membersearchjson", json, DataUtils.SEARCH_TYPE.MEMBER_SEARCH);

        model.addAttribute(ModelConstants.DATA_AVAILABLE, ret != null && ret.getSearchResults().size() > 0);

        if (ret != null)
            model.addAttribute(ModelConstants.DATA, ret.getSearchResults());

        return URLConstants.View.Admin.SearchMembers;
    }
}