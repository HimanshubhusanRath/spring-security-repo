package com.hr.springboot.oauth.social.login.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * 
 * This filter is added to redirect to 127.0.0.1 when localhost is mentioned.
 * 
 * Note: Using "localhost" is not working correctly with Spring authorization server (>0.2.0).
 * So, we are redirecting localhost to 127.0.0.1 (ip address) using this filter.
 * 
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IPRedirectionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getServerName().equals("localhost")) {
            UriComponents uri = UriComponentsBuilder.fromHttpRequest(new ServletServerHttpRequest(request))
                    .host("127.0.0.1").build();
            response.sendRedirect(uri.toUriString());
            return;
        }
        filterChain.doFilter(request, response);
    }

}