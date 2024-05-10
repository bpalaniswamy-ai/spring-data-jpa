package com.example.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring.data.jpa.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    List<User> findByProfession(String profession);

    long countByAge(String age);

    List<User> deleteByName(String name);
    //multi condition
    List<User> findByProfessionAndAge(String profession, String name);

    List<User> findByProfessionIgnoreCase(String profession);

    @Query("select * from users")
    List<User> getUsersByCustomQuery();
}
