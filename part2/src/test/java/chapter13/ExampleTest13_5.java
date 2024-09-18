package chapter13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class ExampleTest13_5 {

    @Test
    void taskNumberTest() {
        Flux<Integer> source = Flux.range(0, 1000);

        StepVerifier.create(GeneralTestExample.taskNumber(source, 500),
                        StepVerifierOptions.create().scenarioName("Verify from 0 to 499"))
                .expectSubscription()
                .expectNext(0)
                .expectNextCount(498)
                .expectNext(500)
                .expectComplete()
                .verify();
    }
}
