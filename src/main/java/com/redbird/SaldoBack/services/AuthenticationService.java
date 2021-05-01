package com.redbird.SaldoBack.services;

import com.redbird.SaldoBack.DTO.AuthenticationReqDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    public ResponseEntity<?> authenticate(AuthenticationReqDTO req);
}
