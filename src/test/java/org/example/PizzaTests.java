package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PizzaTests {

    @Test
    void create() {
        Pizza pizza = new Pizza();
        pizza.setStatus(Pizza.PizzaStatus.READY);
        assertThat(pizza.isDeliverable()).isTrue();
    }

    @Test
    void caseMethod() {
        Pizza pizza = new Pizza();
        pizza.setStatus(Pizza.PizzaStatus.READY);
        assertThat(pizza.getDeliveryTimeInDays()).isEqualTo(2);
    }
}