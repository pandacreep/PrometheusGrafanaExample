package app.prometheusgrafanaexample.scheduler;

import app.prometheusgrafanaexample.service.CalcService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProjectScheduler {
    private final CalcService calcService;

    @Timed("timedScheduler")
    @Scheduled(fixedDelay = 10_000)
    public void callCalcTimeByScheduler() {
        long calcTime = calcService.getCalcTime();
        System.out.println(calcTime);
    }
}
