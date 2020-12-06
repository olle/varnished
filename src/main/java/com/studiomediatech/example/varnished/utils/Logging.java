package com.studiomediatech.example.varnished.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface Logging {


    default Logger logger() {

        return LoggerFactory.getLogger(getClass());
    }
}
