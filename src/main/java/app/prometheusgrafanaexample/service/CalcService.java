package app.prometheusgrafanaexample.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CalcService {
    private AtomicInteger rand = new AtomicInteger();
    public AtomicInteger getRand() { return rand; }
    public void setRand(AtomicInteger rand) { this.rand = rand; }

    public CalcService(MeterRegistry meterRegistry) {
        meterRegistry.gauge("randValue", rand);
    }

    public long getCalcTime() {
        return calcLongMethod();
    }

    private long calcLongMethod() {
        Random r = new Random();
        long start = System.nanoTime();
        long sum = 0;
        int higherIntBorder = Integer.MAX_VALUE;
        for (int i = 0; i < higherIntBorder; i++) {
            sum += i;
        }
        rand.set(r.nextInt(10));
        sum -= getRand().get();
        long end = System.nanoTime();

        System.out.println("start " + start + ", end " + end + ",  rand " + getRand());

        return (end - start) / 1_000_000;
    }
}
