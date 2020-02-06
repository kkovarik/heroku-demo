package cz.kkovarik.herokudemo.springbootapp.counter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Karel Kovarik
 */
@Slf4j
@Configuration
public class CounterConfiguration {

    @ConditionalOnMissingBean(Counter.class)
    @Bean
    public Counter counterInMemory() {
        log.info("INMEMORY COUNTER IMPL");
        return new CounterInMemory();
    }
}
