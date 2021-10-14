package dev.tinajero.services;

import dev.tinajero.models.Users;
import dev.tinajero.repositories.CrudRepository;
import dev.tinajero.repositories.UserRepo;

public class UserServices {
    Users nothero = new Users();
    UserRepo userRepo = new UserRepo();
    CrudRepository<Users> usersCrudRepository= new UserRepo();

    public boolean makeHero(String username){

        nothero.setUserName(username);

        return userRepo.update(nothero);
    }

    public void check(Integer id) throws HeroException {
        Users checking = userRepo.getId(id);
        if(checking != null){
            return;
        }
        throw new HeroException("Invalid Id selection");
    }

//    public Users getId(Integer id){
//
//        return this.usersCrudRepository.getId(id);
//    }

}
