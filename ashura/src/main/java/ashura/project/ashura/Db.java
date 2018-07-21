/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ashura.project.ashura;

import java.sql.SQLException;

/**
 *
 * @author ashura
 */
public class Db {
    private java.sql.Connection c;
    private java.sql.Statement s;
    private String host;
    private int port;
    private String name,user,pass;

    public Db(String host, int port, String name, String user, String pass) throws SQLException {
        this.host = host;
        this.port = port;
        this.name = name;
        this.user = user;
        this.pass = pass; try {
            com.mysql.jdbc.Driver.class.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Work.hindar(ex,"Db");
        } start();
    }

    private void start() throws SQLException {
        c=java.sql.DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+name, user, pass);
        s=c.createStatement();
    }

    public void close() throws SQLException{
        s.close();
        c.close();
    }

    public void execute(String sql) throws SQLException{
        s.execute(sql);
    }

    public java.sql.ResultSet result(String sql) throws SQLException{
        return s.executeQuery(sql);
    }

    public java.sql.PreparedStatement prep(String sql) throws SQLException{
        return c.prepareStatement(sql);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) throws SQLException {
        close();
        this.host = host;
        start();
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) throws SQLException {
        close();
        this.port = port;
        start();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws SQLException {
        close();
        this.name = name;
        start();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) throws SQLException {
        close();
        this.user = user;
        start();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) throws SQLException {
        close();
        this.pass = pass;
        start();
    }
}