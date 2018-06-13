package com.graduate.controller;

import javax.servlet.http.HttpServletRequest;

import com.graduate.model.User;
import com.graduate.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @RequestMapping("/showUser")
    public String selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        String password = (String)session.getAttribute("password");
        System.out.println("用户名："+username+"---------密码："+password);
        return "register";
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