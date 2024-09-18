package chapter13;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class ExampleTest13_16 {

    @Test
    void getCityTest() {
        StepVerifier.create(RecordTestExample.getCapitalizedCountry(
                Flux.just("korea", "england", "canada", "india"))
        )
                .expectSubscription()
                .recordWith(ArrayList::new)
                .thenConsumeWhile(country -> !country.isEmpty())
                .consumeRecordedWith(countries -> {
                    assertThat(countries.stream()
                            .allMatch(country -> Character.isUpperCase(country.charAt(0)))
                    ).isTrue();
                })
                .expectComplete()
                .verify();
    }
}
