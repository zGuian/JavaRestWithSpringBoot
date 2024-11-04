package com.estudos.JavaRestWithSpringBoot.Controllers;

import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.Security.AccountCredentialsVO;
import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.UserVO;
import com.estudos.JavaRestWithSpringBoot.Services.AuthServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Endpoint")
public class AuthController {
    @Autowired
    private AuthServices authServices;

    @Operation(summary = "Authenticates a user and returns a token")
    @PostMapping(value = "/signing", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signIn(@RequestBody AccountCredentialsVO data) {
        if (data == null || data.getUserName().isEmpty() || data.getUserName().isBlank() ||
                data.getPassword().isEmpty() || data.getPassword().isBlank()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        var token = authServices.signIn(data);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        return ResponseEntity.ok(token);
    }

    @PutMapping(value = "/refresh-token/{username}")
    @Operation(summary = "")
    public ResponseEntity<?> refreshToken (@PathVariable("username") String username,
                                           @RequestHeader("Authorization") String refreshToken) {
        if (refreshToken == null || refreshToken.isEmpty() || refreshToken.isBlank() ||
               username == null || username.isEmpty() || username.isBlank()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        var token = authServices.refreshToken(username, refreshToken);
        if (token == null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request!");
        }
        return ResponseEntity.ok(token);
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create user")
    public void create(@RequestBody UserVO userVO) {
        authServices.register(userVO);
    }
}
