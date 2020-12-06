package com.studiomediatech.example.varnished.event;

/**
 * Abstract event emitter, doesn't need to know about the framework - not very much. No thank you.
 */
@FunctionalInterface
public interface EventEmitter {

    void emitEvent(Object event);
}
