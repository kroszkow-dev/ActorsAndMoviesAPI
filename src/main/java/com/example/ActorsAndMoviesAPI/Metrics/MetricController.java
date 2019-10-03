package com.example.ActorsAndMoviesAPI.Metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MetricController {

    @Autowired
    private MetricService metricService;

    @GetMapping("/status-metric")
    public Map getStatusMetric() {
        return metricService.getStatusMetric();
    }
}
