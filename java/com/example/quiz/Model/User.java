package com.example.quiz.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor
public class User {
    @NotEmpty(message = "id cannot be Empty")
    @Size(min = 2,max = 10,message = "Size of id go from 2 ,10")
    private String id;
    @NotEmpty(message = "name cannot be Empty")
    @Size(min = 2,max = 10,message = "Size of name go from 2 ,10")
    private  String name;
    @NotNull(message = "Age cannot be null")
    @Min(value = 10,message = "user age go from 10 years old")
    @Max(value = 90,message = "user age ends  90 years old")
    private Integer age;
    @NotNull(message = "balance cannot be null")
    @Min(value = 10,message = "min balance from 10")
    @Max(value = 100,message = "max balance ends 100")
    private Integer balance;
    //customer OR libraian
    @NotEmpty(message = "role cannot be Empty!..")
    @Pattern(regexp = "^(customer|libraian)",message = "role must be customer or libraian ")
    private String role;
}
