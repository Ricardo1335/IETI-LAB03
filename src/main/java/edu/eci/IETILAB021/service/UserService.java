package edu.eci.IETILAB021.service;

import java.util.List;

import edu.eci.IETILAB021.data.User;

public interface UserService
{
    User create( User user );

    User findById( String id );
    
    List<User> getAll();

    boolean deleteById( String id );

    User update( User user, String userId );
}  