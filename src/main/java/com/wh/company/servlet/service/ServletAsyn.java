package com.wh.company.servlet.service;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Wanghao
 * @version v1
 * @github (https : / / github.com / wanghao229)
 * @blog (https : / / www.cnblogs.com / wanghao229)
 * @summary
 * @copyright (c) 2020,  All Rights Reserved.
 * @since 2020/5/22 9:15
 */
@WebServlet(name = "ServletAsyn", urlPatterns = "/ServletAsyn", asyncSupported = true)
public class ServletAsyn extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAsyn() {
        super();
    }


    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     * @param request
     * @param response
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Servlet执行开始时间："+new Date());

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        Date date = new Date(System.currentTimeMillis());

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        out.print("<h1>");
        out.print("Servlet begin --" + sdf.format(date) + "<br>");
        out.print("</h1>");
        out.print("<hr>");


        // Async

        AsyncContext context = request.startAsync();
        new Thread(new Executor(context)).start();

        System.out.println("Servlet执行结束时间："+new Date());

    }

    /**
     * 内部类实现线程
     */
    public class Executor implements Runnable{
        private AsyncContext context;

        public Executor(AsyncContext context){
            this.context=context;
        }


        public void run() {

            try {

                Thread.sleep(1000 * 3);

                context.getRequest();
                context.getResponse();
                ServletResponse response = context.getResponse();
                PrintWriter out = response.getWriter();
                Date date = new Date(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

                out.print("<h1>");
                out.println("Thread worker finished --"+ sdf.format(date));// 响应输出到客户端
                out.print("</h1><hr>");
                out.flush();

                System.out.println("业务完成时间:"+new Date());

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
