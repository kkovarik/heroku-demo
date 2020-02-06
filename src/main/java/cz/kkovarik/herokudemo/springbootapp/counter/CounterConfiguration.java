package cz.kkovarik.herokudemo.springbootapp.counter;

import cz.kkovarik.herokudemo.springbootapp.counter.redis.CounterRedisImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Karel Kovarik
 */
@Slf4j
@Configuration
public class CounterConfiguration {

    @Bean
    public RedisTemplate<String, Integer> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Integer> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    @Bean
    public Counter redisCounter() {
        log.info("REDIS COUNTER IMPL");
        return new CounterRedisImpl();
    }

    @ConditionalOnMissingBean(Counter.class)
    @Bean
    public Counter counterInMemory() {
        log.info("INMEMORY COUNTER IMPL");
        return new CounterInMemory();
    }
}
