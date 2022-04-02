package com.example.twoApi.service.metrics;

import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
@EnableScheduling
public class CountMetricService {
    private final AtomicInteger demoCustomMetricSuccess;
    private final AtomicInteger demoCustomMetricFail;

    public CountMetricService(MeterRegistry meterRegistry) {
        this.demoCustomMetricSuccess = meterRegistry.gauge("demo_counter_success", new AtomicInteger(0));
        this.demoCustomMetricFail = meterRegistry.gauge("demo_counter_fail", new AtomicInteger(0));
    }

    public void increment(AtomicInteger atomicInteger) {
        atomicInteger.incrementAndGet();
    }

    public void incrementCounter() {
        increment(demoCustomMetricSuccess);
    }

    public void incrementGauge() {
        increment(demoCustomMetricSuccess);
    }

    @Scheduled(cron = "0 0 8 * * *", zone = "Europe/Moscow")
    public void setStartValueForCounters() {
        demoCustomMetricSuccess.set(0);
        demoCustomMetricFail.set(0);
    }


}
