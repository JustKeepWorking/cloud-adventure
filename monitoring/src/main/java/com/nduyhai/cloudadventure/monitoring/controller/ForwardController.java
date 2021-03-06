package com.nduyhai.cloudadventure.monitoring.controller;

import com.nduyhai.cloudadventure.monitoring.domain.Greeting;
import com.nduyhai.cloudadventure.monitoring.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/forward")
public class ForwardController {

    @Autowired
    private GreetingService greetingService;

    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/quote/{id}", method = RequestMethod.GET)
    public ResponseEntity<Greeting> get(@PathVariable("id") Integer id) {
        try {
            final Greeting greeting = greetingService.get(id);
            return new ResponseEntity<>(greeting, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("OK", HttpStatus.OK);

    }
}
