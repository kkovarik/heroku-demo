package cz.kkovarik.herokudemo.springbootapp.counter;

/**
 * @author Karel Kovarik
 */
public class CounterInMemory implements Counter {

    private int counter = 0;

    @Override
    public Integer get() {
        return counter++;
    }
}
