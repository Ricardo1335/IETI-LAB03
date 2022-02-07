package edu.eci.IETILAB021.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import edu.eci.IETILAB021.data.User;
@Service  
public interface UserRepository extends MongoRepository<User, String>
{

}