package com.gx.core.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gx.soft.sys.web.LoginController;

public class PathHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private String servletPath;
    private HttpServletRequest httpServletRequest;
    private static Logger logger = LoggerFactory.getLogger(PathHttpServletRequestWrapper.class);   
    public PathHttpServletRequestWrapper(HttpServletRequest request, String path) {
        super(request);
        this.httpServletRequest = request;
        logger.info("before padth="+path);
        if (path.startsWith("/")) {
            if (path.endsWith("*")) {
                servletPath = path.substring(0, path.length() - 1);
            } else {
                servletPath = path;
            }
        } else {
            servletPath = "";
        }

        if (servletPath.endsWith("/")) {
            servletPath = servletPath.substring(0, servletPath.length() - 1);
        }
        logger.info("after padth="+path);
    }

    public String getServletPath() {
        return servletPath;
    }

    public String getPathInfo() {
        return httpServletRequest.getRequestURI().substring(
                httpServletRequest.getContextPath().length()
                        + servletPath.length());
    }
}
