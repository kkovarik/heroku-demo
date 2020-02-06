package cz.kkovarik.herokudemo.springbootapp.counter.redis;

import cz.kkovarik.herokudemo.springbootapp.counter.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * @author Karel Kovarik
 */
public class CounterRedisImpl implements Counter {

    public static final String KEY = "herokudemo-counter";

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;

    @Override
    public Integer get() {
        Integer number = redisTemplate.opsForValue().get(KEY);
        if (null == number) {
            number = 0;
        }
        number = number + 1;

        redisTemplate.opsForValue().set(KEY, number);

        return number;
    }
}
