package com.shj.restfulgraphql.api;

import com.shj.restfulgraphql.entity.ApiResponse;
import com.shj.restfulgraphql.entity.User;
import com.shj.restfulgraphql.repositories.UserRepository;
import jakarta.annotation.Resource;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.chrono.IsoChronology;
import java.util.List;

@Slf4j
@RequestMapping("/user/rest")
@RestController
public class UserRestApi {

    @Resource
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id) {
        User user = userRepository.getReferenceById(id);
        log.info("user: {}", user);
        return ApiResponse.ok(user);
    }

    @GetMapping("/users")
    public ApiResponse<List<User>> getUsers() {
        return ApiResponse.ok(userRepository.findAll());
    }

    @PostMapping
    public ApiResponse<Boolean> insertUser(@RequestBody User user) {
        User save = userRepository.save(user);
        return ApiResponse.ok(userRepository.existsById(save.getId()));
    }

    @PutMapping
    public ApiResponse<User> updateUser(@RequestBody User user) {
        return ApiResponse.ok(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Boolean> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ApiResponse.ok(!userRepository.existsById(id));
    }

}
