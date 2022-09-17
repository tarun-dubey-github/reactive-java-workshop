package io.javabrains.reactiveworkshop;

import java.io.IOException;

import javax.sound.sampled.SourceDataLine;

public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns
        //  System.out.println(ReactiveSources.intNumbersFlux().count().block());
        // Collect all items of intNumbersFlux into a single list and print it
        // TODO: Write code here
        //System.out.println(ReactiveSources.intNumbersFlux().collectList().block());
        // Transform to a sequence of sums of adjacent two numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
        .buffer(2)
        .map(l -> l.size()>1?l.get(0)+l.get(1):l.get(0))
        .subscribe(System.out::print);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
