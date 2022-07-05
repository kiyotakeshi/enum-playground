package org.example;

import lombok.Data;


@Data
public class Pizza {

    private PizzaStatus status;

    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }

    public boolean isDeliverable() {
        return getStatus() == PizzaStatus.READY;
    }

    public int getDeliveryTimeInDays() {
        switch (status) {
            case ORDERED:
                return 5;
            case READY:
                return 2;
            case DELIVERED:
                return 0;
        }
        return 0;
    }
}
