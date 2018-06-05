package com.graduate.controller;

import com.graduate.service.DepartmentService;
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
 * @date 2018/6/5 16:58
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/department")
    public String dataDepartment(HttpServletRequest request, HttpServletResponse response) {
        return "/department/department";
    }

    @RequestMapping(value = "/selectDepartment",method = {RequestMethod.POST})
    public void selectDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String landline = request.getParameter("landline");
        String status = request.getParameter("status");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = departmentService.listDepartment(id, number, name, landline, status, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String landline = request.getParameter("landline");
        String status = request.getParameter("status");
        JSONObject result = departmentService.add(number, name, landline, status);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

}
