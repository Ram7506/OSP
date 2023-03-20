package com.osp.UserService.controller;

import com.osp.UserService.entity.User;
import com.osp.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    // To view all User
    @GetMapping(value = "/getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUser() {
        //LOGGER.info("GET /user/getAllUser");

        List<User> userList = this.userService.getAllUsers();

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // To register User
    @PostMapping("/signup")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            //LOGGER.info("POST /user/signup/" + "USER signed up.");
            User user1 = userService.save(user);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


    // To update the user by ID
    //@PreAuthorize("hasRole('USER')")
    @PutMapping("/updateUserById/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("userId") long userId) {

        Optional<User> oldUser = userService.getUserById(userId);

        if (oldUser.isPresent() && oldUser.get().getUserId() == userId) {
            User newUser = oldUser.get();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setAddress(user.getAddress());
            newUser.setPhoneNo(user.getPhoneNo());
            newUser.setRole(user.getRole());

            User user1 = userService.updateUserById(newUser);

            return new ResponseEntity<>(user1, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @PatchMapping("/updateById/{userId}")
    public ResponseEntity<User> update(@RequestBody User user, @PathVariable("userId") long userId) {

        Optional<User> oldUser = userService.getUserById(userId);

        if (oldUser.isPresent() && oldUser.get().getUserId() == userId) {
            User newUser = oldUser.get();

            if (user.getAddress() == null)
                newUser.setPhoneNo(user.getPhoneNo());
            else if (user.getPhoneNo() == 0)
                newUser.setAddress(user.getAddress());
            else {
                newUser.setAddress(user.getAddress());
                newUser.setPhoneNo(user.getPhoneNo());
            }
            User user1 = userService.updateUserById(newUser);
            return new ResponseEntity<>(user1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    // User Cannot use this API
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<String> deleteStudById(@PathVariable long id){

        Optional<User> oldUser = userService.getUserById(id);
        try{
            if (oldUser.isPresent())
            {
                userService.deleteUserById(id);
                return new ResponseEntity<>("User Deleted successfully with ID "+id,HttpStatus.OK);
            }
            else
                return new ResponseEntity<>("User Not Found with Id "+id,HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }
}
