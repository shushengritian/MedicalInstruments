package com.graduate.controller;

import com.graduate.service.SuppliesService;
import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author xiyouquedongxing
 * @date 2018/6/8 21:51
 */
@Controller
@RequestMapping("/supplies")
public class SuppliesController {
    File tempPathFile;

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

    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public void upload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // Create a factory for disk-based file items
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // Set factory constraints
            // 设置缓冲区大小，这里是4kb
            factory.setSizeThreshold(4096);
            // 设置缓冲区目录
            factory.setRepository(tempPathFile);

            // Create a new file upload handler
            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint
            // 设置最大文件尺寸，这里是4MB
            upload.setSizeMax(4194304);

            // 得到所有的文件
            List<FileItem> items = upload.parseRequest(request);

            System.out.println(items.size());
            Iterator<FileItem> i = items.iterator();
            while (i.hasNext()) {
                FileItem fi = (FileItem) i.next();
                JSONObject result = suppliesService.uploadExcel(fi);
                response.getWriter().write(result.toString());
                response.getWriter().flush();
                response.getWriter().close();
            }
            System.out.print("上传成功！");
        } catch (Exception e) {

        }
    }

}
