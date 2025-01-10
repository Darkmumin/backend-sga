package com.jai.darkmumin.sga.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.Access;
import com.jai.darkmumin.sga.models.User;
import com.jai.darkmumin.sga.utils.JwtUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthService {
    AuthenticationManager authenticationManager;
    UserDetailsService userDetails;
    JwtUtils jwtUtils;
    UserService userService;
    public Access login(User username) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username.username, username.password)
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = userService.loadUserByUsername(username.username);
            String jwtToken = jwtUtils.generateToken(userDetails);
            Access access = new Access(jwtToken);
            return access;
        }catch(AuthenticationException e){
            e.printStackTrace();
            return null;
        }
    }
}
