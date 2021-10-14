package dev.tinajero.app;
import dev.tinajero.models.Emergencies;
import dev.tinajero.models.Users;
import dev.tinajero.repositories.EmergencyRepo;
import dev.tinajero.repositories.UserRepo;
import dev.tinajero.services.EmergencyService;
import dev.tinajero.services.UserServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeroMenu {

    public static EmergencyService emergencyService = new EmergencyService();

    public static UserServices userServices = new UserServices();

    public static UserRepo userRepo = new UserRepo();

    public static void selectionMenu(){
        System.out.println("Welcome Hero!");
        for(int i=0; i<56; i++)
            System.out.print("^");
        Integer numSelect;
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        EmergencyRepo emergencyRepo = new EmergencyRepo();
        while(running) {//the while loop is executed as long as running remains true, this will keep looping through
                        //regardless of the selection
            List<Emergencies> emer = new ArrayList<Emergencies>();
            System.out.println("\nWhat are you going to do today?\nSelect from the missions below (by Id) to complete one\n");
            emer = emergencyRepo.getAll();
            emer.forEach(System.out::println);
            for(int i=0; i<56; i++)
            System.out.print("^");
            System.out.println("\nPress -1: Hero Applications");
            System.out.println("Press 0: Quit");
            System.out.print(":");
            numSelect = scanner.nextInt();
            if(numSelect == 0){
                running = false;
            }
            else if(numSelect == -1){
                System.out.println("Select a user by User Name to promote them to Hero! :D\nPress anything else to go back");
                List<Users> arr = new ArrayList<Users>();
                scanner.nextLine();
                arr = userRepo.getAllUsers(false);
                arr.forEach(System.out::println);
                String selectUser;
                selectUser = scanner.nextLine();
                if(userServices.makeHero(selectUser))
                    System.out.println("You promoted " + selectUser + " to Hero status!");
            }
            else {
                //emergencyService.EmergenciesDone(numSelect);
                if(emergencyService.EmergenciesDone(numSelect)) {
                    System.out.println("Mission Completed!");
                    continue;
                }
                else
                    System.out.println("Failed to complete emergency");
            }

        }

    }
}
