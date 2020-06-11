package com.wh.company.servlet.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Wanghao
 * @version v1
 * @github (https : / / github.com / wanghao229)
 * @blog (https : / / www.cnblogs.com / wanghao229)
 * @summary
 * @copyright (c) 2020,  All Rights Reserved.
 * @since 2020/5/22 8:43
 */
public class HelloServlet extends HttpServlet {

    private String message;
    @Override
    public void init() throws ServletException
    {
        // 执行必需的初始化
        message = "Hello World FROM HelloServlet";
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // 设置响应内容类型
        response.setContentType("text/html");

        // 实际的逻辑是在这里
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy()
    {
        // 什么也不做
    }
}
