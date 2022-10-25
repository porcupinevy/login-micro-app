package com.springsecurityhibernatejwt.tok;

import com.springsecurityhibernatejwt.tok.jwt.JwtTokenProvider;
import com.springsecurityhibernatejwt.tok.payload.LoginRequest;
import com.springsecurityhibernatejwt.tok.payload.LoginResponse;
import com.springsecurityhibernatejwt.tok.payload.RandomStuff;
import com.springsecurityhibernatejwt.tok.user.CustomUserDetails;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class VnfiteRestController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenricateUser(@NotNull @Valid @RequestBody LoginRequest loginRequest){
        //Xac thuc tu username & pass
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        //Neu khong xay ra ex tuc la thong tin hop le
        //Set thong tin authentication vao Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Tra ve jwt cho nguoi dung
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }
    //Api/random yeu cau phai xac thuc moi co the request
    @GetMapping("/random")
    public RandomStuff randomStuff (){
        return new RandomStuff("JWT Hop le moi co the thay duoc message nay");
    }

}
