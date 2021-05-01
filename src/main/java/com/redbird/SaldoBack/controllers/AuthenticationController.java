package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.DTO.AuthenticationReqDTO;
import com.redbird.SaldoBack.models.User;
import com.redbird.SaldoBack.services.AuthenticationService;
import com.redbird.SaldoBack.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationReqDTO req){
        return authenticationService.authenticate(req);
    }

    @PostMapping("/registration")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
//    @PostMapping("/logout")
//    public void logout(HttpServletRequest req, HttpServletResponse res){
//        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
//        securityContextLogoutHandler.logout(req, res, null);
//    }
}