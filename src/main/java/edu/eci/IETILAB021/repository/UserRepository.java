package edu.eci.IETILAB021.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;
@Service  
public interface UserRepository extends MongoRepository<User, String>
{

}