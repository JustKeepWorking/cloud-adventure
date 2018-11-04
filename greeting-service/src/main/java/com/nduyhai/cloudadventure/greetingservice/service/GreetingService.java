package com.nduyhai.cloudadventure.greetingservice.service;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import com.nduyhai.cloudadventure.greetingservice.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

    public Greeting random() {
        List<Greeting> list = StreamSupport.stream(this.greetingRepository.findAll().spliterator(), false).collect(Collectors.toList());
        int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.get(randomNum);
    }

    public Optional<Greeting> findOne(Integer id) {
        return this.greetingRepository.findById(id);
    }

    public void create(Greeting greeting) {
        this.greetingRepository.save(greeting);
    }

    public void delete(Greeting greeting) {
        this.greetingRepository.delete(greeting);
    }
}
