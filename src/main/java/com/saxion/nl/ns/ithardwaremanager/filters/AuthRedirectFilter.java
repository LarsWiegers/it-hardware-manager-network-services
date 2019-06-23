package com.saxion.nl.ns.ithardwaremanager.filters;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthRedirectFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = ((HttpServletRequest) request).getSession();
        if(
            session.getAttribute("user") == null && (
            !(req.getRequestURL().toString().split("localhost:8080")[1].equals("/login")) &&
            !(req.getRequestURL().toString().split("localhost:8080")[1].equals("/register")) &&
            !(req.getRequestURL().toString().split("localhost:8080")[1].equals("/logout"))
            && !req.getRequestURL().toString().split("localhost:8080")[1].equals("/css/layout.css"))) {
            res.sendRedirect("/login");
        }
        chain.doFilter(request, response);
    }

    // other methods
}
