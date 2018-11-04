package com.nduyhai.cloudadventure.greetingservice.controller;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import com.nduyhai.cloudadventure.greetingservice.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Greeting> get(@PathVariable("id") Integer id) {
        return this.greetingService.findOne(id)
                .map(e -> new ResponseEntity<>(e, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

}
