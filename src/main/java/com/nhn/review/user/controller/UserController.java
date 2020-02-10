package com.nhn.review.user.controller;

import com.nhn.review.user.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {
    private static List<User> entityList = new ArrayList<>();
    static{
        entityList.add(new User("리뷰어1", 10));
        entityList.add(new User("리뷰어2", 20));
        entityList.add(new User("리뷰어3", 30));
    }

    @GetMapping("/users")
    public List<User> getAll(){
        return entityList;
    }

    @GetMapping("/users/{name}")
    public List<User> getUserByName(@PathVariable String name){
        return entityList.stream()
                .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
