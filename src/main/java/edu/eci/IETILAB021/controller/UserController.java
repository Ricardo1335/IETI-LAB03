package edu.eci.IETILAB021.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.UserDto;
import edu.eci.IETILAB021.service.UserService;
@RestController
@RequestMapping( "/v1/user" )

public class UserController {

     private final UserService userService;
     
    private final AtomicLong counter = new AtomicLong(0);

     public UserController(@Autowired UserService userService ) {
         this.userService = userService;
     }


     @GetMapping
     public ResponseEntity<List<User>> getAll() {
         
          return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
     }
    
     @GetMapping( "/{id}" )
     public ResponseEntity<User> findById( @PathVariable String id ) {
          
          return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
     }
    
    
     @PostMapping
     public ResponseEntity<User> create( @RequestBody UserDto userDto ) {
          User user = new User();
          user.setId((Integer.toString((int) counter.incrementAndGet())));
          user.setName(userDto.name);
          user.setLastname(userDto.lastname);
          user.setEmail(userDto.email);
          user.setdate(LocalDate.now());
          return new ResponseEntity<>(userService.create(user), HttpStatus.OK);
     }
    
     @PutMapping( "/{id}" )
     public ResponseEntity<User> update( @RequestBody UserDto userDto, @PathVariable String id ) {
          User user = userService.findById(id);
          user.setEmail(userDto.email);
          user.setName(userDto.name);
          user.setLastname(userDto.lastname);
          return new ResponseEntity<>(userService.update(user, id), HttpStatus.OK);
     }

     @DeleteMapping( "/{id}" )
     public ResponseEntity<Boolean> delete( @PathVariable String id ) {
          userService.deleteById(id);
          return new ResponseEntity<>(true, HttpStatus.OK);      
     }
}
