package com.example.ActorsAndMoviesAPI.Metrics;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MetricService {
    private ConcurrentMap<String, Integer> statusMetric;

    public MetricService() {
        statusMetric = new ConcurrentHashMap<String, Integer>();
    }

    public void increaseCount(String user) {
        Integer statusCount = statusMetric.get(user);
        if (statusCount == null) {
            statusMetric.put(user, 1);
        } else {
            statusMetric.put(user, statusCount + 1);
        }
    }

    public Map getStatusMetric() {
        return statusMetric;
    }
}
