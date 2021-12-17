package com.studiomediatech.example.varnished.web.frobulator;

import com.studiomediatech.example.varnished.app.frobulator.Frobulator;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Now look, this is a really hard one to resist - don't go extend the new-frobulator form at this point. You must
 * stave off that tickling in your fingers, that urge in your brain, to *extend*. Why you say? Firstly, rule of three -
 * three or more, use a for. This may be the only other form for frobulator that we need to model, in which case we
 * only have two of something. Again rule of three - three or more use a for. Secondly, it's way to early to decide or
 * know, if validation rules for editing etc actually align with _all_ or _exactly_ the rules when creating. Let's wait
 * it out and see.
 */
public class EditFrobulatorForm {

    @NotNull
    @Size(min = 2, max = 64)
    private String name;

    @Range(min = 0)
    private Long category;

    public String getName() {

        return name;
    }


    public void setName(String name) {

        this.name = name;
    }


    public Long getCategory() {

        return category;
    }


    public void setCategory(Long category) {

        this.category = category;
    }


    public static EditFrobulatorForm fromFrobulator(Frobulator frobulator) {

        EditFrobulatorForm form = new EditFrobulatorForm();
        form.name = frobulator.getName();

        return form;
    }
}
