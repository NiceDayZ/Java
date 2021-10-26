package com.business.repository;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresRepository {
    private Connection connection;

    private static PostgresRepository dbInstance = null;

    private PostgresRepository(){
        try {
            Context ctx = new InitialContext(System.getProperties());
            DataSource dataSource = (DataSource) ctx.lookup("java3");
            connection = dataSource.getConnection();
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static PostgresRepository getInstance(){
        if(dbInstance == null){
            dbInstance = new PostgresRepository();
        }
        return dbInstance;
    }

    public ResultSet runQuery(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
