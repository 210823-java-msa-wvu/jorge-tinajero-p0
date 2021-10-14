package dev.tinajero.services;

import dev.tinajero.models.Emergencies;
import dev.tinajero.repositories.EmergencyRepo;

public class EmergencyService {
    EmergencyRepo emergencyRepo = new EmergencyRepo();
    Emergencies emer = new Emergencies();

    public boolean EmergenciesDone(int id){
        emer.setId(id);
        //we need the name, last name, username, password, email, and value of hero
        //to create a new user in our application
        return emergencyRepo.update(emer);
         //returns true or false if the information provided is correct
    }

    public boolean addEmergency(String emergency){

        emer.setEmergency(emergency);
        emer.setCompleted(false);

        return emergencyRepo.add(emer);
    }
}