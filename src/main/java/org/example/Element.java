package org.example;

import java.util.HashMap;
import java.util.Map;

public enum Element {
    H("Hydrogen"),
    HE("Helium"),
    LI("Lithium"),
    BE("Beryllium");

    public final String label;

    private static final Map<String, Element> BY_LABEL = new HashMap<>();

    static {
        for (Element e : values()) {
            BY_LABEL.put(e.label, e);
        }
    }

    private Element(String label) {
        this.label = label;
    }

    public static Element valueOfLabel(String label){
        for (Element e : values()) {
            if(e.label.equals(label)){
                return e;
            }
        }
        return null;
    }

    public static Element valueOfLabelFromMap(String label){
        return BY_LABEL.get(label);
    }
}

