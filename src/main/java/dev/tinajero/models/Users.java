package dev.tinajero.models;

public class Users {
    private int id;
    private String firstName, lastName;
    private String userName, password;
    private String email;
    private boolean isHero = false;

    public Users(){

    }
    public Users(String userName){
        this.userName = userName;
    }
    public Users(int id, String firstName, String lastName, String userName, String password, String email, boolean isHero) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isHero = isHero;

    }

    public Users(String userName, String password, boolean isHero) {
        this.userName = userName;
        this.password = password;
        this.isHero = isHero;
    }

    public Users(String username, String password, int id) {
        this.userName = username;
        this.password = password;
        this.id = id;
    }

    public Users(String firstName, String lastName, String userName, String password, String email, boolean isHero) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.isHero = isHero;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String username) {
        this.userName = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isHero() {
        return isHero;
    }

    public void setHero(boolean hero) {
        isHero = isHero;
    }

    @Override
    public String toString() {
        return (id + " Username = " + userName);
    }
}
