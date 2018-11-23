package com.smeup.custom.component.wordcount;

import java.io.IOException;

import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@ResourceDependency(library="smeup", name="word-count.js")
@FacesRenderer(componentFamily = "smeup", rendererType = "WordCount")
public class WordCountRenderer extends Renderer {

    private static final String TAG_NAME = "word-count";

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement(TAG_NAME, component);
        writer.writeAttribute("name", component.getId(), "id");
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }
        ResponseWriter writer = context.getResponseWriter();
        writer.endElement(TAG_NAME);
    }
}
