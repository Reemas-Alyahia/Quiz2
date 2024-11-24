package com.example.quiz.Controler;

import com.example.quiz.ApiRespnce.ApiResponce;
import com.example.quiz.Model.User;
import com.example.quiz.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControler {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getUser(){
        return ResponseEntity.status(200).body(userService.getUsers());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponce("Done from Adding"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@RequestBody @Valid User user,@PathVariable  String id,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate=userService.updateUser(user,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponce("done Update"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("cannot found the id"));
    }

@DeleteMapping("/delet/{id}")
    public ResponseEntity deletUser(@PathVariable String id){

        boolean isDelet=userService.deletUser(id);
        if(isDelet){
            return ResponseEntity.status(200).body(new ApiResponce("Done from deleting"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("cannot found the id"));

    }
    @GetMapping("/balance/{balance}")
    public ResponseEntity listBalnce(@PathVariable int balance){
        ArrayList newB=userService.listBalnce(balance);
        if(newB.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponce("cannot found the id"));
        }
        return ResponseEntity.status(200).body(newB);
    }

    @GetMapping("/age/{age}")
public ResponseEntity listAge(@PathVariable int age){
        ArrayList newA=userService.listAge(age);
        if (newA.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponce("cannot found the id"));

        }
    return ResponseEntity.status(200).body(newA);

}



}
