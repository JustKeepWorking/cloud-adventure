package com.nduyhai.cloudadventure.monitoring.service;

import com.nduyhai.cloudadventure.monitoring.domain.Greeting;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "greeting-service")
public interface GreetingService {
    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Greeting get(@PathVariable("id") Integer id);
}
