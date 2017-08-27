package com.nduyhai.cloudadventure.greetingservice.controller;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import com.nduyhai.cloudadventure.greetingservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @RequestMapping(method = RequestMethod.GET)
    public Greeting greeting() {
        return this.greetingService.random();
    }

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody Greeting greeting) {
        this.greetingService.create(greeting);
    }
}
