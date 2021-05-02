package com.vdab.repositories;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletingFromDBRepository {
    @SneakyThrows
    public void deleteProductById(int id) {
    try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ delhaize", "root", "P@ssw0rd")){
        PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }
    catch (Exception e){
        e.printStackTrace();
    }

    }
}
