package com.redbird.SaldoBack.controllers;

import com.redbird.SaldoBack.models.User;
import com.redbird.SaldoBack.services.UserService;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('permission:read')")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:read')")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @PreAuthorize("hasAuthority('permission:write')")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('permission:write')")
    public void deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

//    @PatchMapping("/{id}")
//    @PreAuthorize("hasAuthority('permission:write')")
//    public User updateById(@PathVariable("id") Long id, @RequestBody Map<String, Object> fields){
//        return userService.updateById(id, fields);
//    }
}
