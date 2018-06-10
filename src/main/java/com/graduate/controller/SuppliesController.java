package com.graduate.controller;

import com.graduate.service.SuppliesService;
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
 * @date 2018/6/8 21:51
 */
@Controller
@RequestMapping("/supplies")
public class SuppliesController {

    @Resource
    private SuppliesService suppliesService;

    @RequestMapping("/supplies")
    public String dataSupplies(HttpServletRequest request, HttpServletResponse response) {
        return "/base/supplies";
    }

   @RequestMapping(value = "/selectSupplies",method = {RequestMethod.POST})
    public void selectSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String hcNo = request.getParameter("hcNo");
        String hcName = request.getParameter("hcName");
        String manafacturer = request.getParameter("manafacturer");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = suppliesService.listSupplies(id, hcNo, hcName, manafacturer, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String hcNo = request.getParameter("hcNo");
        String hcName = request.getParameter("hcName");
        String manafacturer = request.getParameter("manafacturer");
        String unit = request.getParameter("unit");
        String hcType = request.getParameter("hcType");
        String price = request.getParameter("price");
        JSONObject result = suppliesService.add(hcNo, hcName, manafacturer, unit, hcType, price);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/getSupplies",method = {RequestMethod.POST})
    public void getSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = suppliesService.getSuppliesById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public void editSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String hcNo = request.getParameter("hcNo");
        String hcName = request.getParameter("hcName");
        String manafacturer = request.getParameter("manafacturer");
        String unit = request.getParameter("unit");
        String hcType = request.getParameter("hcType");
        String price = request.getParameter("price");
        JSONObject result = suppliesService.editById(id, hcNo, hcName, manafacturer, unit, hcType, price);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public void deleteSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = suppliesService.delById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

}
