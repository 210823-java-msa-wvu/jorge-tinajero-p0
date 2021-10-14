package dev.tinajero.models;

public class Messages {

    private int id;
    private String message,service_type;

    public Messages(int id, String message, String service_type) {
        this.id = id;
        this.message = message;
        this.service_type = service_type;
    }
    public Messages(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "message='" + message + '\'' +
                '}';
    }
}
