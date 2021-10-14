package dev.tinajero.repositories;
import dev.tinajero.models.Users;
import dev.tinajero.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements CrudRepository<Users>{

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Boolean add(Users user) {

        try(Connection conn = cu.getConnection()){
            String sql = "insert into users values(default, ?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString ( 1, user.getFirstName());
            ps.setString ( 2, user.getLastName());
            ps.setString ( 3, user.getUserName());
            ps.setString ( 4, user.getPassword());
            ps.setString ( 5, user.getEmail());
            ps.setBoolean ( 6, user.isHero());
            return ps.executeUpdate() != 0;

        }catch (SQLException e){
            System.out.println("Username Already Taken");;
        }



        return false;
    }

    @Override
    public int getById(Integer id) {
        return 0;
    }
    @Override
    public Users getId(Integer id){
        try(Connection conn = cu.getConnection()){
            String sql = "select * from Users where id = ? and isHero = true";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt ( 1, id);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users user = new Users(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getBoolean(7)

                );
                return user;
            }

        }catch(SQLException e){
            System.out.println("Couldn't select a hero at this time");
        }
        return null;
    }
    public Users getByUsername(String username){

        try(Connection conn = cu.getConnection()){
            String sql = "select * from Users where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString ( 1, username);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Users(
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getBoolean("isHero")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
        }



        return null;
    }

    @Override
    public List<Users> getAll() {
        List<Users> arr = new ArrayList<Users>();
        try(Connection conn = cu.getConnection()){
            String sql = "select username from users where isHero = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users users = new Users();
                users.setUserName(rs.getString(1));
                arr.add(users);
            }

        }catch(SQLException e){
            System.out.println("No users at the moment");;
        }

        return arr;
    }

    @Override
    public List<Users> getAllUsers(Boolean isHero) {
        List<Users> arr = new ArrayList<Users>();
        try(Connection conn = cu.getConnection()){
            String sql = "select username,id from users where isHero = ? ";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1,isHero);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setUserName(rs.getString(1));
                arr.add(users);
            }

        }catch(SQLException e){
            System.out.println("No users at the moment");;
        }

        return arr;
    }

    @Override
    public Boolean update(Users user) {
        try (Connection conn = cu.getConnection()) {

            String sql = "update users set isHero = ? where username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setBoolean(1, true);
            ps.setString(2,user.getUserName());
            return (ps.executeUpdate() != 0);

        } catch (SQLException e) {
            System.out.println("Failed to make Hero");;
        }
        System.out.println("in the null");
        return null;

    }

    @Override
    public Boolean delete(Integer id) {
                try (Connection conn = cu.getConnection()) {

                    String sql = "delete from users where id = ?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, id);
                    return ps.executeUpdate() != 0;

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return false;
            }
    }

