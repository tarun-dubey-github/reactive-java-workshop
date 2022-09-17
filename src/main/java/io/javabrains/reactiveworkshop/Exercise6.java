package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Mono;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Exercise6 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.unresponsiveFlux() and ReactiveSources.unresponsiveMono()

      //  ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));

        // Get the value from the Mono into a String variable but give up after 5 seconds

        // Get the value from unresponsiveFlux into a String list but give up after 5 seconds
        // Come back and do this when you've learnt about operators!
        Mono<List<String>> listMono = ReactiveSources.unresponsiveFlux().timeout(Duration.ofSeconds(5)).collectList();
       System.out.println(listMono.block());
        System.out.println("Press a key to end");
        System.in.read();
    }

}
