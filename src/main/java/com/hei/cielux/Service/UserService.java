package com.hei.cielux.Service;

import com.hei.cielux.Model.User;
import com.hei.cielux.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;


    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(UUID id) throws ChangeSetPersister.NotFoundException {
        return userRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    public User updateUser(UUID id, String first_name, String last_name) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);

        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        User updatedUser= userRepository.save(user);

        return updatedUser;

    }
}
