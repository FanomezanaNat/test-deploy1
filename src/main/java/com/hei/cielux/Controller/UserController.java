package com.hei.cielux.Controller;

import com.hei.cielux.Model.User;
import com.hei.cielux.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) throws ChangeSetPersister.NotFoundException {
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id,@RequestParam String first_name,@RequestParam String last_name) throws ChangeSetPersister.NotFoundException {
        return userService.updateUser(id,first_name,last_name);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@RequestParam UUID id){
        userService.deleteUserById(id);
    }


}
