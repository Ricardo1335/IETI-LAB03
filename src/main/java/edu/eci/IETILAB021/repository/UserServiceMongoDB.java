package edu.eci.IETILAB021.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;
import edu.eci.IETILAB021.service.UserService;
@Service
public class UserServiceMongoDB
   implements UserService
   {
   
    private final UserRepository userRepository;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        System.out.print("entra"); 
        return userRepository.save(user); 
    }

    @Override
    public User findById(String id) {
        if(userRepository.existsById(id))return userRepository.findById(id).get();
        return null; 
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(); 
    }

    @Override
    public User update(User user, String userId) {
        if(userRepository.existsById(userId)){
            User actualUser = userRepository.findById(userId).get(); 
            actualUser.setCreatedAt(user.getCreatedAt());
            actualUser.setEmail(user.getEmail());
            actualUser.setLastName(user.getLastName());
            actualUser.setName(user.getName());
            userRepository.save(actualUser); 
            return actualUser; 
        } 
        return null; 
    }
   }