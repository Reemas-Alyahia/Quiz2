package com.example.quiz.Controler;

import com.example.quiz.ApiRespnce.ApiResponce;
import com.example.quiz.Model.Book;
import com.example.quiz.Model.User;
import com.example.quiz.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookControler {
    private final BookService bookService;
    @GetMapping("/get")
    public ResponseEntity getBook(){
        return ResponseEntity.status(200).body(bookService.getBooks());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponce("Done from adding"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@RequestBody @Valid Book book, @PathVariable String id,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdate= bookService.updateBook(book,id);
        if(isUpdate){
            return ResponseEntity.status(200).body(new ApiResponce("Done Update book"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("cannot found the id"));
    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deletBook(@PathVariable String id){
        boolean isDelet=bookService.deletBook(id);
        return ResponseEntity.status(200).body(new ApiResponce("Done Deleting"));
    }

    @GetMapping("/nameBo/{name}")
    public ResponseEntity nameBook(@PathVariable String name){
        Book na=bookService.nameBook(name);
        if(na==null){
            return ResponseEntity.status(400).body(new ApiResponce("cannot found the book"));
        }
        return ResponseEntity.status(200).body(na);
    }

    @GetMapping("/cat/{catgory}")
    public ResponseEntity catgory(@PathVariable String catgory){
        ArrayList newB=bookService.catgory(catgory);
        if(newB.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponce("cannot found the catgory"));
        }
        return ResponseEntity.status(200).body(newB);
    }

    @GetMapping("/nimberP/{pages}")
    public ResponseEntity numberPage(@PathVariable int pages){
        ArrayList newN=bookService.numperPage(pages);
        if(newN.isEmpty()){
            return ResponseEntity.status(400).body(new ApiResponce("cannot found the book"));
        }
        return ResponseEntity.status(200).body(newN);
    }

    @PutMapping("/change/{id}/{id2}")
    public ResponseEntity change(@RequestBody @Valid User user,@PathVariable String id,@PathVariable String id2,Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isChange=bookService.chang(user,id,id2);
        if(isChange){
            return ResponseEntity.status(200).body(new ApiResponce("Done changing"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("cannot found the book"));

    }
}
