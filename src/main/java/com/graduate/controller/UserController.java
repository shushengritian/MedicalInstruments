package com.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import com.graduate.model.User;
import com.graduate.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author xiyouquedongxing
 * @date 2018-04-14
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request,Model model) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        List<User> list = userService.login(username,password);
        if (list != null && list.size() > 0) {
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            String userName = list.get(0).getUserName();
            request.setAttribute("userName",userName);
            return "index";
        } else {
            return "register";
        }
    }

    @RequestMapping("/newLogin")
    public String newLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        return "login";
    }
    @RequestMapping("/getUser")
    public void getUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String loginAccount = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        JSONObject result = new JSONObject();
        result.put("code","1");
        result.put("loginAccount",loginAccount);
        result.put("password",password);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();

    }

    @RequestMapping("/showUser")
    public String selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        return "/info/basicInfo";
    }

    @RequestMapping("/resetPassword")
    public String resetPassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        return "/info/resetPassword";
    }

    @RequestMapping("/updatePassword")
    public void updatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loginAccount = request.getParameter("loginAccount");
        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        JSONObject result = userService.updatePassword(loginAccount, oldPassword, newPassword, "1");
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/updateUserInfo")
    public void updateUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String id = request.getParameter("id");
        JSONObject result = userService.updateUserInfo(userName, phone, email, id);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/getUserInfo")
    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");

        JSONObject result = userService.getUserInfo(username, password);
        response.getWriter().write(result.toString());
        response.getWriter().flush();
        response.getWriter().close();

    }
    @RequestMapping("/getExternalOrderId")
    public void getExternalOrderId(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}