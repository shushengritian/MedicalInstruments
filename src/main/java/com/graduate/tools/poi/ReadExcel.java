package com.graduate.tools.poi;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcel {
    /**总行数*/
    private int totalRows = 0;
    /**总列数*/
    private int totalCells = 0;
    /**错误信息接收器*/
    private String errorMsg;
    /**构造方法*/
    public ReadExcel(){}
    /**获取总行数*/
    public int getTotalRows()  { return totalRows;}
    /**获取总列数*/
    public int getTotalCells() {  return totalCells;}
    /**获取错误信息*/
    public String getErrorInfo() { return errorMsg; }

    /**
     * 通用方法
     * 读取Excel表格，获取信息
     * @param file Excel文件
     * @param dataBeginRows 有效数据开始行
     * @param keyList 文件抬头字段集合
     * @List Excel信息的集合
     * */
    public JSONArray listExcelInfo(File file, int dataBeginRows, List keyList) {
        //创建返回集合
        JSONArray array = new JSONArray();
        //获取文件名字
        String fileName = file.getName();
        //try catch 捕捉异常
        try {
            //通过文件获取I/O流
            InputStream inputStream = new FileInputStream(file);
            //验证文件格式
            if(!validateExcel(fileName)){
                return null;
            }
            //根据文件名判断文件是2003版本还是2007版本
            boolean isExcel2003 = true;
            if (isExcel2007(fileName)) {
                isExcel2003 = false;
            }
            //获取Excel表格内容
            Workbook wb = null;
            if (isExcel2003) {
                // 当excel是2003时,创建excel2003
                wb = new HSSFWorkbook(inputStream);
            } else {
                // 当excel是2007时,创建excel2007
                wb = new XSSFWorkbook(inputStream);
            }
            // 读取Excel里面客户的信息
            array = readExcelContent(wb,dataBeginRows,keyList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }


    /**
     *
     * */
    private JSONArray readExcelContent(Workbook wb, int dataBeginRows, List keyList) {
         // 得到第一个shell
        Sheet sheet = wb.getSheetAt(0);
        // 得到Excel的行数
        this.totalRows = sheet.getPhysicalNumberOfRows();
        // 得到Excel的列数(前提是有行数)
        if (totalRows > dataBeginRows  && sheet.getRow(0) != null) {
            this.totalCells = sheet.getRow(dataBeginRows).getPhysicalNumberOfCells();
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray array = new JSONArray();
        // 循环Excel行数
        for (int r = dataBeginRows; r < totalRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            JSONObject obj = new JSONObject();
            // 循环Excel的列
            for (int c = 0; c < this.totalCells; c++) {
                Cell cell = row.getCell(c);
                if (null != cell) {
                    if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                        DecimalFormat df = new DecimalFormat("#");
                        String cellValue = df.format(cell.getNumericCellValue());
                        obj.put(keyList.get(c),cellValue);
                    }else{
                        obj.put(keyList.get(c),cell.getStringCellValue());
                    }

                }
            }
            // 添加到list
            array.add(obj);
        }
        return array;
    }


    /**
     * 验证EXCEL文件
     *
     * @param filePath
     * @return
     */
    public boolean validateExcel(String filePath) {
        if (filePath == null || !(isExcel2003(filePath) || isExcel2007(filePath))) {
            errorMsg = "文件名不是excel格式";
            return false;
        }
        return true;
    }

    /** @描述：是否是2003的excel，返回true是2003*/
    public static boolean isExcel2003(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**@描述：是否是2007的excel，返回true是2007*/
    public static boolean isExcel2007(String filePath)  {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}
