package com.studiomediatech.example.varnished.web.frobulator;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;
import com.studiomediatech.example.varnished.utils.Logging;

/**
 * Adapter (AGAIN!) to any possible access to a list of frobulators, but we are
 * responsible for transforming any core models or domain objects into pretty
 * little web-frobulator instances.
 */
public class WebFrobulators implements Logging {

    private final FrobulatorWebAccess webAccess;

    private Map<String, String> index = new ConcurrentHashMap<>();

    public WebFrobulators(FrobulatorWebAccess frobulatorWebAccess) {

        this.webAccess = frobulatorWebAccess;
    }

    public String listFrobulators(BiConsumer<String, Object> sink) {

        sink.accept("frobulators", list());

        return "frobulators/list";
    }

    private Collection<WebFrobulator> list() {

        Collection<Frobulator> frobulators = webAccess.listFrobulatorsForWeb();

        List<WebFrobulator> results = new ArrayList<>();

        for (Frobulator frobulator : frobulators) {
            String key = mapToKey(frobulator);

            WebFrobulator webFrobulator = WebFrobulator.fromFrobulator(frobulator);
            webFrobulator.setKey(key);

            results.add(webFrobulator);
        }

        return results;
    }

    private String mapToKey(Frobulator frobulator) {

        String key = calculateKey(frobulator);
        index.put(key, frobulator.getName());

        return key;
    }

    private static String calculateKey(Frobulator frobulator) {

        return UUID.nameUUIDFromBytes(("secret-" + frobulator.getName()).getBytes(StandardCharsets.UTF_8)).toString();
    }

    public String frobulatorDetails(BiConsumer<String, Object> sink, String key) {

        sink.accept("frobulator",
                getFrobulatorDetails(key).orElseThrow(() -> new WebFrobulatorDetailsNotFoundException()));

        return "frobulators/view";
    }

    private Optional<WebFrobulatorDetails> getFrobulatorDetails(String key) {

        String name = index.get(key);

        if (name == null) {
            return Optional.empty();
        }

        return webAccess.getFrobulatorByNameForWeb(name).map(WebFrobulatorDetails::fromFrobulator);
    }

    public String createFrobulator(BiConsumer<String, Object> sink, NewFrobulatorForm form, BindingResult errors,
            RedirectAttributes redirect) {

        Supplier<Boolean> failed = () -> errors.hasErrors();

        if (failed.get()) {
            logger().error("Invalid frobulator form {}", errors);

            return "frobulators/new";
        }

        webAccess.addFrobulatorFromWeb(form.toFrobulator());

        return "redirect:/frobulators";
    }

    public String editFrobulator(BiConsumer<String, Object> sink, String key) {

        logger().debug("Resolving frobulator for editing {}", key);

        sink.accept("frobulator",
                getEditFrobulatorForm(key).orElseThrow(() -> new WebFrobulatorDetailsNotFoundException()));

        return "frobulators/edit";
    }

    private Optional<EditFrobulatorForm> getEditFrobulatorForm(String key) {

        String name = index.get(key);

        if (name == null) {
            return Optional.empty();
        }

        logger().debug("Found frobulator name to lookup {}", name);

        return webAccess.getFrobulatorByNameForWeb(name).map(EditFrobulatorForm::fromFrobulator);
    }

    public String deleteFrobulator(BiConsumer<String, Object> sink, String key) {

        Optional.ofNullable(index.get(key)).ifPresent(webAccess::deleteFrobulatorFromWebByName);

        return "redirect:/frobulators";
    }
}
