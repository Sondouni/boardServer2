package com.myboard.server;

import java.sql.*;

public class DButils {
    public static Connection getCon() throws SQLException,ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3308/son";
        final String USERNALE = "root";
        final String PASSWORD = "koreait";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,USERNALE,PASSWORD);
        return con;
    }
    public static void close(Connection con, PreparedStatement ps, ResultSet rs){
        if(rs!=null){
            try { rs.close(); }
            catch (SQLException e) {  e.printStackTrace(); }
        }
        if(ps!=null){
            try { ps.close();  }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection con, PreparedStatement ps){
        close(con,ps,null);
    }
}
