package com.estudos.JavaRestWithSpringBoot.Exceptions;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
    public InvalidJwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidJwtAuthenticationException(String msg) {
        super(msg);
    }
}
