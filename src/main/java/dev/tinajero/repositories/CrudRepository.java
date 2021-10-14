package dev.tinajero.repositories;
import java.util.List;


public interface CrudRepository <T> {

    //Create
    Boolean add(T t);
    //Read
    int getById(Integer id);
    T getId(Integer id);
    List<T> getAll();
    List<T> getAllUsers(Boolean value);
    //Update
    Boolean update(T t);

    //Delete
    Boolean delete(Integer id);
}
