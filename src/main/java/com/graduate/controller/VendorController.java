package com.graduate.controller;

import com.graduate.service.VendorService;
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
 * @date 2018/6/10 15:32
 */
@Controller
@RequestMapping("/vendor")
public class VendorController {

    @Resource
    private VendorService vendorService;

    @RequestMapping("/vendor")
    public String dataVendor(HttpServletRequest request, HttpServletResponse response) {
        return "/vendor/vendor";
    }

    @RequestMapping(value = "/selectVendor",method = {RequestMethod.POST})
    public void selectVendor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String vName = request.getParameter("vName");
        String oibc = request.getParameter("oibc");
        String vType = request.getParameter("vType");
        String status = request.getParameter("status");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = vendorService.listVendor(id, vName, oibc, vType, status,
                pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addVendor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String vNo = request.getParameter("vNo");
        String vName = request.getParameter("vName");
        String oibc = request.getParameter("oibc");
        String salesman = request.getParameter("salesman");
        String phone = request.getParameter("phone");
        String vType = request.getParameter("vType");
        String status = request.getParameter("status");
        JSONObject result = vendorService.add(vNo, vName, oibc, salesman, phone, vType, status);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/getVendor",method = {RequestMethod.POST})
    public void getsVendor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = vendorService.getVendorById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public void editVendor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String vNo = request.getParameter("vNo");
        String vName = request.getParameter("vName");
        String oibc = request.getParameter("oibc");
        String salesman = request.getParameter("salesman");
        String phone = request.getParameter("phone");
        String vType = request.getParameter("vType");
        String status = request.getParameter("status");
        JSONObject result = vendorService.editById(id, vNo, vName, oibc, salesman, phone, vType, status);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public void deleteVendor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = vendorService.delById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
