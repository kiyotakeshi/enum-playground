package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Pizza2Test {

    @Test
    void constructorAndMethod() {
        Pizza2 pizza = new Pizza2();
        pizza.setStatus(Pizza2.PizzaStatus.READY);

        assertThat(pizza.isDeliverable()).isTrue();
        pizza.printTimeToDeliver();
    }

    @Test
    void enumSet() {
        List<Pizza2> pizza2s = Arrays.asList(
                new Pizza2(Pizza2.PizzaStatus.DELIVERED),
                new Pizza2(Pizza2.PizzaStatus.ORDERED),
                new Pizza2(Pizza2.PizzaStatus.ORDERED),
                new Pizza2(Pizza2.PizzaStatus.READY)
        );

        List<Pizza2> allUndeliveredPizzas = Pizza2.getAllUndeliveredPizzas(pizza2s);
        // System.out.println(allUndeliveredPizzas);
        assertThat(allUndeliveredPizzas.size()).isEqualTo(3);
    }

    @Test
    void enumMap() {
        List<Pizza2> pizza2s = Arrays.asList(
                new Pizza2(Pizza2.PizzaStatus.DELIVERED),
                new Pizza2(Pizza2.PizzaStatus.ORDERED),
                new Pizza2(Pizza2.PizzaStatus.ORDERED),
                new Pizza2(Pizza2.PizzaStatus.READY)
        );
        EnumMap<Pizza2.PizzaStatus, List<Pizza2>> map = Pizza2.groupPizzaByStatus(pizza2s);
        assertThat(map.get(Pizza2.PizzaStatus.ORDERED).size()).isEqualTo(2);
        assertThat(map.get(Pizza2.PizzaStatus.READY).size()).isEqualTo(1);
        assertThat(map.get(Pizza2.PizzaStatus.DELIVERED).size()).isEqualTo(1);
    }
}