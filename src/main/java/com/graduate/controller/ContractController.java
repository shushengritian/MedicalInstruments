package com.graduate.controller;

import com.graduate.service.ContractService;
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
 * @date 2018/6/10 21:41
 */
@Controller
@RequestMapping("contract")
public class ContractController {

    @Resource
    private ContractService contractService;

    @RequestMapping("/contract")
    public String dataContract(HttpServletRequest request, HttpServletResponse response) {
        return "/vendor/contract";
    }

    @RequestMapping(value = "/selectContract",method = {RequestMethod.POST})
    public void selectContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String partyB = request.getParameter("partyB");
        String cName = request.getParameter("cName");
        String cType = request.getParameter("cType");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = contractService.listContract(partyB, cName, cType, startDate, endDate, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

   @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String cNo = request.getParameter("cNo");
        String cName = request.getParameter("cName");
        String cType = request.getParameter("cType");
        String partyB = request.getParameter("partyB");
        String bContacts = request.getParameter("bContacts");
        String phone = request.getParameter("phone");
        String signedDate = request.getParameter("signedDate");
        String endDate = request.getParameter("endDate");
        String content = request.getParameter("content");
        JSONObject result = contractService.add(cNo, cName, cType, partyB, bContacts, phone, signedDate, endDate, content);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/getContract",method = {RequestMethod.POST})
    public void getContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = contractService.getContractById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public void editContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String cNo = request.getParameter("cNo");
        String cName = request.getParameter("cName");
        String cType = request.getParameter("cType");
        String partyB = request.getParameter("partyB");
        String bContacts = request.getParameter("bContacts");
        String phone = request.getParameter("phone");
        String signedDate = request.getParameter("signedDate");
        String endDate = request.getParameter("endDate");
        String content = request.getParameter("content");
        JSONObject result = contractService.editById(id, cNo, cName, cType, partyB, bContacts, phone, signedDate, endDate, content);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public void deleteContract(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = contractService.delById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }


}
