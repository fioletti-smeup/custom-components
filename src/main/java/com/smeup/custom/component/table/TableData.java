package com.smeup.custom.component.table;

import java.io.Serializable;

import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TableData implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private String content = "{\"name\":\"Luca\"}";
    private String content2 = "{\"name\":\"Franco\"}";

    private String content3 = "{\n" + "    \"table\": {\n" + "        \"caption\": \"Caption_text\",\n"
            + "        \"rows\": [\n" + "            {\n" + "                \"cells\":[\"a\",\"b\"]\n"
            + "            },\n" + "            {\n" + "                \"cells\":[\"c\",\"d\"]\n" + "            }\n"
            + "        ]\n" + "    }\n" + "}\n" + "";

    private String content4 = "{\n" + 
            "    \"table\": {\n" + 
            "        \"caption\": \"Caption_text\",\n" + 
            "        \"rows\": [\n" + 
            "            {\n" + 
            "                \"cells\":[\"a1\",\"a2\",\"a3\"]\n" + 
            "            },\n" + 
            "            {\n" + 
            "                \"cells\":[\"b1\",\"b2\",\"b3\"]\n" + 
            "            },\n" + 
            "            {\n" + 
            "                \"cells\":[\"c1\",\"c2\",\"c3\"]\n" + 
            "            }\n" + 
            "        ]\n" + 
            "    }\n" + 
            "}\n" + 
            "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent2() {
        return content2;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }

    public String getContent3() {
        return content3;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }

    public String getContent4() {
        return content4;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }
    
    public void onCellClicked(AjaxBehaviorEvent event) {
        System.out.println("Cell clicked");
    }
}
