package com.example.CrudProject.Confugue;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

    public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(
                HttpServletRequest request,
                HttpServletResponse response,
                Authentication authentication) throws ServletException, IOException {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals("ADMIN")) {
                    // Redirect to the dashboard if the user has the ADMIN role
                    setDefaultTargetUrl("/dashboard");
                    break;
                } else if (authority.getAuthority().equals("READER")) {
                    // Redirect to a different page if the user has the READER role
                    setDefaultTargetUrl("/reader-dashboard");
                    break;
                }
            }
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }


