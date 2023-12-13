package io.github.georgeuwagbale.qauntumai_backend.user;

import io.github.georgeuwagbale.qauntumai_backend.user.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUser(String id){
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User updateUser(String id, User user){
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        if (!user.getFirstName().isEmpty()){
            userToUpdate.setFirstName(user.getFirstName());
        }
        if (!user.getLastName().isEmpty()){
            userToUpdate.setLastName(user.getLastName());
        }
        userToUpdate.setLoginStatus(user.getLoginStatus());
        return userRepository.save(userToUpdate);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
