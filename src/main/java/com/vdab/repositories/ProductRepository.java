package com.vdab.repositories;

import com.vdab.domain.Products;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
  @SneakyThrows
  public List<Products> listOfProducts() {
      try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/delhaize", "root", "P@ssw0rd")) {
          PreparedStatement preparedStatement = connection.prepareStatement("select * from product ");
          preparedStatement.execute();
          ResultSet resultSet = preparedStatement.getResultSet();
          List<Products> productList = new ArrayList<>();
          while (resultSet.next()) {
              productList.add(Products.builder()
                      .id(resultSet.getInt("id"))
                      .productName(resultSet.getString("product_name"))
                      .description(resultSet.getString("description"))
                      .build());
          }
          return productList;

      } catch (Exception e) {
          e.printStackTrace();
          return null;
      }
  }
}



