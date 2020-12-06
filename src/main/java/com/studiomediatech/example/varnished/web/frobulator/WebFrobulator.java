package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;


/**
 * This is an explicit frobulator, built for web. We fully decouple any notion of this being a domain model or business
 * object, it is a DTO or a pimped up struct. That's what I'm talking 'bout!
 */
public class WebFrobulator {

    private final String name;

    private String key;

    public WebFrobulator(String name) {

        this.name = name;
    }

    @Override
    public String toString() {

        return "WebFrobulator [name=" + name + "]";
    }


    void setKey(String key) {

        this.key = key;
    }


    public String getKey() {

        return key;
    }


    public static WebFrobulator fromFrobulator(Frobulator frobulator) {

        return new WebFrobulator(frobulator.getName());
    }
}
