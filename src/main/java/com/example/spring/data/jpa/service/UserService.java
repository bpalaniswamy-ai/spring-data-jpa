package com.example.spring.data.jpa.service;

import com.example.spring.data.jpa.entity.User;
import com.example.spring.data.jpa.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void initDB(){
        List<User> users = new ArrayList<>();
        users.add(new User("1","ala", "26", "Software Developer"));
        users.add(new User("2","arun", "22", "Software Engineer"));
        users.add(new User("3","kishore", "26", "Software Developer"));
        users.add(new User("4","john", "29", "Software Tester"));
        userRepository.saveAll(users);
    }

    public List<User> getUsers(){
        log.info("UserService::getUsers");
        return userRepository.findAll();
    }

    public List<User> getUsersByProfession(String profession){
        log.info("UserService::getUsersByProfession : {}", profession);
        return userRepository.findByProfession(profession);
    }

    public long countByAge(String age){
        log.info("UserService::countByAge : {}", age);
        return userRepository.countByAge(age);
    }

    public List<User> deleteUser(String name){
        log.info("UserService::deleteUser : {}", name);
        return userRepository.deleteByName(name);
    }

    public List<User> getUsersByProfessionAndAge(String profession, String age){
        log.info("UserService::getUsersByProfessionAndAge : {}", profession);
        return userRepository.findByProfessionAndAge(profession, age);
    }

    public List<User> getUsersByProfessionIgnoreCase(String profession){
        log.info("UserService::getUsersByProfessionAndAge : {}", profession);
        return userRepository.findByProfessionIgnoreCase(profession);
    }

    public List<User> getUsersSort(String field){
        log.info("UserService::getUsersSort : {}", field);
        return userRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION,field));
    }

    public Page<User> getUsersByPage(int limit, int offset){
        log.info("UserService::getUsersByPage ");
        return userRepository.findAll(PageRequest.of(offset, limit));
    }
}
