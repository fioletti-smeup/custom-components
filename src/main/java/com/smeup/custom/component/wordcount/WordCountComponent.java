package com.smeup.custom.component.wordcount;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(value="WordCount")
public class WordCountComponent extends UIComponentBase {

    @Override
    public String getFamily() {
        return "smeup";
    }
}
