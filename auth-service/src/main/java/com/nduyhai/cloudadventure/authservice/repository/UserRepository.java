package com.nduyhai.cloudadventure.authservice.repository;

import com.nduyhai.cloudadventure.authservice.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
