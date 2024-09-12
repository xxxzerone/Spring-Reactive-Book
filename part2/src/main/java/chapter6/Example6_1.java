package chapter6;

import reactor.core.publisher.Mono;

public class Example6_1 {

    public static void main(String[] args) {
        Mono.just("Hello Reactor")
                .subscribe(System.out::println);
    }
}
