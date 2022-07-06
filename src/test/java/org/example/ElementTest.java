package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void value() {
        System.out.println(Element.BE.label);
        assertThat(Element.valueOf("BE")).isEqualTo(Element.BE);
        assertThat(Element.valueOfLabel("Beryllium")).isEqualTo(Element.BE);
        assertThat(Element.valueOfLabel("Berylliums")).isNull();
        assertThat(Element.valueOfLabelFromMap("Beryllium")).isEqualTo(Element.BE);
        assertThat(Element.valueOfLabelFromMap("Berylliums")).isNull();

        assertThat(Element.valueOfAtomicNumberFromMap(1)).isEqualTo(Element.H);
        assertThat(Element.valueOfAtomicNumberFromMap(10)).isNull();
    }
}