package com.example.gigacontrolreporte.daos;

import com.example.gigacontrolreporte.beans.BUsarios;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class UsersDao {
    public ArrayList<BUsarios>  getUsersList(){
        ArrayList<BUsarios> usersList = new ArrayList<>();
        try {
          String user = "root";
          String passw = "root";
          String url = "jdbc:mysql://localhost:3306/gigacontrol";
          Class.forName("com.mysql.cj.jdbc.Driver");

          Connection connection = DriverManager.getConnection(url,user,passw);
          Statement statement = connection.createStatement();
          String sql = "select * from usuario";
          ResultSet resultSet = statement.executeQuery(sql);
          while(resultSet.next()){
              BUsarios newUser = new BUsarios();
              newUser.setNombre(resultSet.getString(2));
              newUser.setApellido(resultSet.getString(3));
              newUser.setCorreo(resultSet.getString(4));
              newUser.setContrasena(resultSet.getString(5));
              newUser.setCodigo(resultSet.getString(6));
              newUser.setDni(resultSet.getString(7));
              newUser.setCelular(resultSet.getString(8));
              newUser.setCategoria(resultSet.getString(9));
              newUser.setRolId(resultSet.getInt(11));

              usersList.add(newUser);
          }

        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }
}
