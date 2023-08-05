package example.varnished.infra.event;

@FunctionalInterface
public interface EventEmitter {

    void emitEvent(Object event);

}