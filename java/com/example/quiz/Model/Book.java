package com.example.quiz.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    //      ID , name , number_of_pages , price  , category  , isAvailable
    @NotEmpty(message = "id cannot be Empty")
    @Size(min = 2,max = 10,message = "id size from 2 to 10")
    private String id;
    @NotEmpty(message = "name cannot be Empty")
    @Size(min = 2,max = 15,message = "name size 2 to 15")
    private String name;
    @NotNull(message = " number of page cannot be null")
    @Min(value = 0,message = "pages start from 0")
    @Max(value = 100,message = "And pages Ends 100")
    private Integer number_of_pages;
    @NotNull(message = "price cannt be Empty")
    @Min(value = 10,message = "price go frome 10")
    @Max(value = 150,message = "and price max is 150")
    private Integer price;
    @NotEmpty(message = "category cannot be Empty ")
    @Pattern(regexp = "^(novel|academic)$",message = "you must chose one of them novsl or academic")
    private String category;

    private boolean isAvailable=false;
}
