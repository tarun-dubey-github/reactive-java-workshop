package io.javabrains.reactiveworkshop;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("-----------  Print all numbers in the intNumbersStream stream");

        StreamSources.intNumbersStream()
                .forEach(System.out::println);


        System.out.println("-----------  Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(i -> System.out.println(i));


        System.out.println("-----------  Print the second and third numbers in intNumbersStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .skip(1)
                .limit(2)
                .forEach(i -> System.out.println(i));


        System.out.println("-----------   Print the first number in intNumbersStream that's greater than 5.If nothing is found, print -1");
        System.out.println(StreamSources.intNumbersStream()
                .filter(i -> i > 55)
                .findFirst().orElse(-1));


        System.out.println("-----------  Print first names of all users in userStream");
        StreamSources.userStream()
                .forEach(u -> System.out.println(u.getFirstName()));

        System.out.println("----------- Print first names in userStream for users that have IDs from number stream");

         StreamSources.userStream()
                .filter(u -> StreamSources.intNumbersStream().anyMatch(u1 -> u1 == u.getId()))
                .forEach(u -> System.out.println(u.getId() + "----" + u.getFirstName()));

        System.out.println("----------- Print first names in userStream for users that have IDs from number stream");

         StreamSources.intNumbersStream()
                 .flatMap(id -> StreamSources.userStream().filter(user -> user.getId()==id))
                .forEach(u -> System.out.println(u.getId() + "----" + u.getFirstName()));
    }

}
