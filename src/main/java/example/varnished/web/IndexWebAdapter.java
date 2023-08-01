package example.varnished.web;

public interface IndexWebAdapter {

    static IndexWebAdapter empty() {
        return new IndexWebAdapter() {
        };
    }

    default String fetchGreeting() {
        return "World";
    }
}
