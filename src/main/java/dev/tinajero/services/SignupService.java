package dev.tinajero.services;


import dev.tinajero.models.Users;
import dev.tinajero.repositories.UserRepo;

public class SignupService {
    UserRepo userRepo = new UserRepo();

    public boolean signUp(String firstName, String lastName, String username, String password, String email, boolean isHero){
            //we need the name, last name, username, password, email, and value of hero
            //to create a new user in our application
        Users u = new Users(firstName,lastName, username, password, email, isHero);
        return userRepo.add(u); //returns true or false if the information provided is correct
    }
}
