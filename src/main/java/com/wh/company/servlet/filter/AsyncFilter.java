package com.wh.company.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author Wanghao
 * @version v1
 * @github (https : / / github.com / wanghao229)
 * @blog (https : / / www.cnblogs.com / wanghao229)
 * @summary
 * @copyright (c) 2020,  All Rights Reserved.
 * @since 2020/5/22 9:26
 */
@WebFilter(filterName="AsynFilter",asyncSupported=true, value={"/ServletAsyn"}, dispatcherTypes={DispatcherType.REQUEST,DispatcherType.ASYNC})
public class AsyncFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Start.....AsyncFilter");
        chain.doFilter(request, response);
        System.out.println("End....AsynFilter");
    }

    public void destroy() {

    }
}
