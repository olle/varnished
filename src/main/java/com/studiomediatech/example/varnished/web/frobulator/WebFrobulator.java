package com.studiomediatech.example.varnished.web.frobulator;

/**
 * This is an explicit frobulator, built for web. We fully decouple any notion of this being a domain model or business
 * object, it is a DTO or a pimped up struct. That's what I'm talking 'bout!
 */
public class WebFrobulator {

    private final String key;

    public WebFrobulator(String key) {

        this.key = key;
    }

    @Override
    public String toString() {

        return "WebFrobulator [key=" + key + "]";
    }


    public static WebFrobulator valueOf(String value) {

        return new WebFrobulator(value);
    }
}
