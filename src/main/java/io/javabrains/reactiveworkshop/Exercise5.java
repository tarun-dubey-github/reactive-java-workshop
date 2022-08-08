package io.javabrains.reactiveworkshop;

import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed...")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userFlux().subscribe(new BaseSubscriber(){
            @Override
            protected void hookOnNext(Object value) {
                 System.out.println("base subscriber---> "+value);
            }

            @Override
            protected void hookOnComplete() {
                System.out.println("base subscriber---> "+"COMPLETE");
            }

            @Override
            protected void hookOnError(Throwable throwable) {
                System.out.println("base subscriber---> ERROR "+throwable.getMessage());
            }

            @Override
            protected void hookFinally(SignalType type) {
                System.out.println("base subscriber---> "+"finally");

            }
        });
        System.out.println("Press a key to end");
        System.in.read();
    }

}