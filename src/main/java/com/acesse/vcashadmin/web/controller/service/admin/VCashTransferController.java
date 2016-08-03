package com.acesse.vcashadmin.web.controller.service.admin;

import com.acesse.vcashadmin.constants.URLConstants;
import com.acesse.vcashadmin.db.constants.SQLConstants;
import com.acesse.vcashadmin.service.AbstractController;
import com.acesse.vcashadmin.service.DataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(URLConstants.Admin.URL)
public class VCashTransferController extends AbstractController {
    @Autowired
    private DataUtils dataUtils;

    @RequestMapping(value = URLConstants.Admin.VCashTransferGetProductCode, method = RequestMethod.GET)
    @ResponseBody
    public List<Pair<String, Integer>> vcashTransferGetProductCodes(@RequestParam(name = "transcode", required = false) Integer transCodes) {
        List<Pair<String, Integer>> ret = new ArrayList<>();
        ret.add(Pair.of("---Select---", -1));
        switch (transCodes) {
            case 5: {
                ret.add(Pair.of("10000 - Fund V-Cash (Internal V-Cash Transfer)", 10000));
                ret.add(Pair.of("10011 - Pay Shipping Fee", 10011));
                ret.add(Pair.of("10051 - Position Sale", 10051));
                ret.add(Pair.of("10053 - Refill", 10053));
            }
            break;
            case 16: {
                ret.add(Pair.of("10010 - Fund /Exchange Fee", 10010));
            }
            break;
            case 45: {
                ret.add(Pair.of("10047 - eWallet System", 10047));
                ret.add(Pair.of("10048 - Refund", 10048));
            }
            break;
            case 302: {
                ret.add(Pair.of("10004 - Domain Registration", 10004));
                ret.add(Pair.of("10048 - Refund", 10048));
                ret.add(Pair.of("10049 - System/Transaction Error", 10049));
            }
            break;
            case 303: {
                ret.add(Pair.of("10049 - System/Transaction Error", 10049));
            }
            break;
        }
        return ret;
    }

    @RequestMapping(value = URLConstants.Admin.VCashTransfer, method = RequestMethod.POST)
    public String vcashTransfer(
            @RequestParam(name = "ctl00$mainContent$ddlTransCodes", required = false) Integer transCodes,
            @RequestParam(name = "ctl00$mainContent$ddlProdCodes", required = false) Integer prodCodes,
            @RequestParam(name = "ctl00$mainContent$txtVCashFrom", required = false) Integer from,
            @RequestParam(name = "ctl00$mainContent$txtVCashNumberTo", required = false) Integer to,
            @RequestParam(name = "ctl00$mainContent$txtTransferAmount", required = false) Double amount,
            @RequestParam(name = "ctl00$mainContent$txtTransferFee", required = false) Integer fee,
            @RequestParam(name = "ctl00$mainContent$txtTransferMemo", required = false) String memo,
            @RequestParam(name = "ctl00$mainContent$btnSubmit", required = false) String submit
    ) {
        boolean valid = false;
        String message = "";
        if (from == null) {
            valid = false;
            message = "From number is null";
        } else if (to == null) {
            valid = false;
            message = "To number is null";
        } else if (!VerifyVCashAccountInfo(from, to)) {
            valid = false;
            message = "Invalid accounts";
        } else if (!dataUtils.ReadValidBalance(from, amount)) {
            valid = false;
            message = "Invalid balance";
        }
        logger.info("vcashTransfer: valid: " + valid + " message: " + message);
        return URLConstants.Admin.VCashTransfer;
    }

    private boolean VerifyVCashAccountInfo(Integer from, Integer to) {
        List accountInfos = dataUtils.loadTable(SQLConstants.VCASH_ACCOUNTS_ISVALID_QUERY, from.toString(), to.toString());
        return accountInfos.size() == 2;
    }
}
