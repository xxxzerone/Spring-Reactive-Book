package chapter8;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * doOnXXXX 예제
 * - doOnXXXX() Operator의 호출 시점을 알 수 있다.
 */
@Slf4j
public class Example8_4 {

    public static void main(String[] args) throws InterruptedException {
        Flux.interval(Duration.ofMillis(1L))
                .onBackpressureLatest()
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException e) {}
                    log.info("# onNext: {}", data);
                },
                         error -> log.error("# onError", error));

        Thread.sleep(2000L);
    }
}
