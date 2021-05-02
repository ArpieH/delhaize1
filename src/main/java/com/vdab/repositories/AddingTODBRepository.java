package com.vdab.repositories;

import com.vdab.domain.Category;
import com.vdab.domain.Products;

import java.sql.*;

public class AddingTODBRepository {

    public Category getCategoryById( int id) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ delhaize", "root", "P@ssw0rd")){
            PreparedStatement preparedStatement = connection.prepareStatement("select  * from category where id = ?");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return Category.builder().id(resultSet.getInt("id")).categoryName(resultSet.getString("category_name")).build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void addProductToDB(Products product) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ delhaize", "root", "P@ssw0rd")){
           PreparedStatement preparedStatement = connection.prepareStatement("insert into products (product_name, description, price, category_id, category)values (?????)");
           preparedStatement.setString(1, product.getProductName());
           preparedStatement.setString(2, product.getDescription());
           preparedStatement.setDouble(3, product.getPrice());
           preparedStatement.setInt(4, product.getId());
           preparedStatement.setString(5, product.getCategory().getCategoryName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
