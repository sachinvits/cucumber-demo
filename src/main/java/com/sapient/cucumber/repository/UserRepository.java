package com.sapient.cucumber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sapient.cucumber.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {

}
