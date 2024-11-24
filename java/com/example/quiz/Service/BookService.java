package com.example.quiz.Service;


import com.example.quiz.Model.Book;
import com.example.quiz.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    ArrayList<Book> books = new ArrayList<>();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean updateBook(Book book, String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equalsIgnoreCase(id)) {
                books.set(i, book);
                return true;
            }
        }
        return false;
    }

    public boolean deletBook(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equalsIgnoreCase(id)) {
                books.remove(id);
                return true;
            }

        }
        return false;
    }

    //Create an endpoint that takes a Book name then returns one Book .
    public Book nameBook(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equalsIgnoreCase(name)) {
                return books.get(i);
            }

        }
        return null;
    }

    //Create an endpoint that takes a
    // then return all books have this category.
    public ArrayList<Book> catgory(String category) {
        ArrayList<Book> newB = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getCategory().equalsIgnoreCase(category)) {
                newB.add(books.get(i));
            }
        }
        if (newB.isEmpty()) {
            return null;
        }
        return newB;
    }


    //Create an endpoint that takes a number of pages
    // and returns all Books who have this number of pages or above .

    public ArrayList<Book> numperPage(int pages) {
        ArrayList<Book> newPP = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getNumber_of_pages()>= pages) {
                newPP.add(books.get(i));
            }

        }
        if (newPP.isEmpty()) {
            return null;
        }
        return newPP;
    }




    //Create an endpoint that change a book status to unavailable
    // (Only the librarian can change the status of the book)

    public boolean chang(User user,String id,String id2){
        for (int i = 0; i <books.size() ; i++) {
            if(books.get(i).getId().equalsIgnoreCase(id)){
                if(books.get(i).isAvailable()==true){
                if(user.getId().equalsIgnoreCase(id2)){
                    if(user.getRole().equalsIgnoreCase("libraian")){
                        books.get(i).setAvailable(false);
                        return true;
                    }

                }
            }

        }
    }
        return false;
    }
}