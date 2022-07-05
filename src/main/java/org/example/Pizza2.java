package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pizza2 {

    private static EnumSet<PizzaStatus> undeliveredPizzaStatus = EnumSet.of(PizzaStatus.ORDERED, PizzaStatus.READY);

    private PizzaStatus status;

    @Getter
    @AllArgsConstructor
    public enum PizzaStatus {

        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("time to deliver is " + this.getStatus().getTimeToDelivery() + " days");
    }

    static List<Pizza2> getAllUndeliveredPizzas(List<Pizza2> pizzas) {
        return pizzas.stream()
                .filter(p -> undeliveredPizzaStatus.contains(p.getStatus()))
                .collect(Collectors.toList());
    }

    static EnumMap<PizzaStatus, List<Pizza2>> groupPizzaByStatus(List<Pizza2> pizzas) {
        return pizzas.stream()
                // .collect(Collectors.groupingBy(p -> p.getStatus(), () -> new EnumMap<>(PizzaStatus.class), Collectors.toList()));
                .collect(Collectors.groupingBy(Pizza2::getStatus, () -> new EnumMap<>(PizzaStatus.class), Collectors.toList()));
    }
}
