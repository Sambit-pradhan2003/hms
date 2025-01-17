package com.hms.config;

import com.hms.ThirdpartyService.JwtService;
import com.hms.entity.User;
import com.hms.repo.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private UserRepository userRepository;

    public JwtFilter(JwtService jwtService, UserRepository userRepository) {

        this.jwtService = jwtService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearertoken  = request.getHeader("Authorization");
        if (bearertoken != null && bearertoken.startsWith("Bearer")) {
            System.out.println(bearertoken);
            String substring = bearertoken.substring(7, bearertoken.length());
            String uname = jwtService.decodetoken(substring);
            Optional<User> name=userRepository.getByName(uname);
            if(name.isPresent()){
                User appuser=name.get();
                System.out.println(appuser.getName());
                System.out.println(appuser.getPassword());
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(appuser, null, Collections.singleton(new SimpleGrantedAuthority((appuser.getRole()))));
                authenticationToken.setDetails( new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }



        }


        filterChain.doFilter(request, response);

    }
}
