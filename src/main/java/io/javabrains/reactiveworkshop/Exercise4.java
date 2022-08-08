package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(s -> System.out.println(s));
        // Get the value from the Mono into an integer variable
        Integer i = ReactiveSources.intNumberMono().block();
        System.out.println(i);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
