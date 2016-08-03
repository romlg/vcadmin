package com.acesse.vcashadmin.service;


import com.acesse.vcashadmin.constants.ModelConstants;
import com.acesse.vcashadmin.util.ExcelExportUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractAccountingService<T> extends AbstractController {
    @Autowired
    protected DataUtils dataUtils;
    @Autowired
    protected ExcelExportUtil excelExportUtil;

    protected List processQuery(Model model, String startDate, String endDate, Integer memberId, SqlToDtoConverter<T> converter) {
        model.addAttribute(ModelConstants.SHOW_RESULT, true);

        List ret;
        if (memberId == null)
            ret = dataUtils.loadTable(this.getClass().getAnnotation(AccountingService.class).sqlDisplay(), startDate, endDate);
        else
            ret = dataUtils.loadTable(this.getClass().getAnnotation(AccountingService.class).sqlDisplayWithMemberId(), startDate, endDate, memberId.toString());

        model.addAttribute(ModelConstants.DATA_AVAILABLE, ret.size() > 0);

        List<T> result = new ArrayList<>();
        for (Object r : ret) {
            Object[] sqlObject = (Object[]) r;
            result.add(converter.convert(sqlObject));
        }
        model.addAttribute(ModelConstants.DATA, result);
        model.addAttribute(ModelConstants.DATA_COUNT, result.size());
        return ret;
    }

    public interface SqlToDtoConverter<T> {
        T convert(Object[] sqlObject);
    }
}
