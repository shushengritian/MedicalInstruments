package com.graduate.controller;

import com.graduate.service.HomeService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author xiyouquedongxing
 * @date 2018/5/27 8:55
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    @Resource
    private HomeService homeService;

    @RequestMapping("/dataDictionary")
    public String dataDictionary(HttpServletRequest request, HttpServletResponse response) {
        return "/home/dataDictionary";
    }

    @RequestMapping(value = "/selectDateDictionary",method = {RequestMethod.POST})
    public void selectDateDictionary(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String columnName = request.getParameter("columnName");
        String insideValue = request.getParameter("insideValue");
        String exteriorValue = request.getParameter("exteriorValue");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = homeService.listDateDictionary(id, columnName, insideValue, exteriorValue, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addDateDictionary(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String columnName = request.getParameter("columnName");
        String insideValue = request.getParameter("insideValue");
        String exteriorValue = request.getParameter("exteriorValue");
        JSONObject result = homeService.add(columnName,insideValue,exteriorValue);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/getData",method = {RequestMethod.POST})
    public void getDateDictionary(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = homeService.getById(Integer.parseInt(id));
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public void editDateDictionary(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String columnName = request.getParameter("columnName");
        String insideValue = request.getParameter("insideValue");
        String exteriorValue = request.getParameter("exteriorValue");
        JSONObject result = homeService.editById(id,columnName,insideValue,exteriorValue);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public void deleteDateDictionary(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = homeService.delById(Integer.parseInt(id));
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }



}
