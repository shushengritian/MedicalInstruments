package com.graduate.controller;

import com.graduate.service.DeviceService;
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
 * @date 2018/6/6 23:15
 */
@Controller
@RequestMapping("/device")
public class DeviceController {

    @Resource
    private DeviceService deviceService;

    @RequestMapping("/device")
    public String dataDepartment(HttpServletRequest request, HttpServletResponse response) {
        return "/base/device";
    }


    @RequestMapping(value = "/selectDevice",method = {RequestMethod.POST})
    public void selectDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String deviceNo = request.getParameter("deviceNo");
        String deviceName = request.getParameter("deviceName");
        String deviceType = request.getParameter("deviceType");
        String isMeasurement = request.getParameter("isMeasurement");
        String status = request.getParameter("status");
        String pageNo = request.getParameter("pageNo");
        String pageSize = request.getParameter("pageSize");
        JSONObject result = deviceService.listDevice(id, deviceNo, deviceName, deviceType, isMeasurement, status, pageNo, pageSize);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/add",method = {RequestMethod.POST})
    public void addDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String deviceNo = request.getParameter("deviceNo");
        String deviceName = request.getParameter("deviceName");
        String unit = request.getParameter("unit");
        String deviceType = request.getParameter("deviceType");
        String isMeasurement = request.getParameter("isMeasurement");
        String status = request.getParameter("status");
        JSONObject result = deviceService.add(deviceNo, deviceName, unit, deviceType, isMeasurement, status);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/getDevice",method = {RequestMethod.POST})
    public void getDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = deviceService.getDeviceById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/edit",method = {RequestMethod.POST})
    public void editDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        String deviceNo = request.getParameter("deviceNo");
        String deviceName = request.getParameter("deviceName");
        String unit = request.getParameter("unit");
        String deviceType = request.getParameter("deviceType");
        String isMeasurement = request.getParameter("isMeasurement");
        String status = request.getParameter("status");
        JSONObject result = deviceService.editById(id, deviceNo, deviceName, unit, deviceType, isMeasurement, status);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping(value = "/del",method = {RequestMethod.POST})
    public void deleteDevice(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        JSONObject result = deviceService.delById(id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

}
