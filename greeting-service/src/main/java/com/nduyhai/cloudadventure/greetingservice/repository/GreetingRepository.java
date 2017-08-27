package com.nduyhai.cloudadventure.greetingservice.repository;

import com.nduyhai.cloudadventure.greetingservice.domain.Greeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends CrudRepository<Greeting, Integer> {

}
