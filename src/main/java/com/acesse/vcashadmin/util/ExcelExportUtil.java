package com.acesse.vcashadmin.util;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
public class ExcelExportUtil {

    @Value("${vcashadmin.tmpdir}")
    private String tmpDirFileName;

    public void export(HttpServletResponse response, List data, String fileName, String[] header) {
        try {
            WritableWorkbook workbook;

            File targetDir = new File(tmpDirFileName);
            if (!targetDir.exists())
                targetDir.mkdirs();
            File targetFile = new File(fileName);
            if (targetFile.exists())
                targetFile.delete();
            workbook = Workbook.createWorkbook(new FileOutputStream(targetFile));
            workbook.createSheet("Page 1", 0);

            WritableSheet sheet = workbook.getSheet(0);

            for (int i = 0; i < header.length; i++)
                sheet.addCell(new Label(i, 0, header[i]));

            for (int r = 0; r < data.size(); r++) {
                Object[] sqlObject = (Object[]) data.get(r);
                for (int c = 0; c < sqlObject.length; c++) {
                    sheet.addCell(new Label(c, r + 1, sqlObject[c] != null ? sqlObject[c].toString() : ""));
                }
            }

            workbook.write();
            workbook.close();

            response.setContentType("application/excel");
            response.setContentLength((int) targetFile.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + targetFile.getName() + "\"");

            try {
                FileCopyUtils.copy(new FileInputStream(targetFile), response.getOutputStream());
            } catch (IOException e) {
                LoggerFactory.getLogger(ExcelExportUtil.class).error("Unable to copy file to output stream", e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
