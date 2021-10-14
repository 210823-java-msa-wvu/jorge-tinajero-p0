package dev.tinajero.repositories;
import dev.tinajero.models.Emergencies;
import dev.tinajero.utils.ConnectionUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmergencyRepo implements CrudRepository<Emergencies>{
    ConnectionUtil cu  = ConnectionUtil.getConnectionUtil();

    @Override
    public Boolean add(Emergencies emergencies) {
        try(Connection conn = cu.getConnection()){
            String sql = "insert into emergencies values (default, ?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, emergencies.getEmergency());
            ps.setBoolean(2,emergencies.isCompleted());
            ps.executeQuery();

        }catch(SQLException e){
            return false;
        }

        return null;
    }

    @Override
    public int getById(Integer id) {
        int total = 0;

        return total;
    }

    @Override
    public Emergencies getId(Integer id) {
        return null;
    }

    @Override
    public List<Emergencies> getAll() {
        List<Emergencies> arr = new ArrayList<Emergencies>();

        try(Connection conn = cu.getConnection()){
            String sql = "select * from emergencies where completed = 'false'";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Emergencies emergencies = new Emergencies();
                emergencies.setId(rs.getInt(1));
                emergencies.setEmergency(rs.getString(2));
                arr.add(emergencies);
            }
            return arr;

        }catch(SQLException e){
            System.out.println("No Crimes At This Time");;
        }

        return arr;
    }

    @Override
    public List<Emergencies> getAllUsers(Boolean value) {
        return null;
    }

    @Override
    public Boolean update(Emergencies emergencies) {
        try(Connection conn = cu.getConnection()){
            String sql = "update emergencies set completed = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1,true);
            ps.setInt(2, emergencies.getId());

            return ps.executeUpdate() !=0;

        }catch(SQLException e){
            System.out.println("Failed to update");
        }
        return null;
    }


    @Override
    public Boolean delete(Integer id) {
        try(Connection conn = cu.getConnection()){
            String sql = "delete from emergencies where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Entry was not completed");
        }
        return null;
    }


}