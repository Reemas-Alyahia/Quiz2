package com.example.quiz.Service;

import com.example.quiz.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User>users=new ArrayList<>();
    public ArrayList<User> getUsers(){
        return users;
    }
    public void addUser(User user){
        users.add(user);
    }
    public boolean updateUser(User user,String id){
        for (int i = 0; i <users.size() ; i++) {
            if(users.get(i).getId().equalsIgnoreCase(id)){
                users.set(i,user);
                return true;
            }

        }
        return false;
    }
    public boolean deletUser(String id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equalsIgnoreCase(id)){
                users.remove(id);
                return true;
            }

        }
        return false;
    }

    //Create an endpoint that takes a
    // balance then returns all users have this balance or above .

    public ArrayList<User>listBalnce(int balance ){
        ArrayList<User>newB=new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getBalance()>=balance){
                newB.add(users.get(i));
            }

        }
        if(newB.isEmpty()){
            return null;
        }
        return newB;
    }
//Create an endpoint that takes an age
// then return all User who have this age  or above .
   public ArrayList<User>listAge(int age){
        ArrayList<User>newA=new ArrayList<>();
       for (int i = 0; i < users.size(); i++) {
           if(users.get(i).getAge()>=age){
               newA.add(users.get(i));
           }

       }
       if(newA.isEmpty()){
           return null;
       }
       return newA;
   }

}
