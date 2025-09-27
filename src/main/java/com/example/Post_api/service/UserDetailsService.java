package com.example.Post_api.service;

import com.example.Post_api.entity.User;
import com.example.Post_api.models.AuthLoginRequestDTO;
import com.example.Post_api.models.AuthResponseDTO;
import com.example.Post_api.repository.UserRepository;
import com.example.Post_api.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserEntityByUsername(username).orElseThrow(()-> new UsernameNotFoundException("Usuario " + username + " no encontrado"));

        List<SimpleGrantedAuthority> authority = new ArrayList<>();

        user.getRoles().forEach(role -> authority.add(new SimpleGrantedAuthority("ROLE_".concat(role.getNameRole()))));
        user.getRoles().stream()
                .flatMap(role -> role.getPermissions().stream()).forEach(permission -> authority.add(new SimpleGrantedAuthority(permission.getPermissionName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                user.isEnable(),
                user.isAccountNotExpired(),
                user.isCredentialNotExpired(),
                user.isAccountNotLocked(),authority);
    }

    public AuthResponseDTO loginUser(AuthLoginRequestDTO authLogin){
        String username = authLogin.username();
        String password = authLogin.password();

        Authentication authentication = this.authentication(username,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = jwtUtils.createToken(authentication);
        AuthResponseDTO response = new AuthResponseDTO(username,"Login succesfull",accessToken,true);
        return response;
    }

    public Authentication authentication (String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);
        if (userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid username or password");
        }
        return new UsernamePasswordAuthenticationToken(username,userDetails.getPassword(),userDetails.getAuthorities());
    }

}