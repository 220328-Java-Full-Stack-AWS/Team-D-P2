package com.revature.GroupDP2.security;

import com.revature.GroupDP2.jwt.JwtUserDetailsService;
import com.revature.GroupDP2.jwt.TokenManager;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


@Component
public class CorsFilter extends OncePerRequestFilter {

    private final JwtUserDetailsService jwtUserDetailsService;
    private final TokenManager tokenManager;
    @Autowired
    public CorsFilter(JwtUserDetailsService jwtUserDetailsService,TokenManager tokenManager){
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.tokenManager = tokenManager;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String tokenHeader = req.getHeader("Authorization");
        String username = null;
        String token = null;


        Enumeration<String> headerNames = req.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                System.out.println("Header: " + req.getHeader(headerNames.nextElement()));
            }
        }

        System.out.println(tokenHeader);

        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            token = tokenHeader.substring(7);
            try{
                username = tokenManager.getUsernameFromToken(token);
            }
            catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        }
        else {

            System.out.println("No bearer string found");
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);
            if (tokenManager.validateToken(token,userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                  userDetails,null,userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        chain.doFilter(req,resp);

        /*
            resp.setHeader("Access-Control-Allow-Origin", "*");
            resp.setHeader("Access-Control-Allow-Methods", "*");
            resp.setHeader("Access-Control-Allow-Headers", "*");
            chain.doFilter(req, resp);
         */
    }
}