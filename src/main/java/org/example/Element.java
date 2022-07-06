package org.example;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public enum Element {
    H("Hydrogen",1),
    HE("Helium",2),
    LI("Lithium",3),
    BE("Beryllium",4);

    public final String label;
    public final int atomicNumber;

    private static final Map<String, Element> BY_LABEL = new HashMap<>();
    private static final Map<Integer, Element> BY_ATOMIC_NUMBER = new HashMap<>();

    static {
        for (Element e : values()) {
            BY_LABEL.put(e.label, e);
            BY_ATOMIC_NUMBER.put(e.atomicNumber, e);
        }
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

    public static Element valueOfAtomicNumberFromMap(int number){
        return BY_ATOMIC_NUMBER.get(number);
    }
}

