package com.graduate.controller;

import com.graduate.service.VendorService;
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
 * @date 2018/6/10 15:32
 */
@Controller
@RequestMapping("/vendor")
public class VendorController {

    private String uploadPath = "D:\\temp"; // 上传文件的目录
    File tempPathFile;

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
                String fileName = fi.getName();
                if (fileName != null) {
                    // 解决文件名乱码问题
                    File savedFile = new File(uploadPath,fileName);
                    fi.write(savedFile);
                }
            }
            System.out.print("上传成功！");
        } catch (Exception e) {

        }
    }


}
