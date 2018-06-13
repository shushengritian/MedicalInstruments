package com.graduate.tools.poi;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelLeadInService {

    /**
     * Excel 导入
     * */
    public JSONObject readExcelInfo(String excelPath, int dataBeginRows, List keyList) {
        JSONObject result = new JSONObject();
        File file = new File(excelPath);
        //创建处理EXCEL的类
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取上传的事件单
        JSONArray array = readExcel.listExcelInfo(file,dataBeginRows,keyList);
        if (array != null && array.size() > 0) {
            result.put("code","1");
            result.put("msg","获取Excel表格信息成功");
            result.put("data",array);
            //成功之后删除服务器Excel表格
            file.delete();
        } else {
            result.put("code","0");
            result.put("msg","获取Excel表格信息失败");
        }
        return result;
    }

}
