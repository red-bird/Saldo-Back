package com.redbird.SaldoBack.servicesImpl;

import com.redbird.SaldoBack.DTO.AuthenticationReqDTO;
import com.redbird.SaldoBack.models.User;
import com.redbird.SaldoBack.repositories.UserRepository;
import com.redbird.SaldoBack.security.JwtTokenProvider;
import com.redbird.SaldoBack.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public ResponseEntity<?> authenticate(AuthenticationReqDTO req) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
            User user = userRepository.findByUsername(req.getEmail());
            String token = jwtTokenProvider.createToken(req.getEmail());
            Map<Object, Object> res = new HashMap<>();
            res.put("email", req.getEmail());
            res.put("token", token);

            return ResponseEntity.ok(res);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password combination or banned", HttpStatus.FORBIDDEN);
        }
    }
}
