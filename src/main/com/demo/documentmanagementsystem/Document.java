package src.main.com.demo.documentmanagementsystem;

import java.util.Map;

public class Document {

    private Map<String, String> attributes;

    Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String attributeName) {
        return this.attributes.get(attributeName);
    }

}
