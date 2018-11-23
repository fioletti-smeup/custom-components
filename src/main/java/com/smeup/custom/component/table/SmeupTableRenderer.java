package com.smeup.custom.component.table;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@ResourceDependency(library = "smeup", name = "smeup-table.js")
@FacesRenderer(componentFamily = "smeup", rendererType = "SmeupTable")
public class SmeupTableRenderer extends Renderer {

    private static final String SCRIPT_TAG_NAME = "script";
    private static final String TAG_NAME = "smeup-table";

    @Override
    public void decode(FacesContext context, UIComponent component) {

        Map<String, List<ClientBehavior>> behaviors = ((ClientBehaviorHolder) component).getClientBehaviors();
        if (behaviors.isEmpty()) {
            return;
        }

        ExternalContext external = context.getExternalContext();
        Map<String, String> params = external.getRequestParameterMap();
        String behaviorEvent = params.get("javax.faces.behavior.event");
        if (behaviorEvent != null) {
            List<ClientBehavior> behaviorsForEvent = behaviors.get(behaviorEvent);

            if (behaviors.size() > 0) {
                String behaviorSource = params.get("javax.faces.source");
                String clientId = component.getClientId(context);
                if (behaviorSource != null && behaviorSource.equals(clientId)) {
                    for (ClientBehavior behavior : behaviorsForEvent) {
                        behavior.decode(context, component);
                    }
                }
            }
        }
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        SmeupTableComponent smeupTableComponent = (SmeupTableComponent) component;

        ClientBehaviorContext behaviorContext = ClientBehaviorContext.createClientBehaviorContext(context, component,
                "cellClicked", component.getClientId(context), null);

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("div", smeupTableComponent);
        writer.writeAttribute("id", component.getClientId(context), "id");
        writer.writeAttribute("name", component.getClientId(context), "id");
        
        writer.startElement(SCRIPT_TAG_NAME, smeupTableComponent);
        writer.writeText("var " + smeupTableComponent.getId() + "_value=" + smeupTableComponent.getValue() + ";", null);
        writer.endElement(SCRIPT_TAG_NAME);

        writer.startElement(TAG_NAME, smeupTableComponent);
        writer.writeAttribute("value", smeupTableComponent.getId() + "_value", null);
        // TODO What is third attribute for?

        Map<String, List<ClientBehavior>> behaviors = smeupTableComponent.getClientBehaviors();
        if (behaviors.containsKey("cellClicked")) {
            String cellClicked = behaviors.get("cellClicked").get(0).getScript(behaviorContext);
            writer.writeAttribute("onCellClicked", cellClicked, null);
            //writer.writeAttribute("onCellClicked", "jsf.ajax.request('"+component.getClientId(context)+"', event, options)", null);
        }
    }

    // responseWriter.write("Click);"
    // // writer.startElement(SCRIPT_TAG_NAME, smeupTableComponent);
    // // writer.writeText("document.getElementById(\"" +
    // smeupTableComponent.getId()
    // // + "\").addEventListener(\"cellClicked\", (e) => {jsf.ajax.request(\"" +
    // // smeupTableComponent.getId()
    // // + "\",e, {params: {cellValue:e.detail}});
    // // console.log(JSON.stringify(e.detail));});", null);
    // // writer.endElement(SCRIPT_TAG_NAME); }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }
        // SmeupTableComponent smeupTableComponent = (SmeupTableComponent) component;

        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(TAG_NAME);
        // writer.startElement(SCRIPT_TAG_NAME, smeupTableComponent);
        // writer.writeText("document.getElementById(\"" + smeupTableComponent.getId()
        // + "\").addEventListener(\"cellClicked\", (e) => {jsf.ajax.request(\"" +
        // smeupTableComponent.getId()
        // + "\",null, {params: {cellValue:e.detail}});
        // console.log(JSON.stringify(e.detail));});", null);
        // writer.endElement(SCRIPT_TAG_NAME);
    }
}
