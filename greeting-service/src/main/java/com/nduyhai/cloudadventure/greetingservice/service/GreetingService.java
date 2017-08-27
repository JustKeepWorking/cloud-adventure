package com.nduyhai.cloudadventure.greetingservice.service;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import com.nduyhai.cloudadventure.greetingservice.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting random() {
        List<Greeting> list = StreamSupport.stream(this.greetingRepository.findAll().spliterator(), false).collect(Collectors.toList());
        Collections.shuffle(list);
        return list.get(0);
    }

    public Greeting findOne(Integer id) {
        return this.greetingRepository.findOne(id);
    }

    public void create(Greeting greeting) {
        this.greetingRepository.save(greeting);
    }

    public void delete(Greeting greeting) {
        this.greetingRepository.delete(greeting);
    }
}
