package dev.tinajero.repositories;

import dev.tinajero.models.Messages;
import dev.tinajero.utils.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class MessagesRepo implements CrudRepository{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Boolean add(Object o) {
        return null;
    }

    @Override
    public int getById(Integer id) {
        Messages msg = new Messages(id);
        try(Connection conn = cu.getConnection()){
            String sql = "select message from emServices where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("message"));
            }


        }catch(SQLException e){
            System.out.println("couldnt get message");
        }



        return 0;
    }

    @Override
    public Boolean getId(Integer id) {
        return null;
    }

    @Override
    public List getAll() {
        return null;
    }

    @Override
    public List getAllUsers(Boolean value) {
        return null;
    }

    @Override
    public Boolean update(Object o) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }
}
