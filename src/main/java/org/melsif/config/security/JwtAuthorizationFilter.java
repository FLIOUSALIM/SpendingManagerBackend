package org.melsif.config.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtProperties jwtProperties;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }


    @Override
    public void doFilterInternal(HttpServletRequest req,
                                HttpServletResponse res,
                                FilterChain filterChain) throws IOException, ServletException {
        String header = req.getHeader(jwtProperties.getHeader());
        if (header == null || !header.startsWith(jwtProperties.getToken())) {
            filterChain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
        String token = req.getHeader(jwtProperties.getHeader());
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey(jwtProperties.getSecret().getBytes())
                    .parseClaimsJws(token.replace(jwtProperties.getToken(), ""))
                    .getBody()
                    .getSubject();

            if (user != null) {
                return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
            }
            return null;
        }
        return null;
    }

}
