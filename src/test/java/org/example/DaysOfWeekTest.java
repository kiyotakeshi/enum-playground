package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class DaysOfWeekTest {

    @Test
    void iterate() {
//        for (DaysOfWeek day : DaysOfWeek.values()) {
//            System.out.println(day);
//        }

        Arrays.stream(DaysOfWeek.values())
                // .forEach(day -> System.out.println(day));
                .forEach(System.out::println);
    }

    @Test
    void iterate2() {
        // Arrays.stream(DaysOfWeek.values())
        Stream.of(DaysOfWeek.values())
                .filter(d -> d.getTypeOfDay().equals("off"))
                .forEach(System.out::println);
    }

    @Test
    void iterate3() {
        List<DaysOfWeek> days = Arrays.asList(
                DaysOfWeek.FRIDAY,
                DaysOfWeek.MONDAY,
                DaysOfWeek.SUNDAY
        );

        List<DaysOfWeek> working = days.stream()
                .filter(day -> day.getTypeOfDay().contains("working"))
                .collect(Collectors.toList());

        working.forEach(System.out::println);
        // working.forEach(w -> System.out.println(w.getTypeOfDay()));
    }
}