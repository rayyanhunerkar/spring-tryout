package com.rayyanhunerkar.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionController extends ResponseStatusException {

    public ExceptionController(HttpStatusCode status, String reason) {
        super(status, reason);
    }
}
