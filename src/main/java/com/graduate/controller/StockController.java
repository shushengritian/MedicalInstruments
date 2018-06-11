package com.graduate.controller;

import com.graduate.service.StockService;
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
 * @date 2018/6/11 15:15
 */
@Controller
@RequestMapping("stock")
public class StockController {

    @Resource
    private StockService stockService;

    @RequestMapping("/storage")
    public String storage(HttpServletRequest request, HttpServletResponse response) {
        return "/stock/storage";
    }

    @RequestMapping("/outStock")
    public String outBound(HttpServletRequest request, HttpServletResponse response) {
        return "/stock/outStock";
    }

    @RequestMapping("/accessStock")
    public String accessStock(HttpServletRequest request, HttpServletResponse response) {
        return "/stock/accessStock";
    }

    @RequestMapping(value = "/selectSupplies",method = {RequestMethod.POST})
    public void selectSupplies(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String hcNo = request.getParameter("hcNo");
        String hcName = request.getParameter("hcName");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = stockService.listSupplies(hcNo, hcName, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/inStock",method = {RequestMethod.POST})
    public void inStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String hcNo = request.getParameter("hcNo");
        String singleNo = request.getParameter("singleNo");
        String number = request.getParameter("number");
        String sType = request.getParameter("sType");
        JSONObject result = stockService.inStock(hcNo, singleNo, number, sType);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/outStock",method = {RequestMethod.POST})
    public void outStock(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String hcNo = request.getParameter("hcNo");
        String singleNo = request.getParameter("singleNo");
        String number = request.getParameter("number");
        String sType = request.getParameter("sType");
        JSONObject result = stockService.outStock(hcNo, singleNo, number, sType);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/access",method = {RequestMethod.POST})
    public void access(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String hcName = request.getParameter("hcName");
        String sType = request.getParameter("sType");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = stockService.listAccessStock(startDate, endDate, hcName, sType, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }
}
