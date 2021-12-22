package example.varnished.web;

public interface IndexWebAdapter {

    static IndexWebAdapter empty() {

        return new IndexWebAdapter() {

            // OK
        };
    }


    default String fetchGreeting() {

        return "World";
    }
}
