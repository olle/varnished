package example.varnished.infra.event;

@FunctionalInterface
interface EventEmitter {
    void emitEvent(Object event);
}