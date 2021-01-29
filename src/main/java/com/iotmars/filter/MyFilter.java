package com.iotmars.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: xsh
 * @date: 2021/1/28 15:56
 */
@Slf4j
@WebFilter(filterName="MyFilter",urlPatterns="/*")
@Order(0)
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("结束过滤器");
    }

    @Override
    public void destroy() {
        log.info("MyFilter destroy");
    }
}
