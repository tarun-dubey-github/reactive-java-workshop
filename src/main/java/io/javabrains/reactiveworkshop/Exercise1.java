package io.javabrains.reactiveworkshop;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("-----------  Print all numbers in the intNumbersStream stream");

        StreamSources.intNumbersStream()
                .forEach(i -> System.out.println(i));


        System.out.println("-----------  Print numbers from intNumbersStream that are less than 5");
        StreamSources.intNumbersStream()
                .filter(i -> i < 5)
                .forEach(i -> System.out.println(i));


        System.out.println("-----------  Print the second and third numbers in intNumbersStream that's greater than 5");
        final AtomicInteger idx = new AtomicInteger(0);
        record Rec(Integer idx, Integer val) {
        }
        StreamSources.intNumbersStream()
                .filter(i -> i > 5)
                .map(i -> new Rec(idx.getAndIncrement(), i))
                .filter(rec -> rec.idx == 1 || rec.idx == 2)
                .forEach(i -> System.out.println(i.val));


        System.out.println("-----------   Print the first number in intNumbersStream that's greater than 5.If nothing is found, print -1");
        System.out.println(StreamSources.intNumbersStream()
                .filter(i -> i > 55)
                .findFirst().orElse(-1));


        System.out.println("-----------  Print first names of all users in userStream");
        StreamSources.userStream()
                .forEach(u -> System.out.println(u.getFirstName()));

        System.out.println("----------- Print first names in userStream for users that have IDs from number stream");

        List<Integer> ids = StreamSources.intNumbersStream().toList();
        StreamSources.userStream()
                .filter(u -> ids.contains(u.getId()))
                .forEach(u -> System.out.println(u.getId() + "----" + u.getFirstName()));
    }

}
