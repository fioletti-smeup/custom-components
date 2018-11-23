package com.smeup.custom.component.table;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.behavior.ClientBehaviorHolder;

@FacesComponent("SmeupTable")
public class SmeupTableComponent extends UIComponentBase implements ClientBehaviorHolder {

    protected enum PropertyKeys {

        value
    }

    @Override
    public String getFamily() {
        return "smeup";
    }

    public String getValue() {
        return (String) getStateHelper().eval(PropertyKeys.value, null);
    }

    public void setValue(final String value) {
        getStateHelper().put(PropertyKeys.value, value);
    }

    @Override
    public Collection<String> getEventNames() {
        return Collections.unmodifiableList(Arrays.asList("cellClicked"));
    }
}
