package com.springbootdemo.springbootdemo.controller;

import com.springbootdemo.springbootdemo.dto.UserDTO;
import com.springbootdemo.springbootdemo.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private UserService userService;

    /**
     * 导出excel
     * @param response
     * @throws IOException
     */
    @GetMapping(value = "/download")
    public void downloadAllClassmate(HttpServletResponse response, Integer period) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");
        List<UserDTO> userDTOS = userService.getUsers();
        String fileName = System.currentTimeMillis() + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        String[] headers = { "用户编号", "用户名", "用户地址", "用户手机号"};
        //headers表示excel表中第一行的表头
        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头
        for(int i=0;i<headers.length;i++){
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        //在表中存放查询到的数据放入对应的列
        for (UserDTO record : userDTOS) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(record.getUserId());
            row1.createCell(1).setCellValue(record.getUserName());
            row1.createCell(2).setCellValue(record.getAddress());
            row1.createCell(3).setCellValue(record.getPhoneNo().toString());
            rowNum++;
        }
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        response.flushBuffer();
        workbook.write(response.getOutputStream());
    }
}
