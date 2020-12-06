package com.studiomediatech.example.varnished.web.frobulator;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public final class WebFrobulatorDetailsNotFoundException extends RuntimeException {
}
