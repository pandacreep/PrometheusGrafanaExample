package app.prometheusgrafanaexample.controller;

import app.prometheusgrafanaexample.service.CalcService;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {
    private final CalcService calcService;

    @Timed("timedControllerHello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello! LocalDateTime: " + LocalDateTime.now();
    }

    @GetMapping("/calc")
    public String calc() {
        return "Calculation time (ms): " + calcService.getCalcTime();
    }
}
