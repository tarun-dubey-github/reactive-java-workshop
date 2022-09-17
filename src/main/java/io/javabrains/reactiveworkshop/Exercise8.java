package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.time.Duration;

import javax.sound.sampled.SourceDataLine;

import reactor.core.publisher.Flux;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // ReactiveSources.intNumbersFluxWithException().log().subscribe(System.out::println,x -> System.out.println(x.getMessage()));
        
        // Print values from intNumbersFluxWithException and continue on errors
        // ReactiveSources.intNumbersFluxWithException()
        // .onErrorContinue((x , item )-> System.out.println("Error"+x+" : on item "+item))
        // .subscribe(System.out::println);
        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        ReactiveSources.intNumbersFluxWithException()
        .onErrorResume(err -> Flux.just(-1, -2).delayElements(Duration.ofSeconds(1)))
         .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
