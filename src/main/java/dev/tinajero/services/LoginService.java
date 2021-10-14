package dev.tinajero.services;

import dev.tinajero.models.Users;
import dev.tinajero.repositories.UserRepo;

public class LoginService {
    UserRepo userRepo = new UserRepo();

    public boolean loginHero(String username, String password){

        //in order to log in a user, we will need username and password
        //that information is stored in our database
        //the repository layer needs to take care of this

        Users u = userRepo.getByUsername(username);

        //now check to make sure it matches
        if(u !=null) {
            if (username.equals(u.getUserName()) && password.equals(u.getPassword()) && u.isHero() == true) {
                return true;
            }
        }
            return false;
    }

    public boolean loginUser(String username, String password){

        //in order to log in a user, we will need username and password
        //that information is stored in our database
        //the repository layer needs to take care of this

        Users u = userRepo.getByUsername(username);

        //now check to make sure it matches
        if(u !=null) {
            if (username.equals(u.getUserName()) && password.equals(u.getPassword()) && u.isHero() == false) {
                return true;
            }
        }
        return false;
    }
}
