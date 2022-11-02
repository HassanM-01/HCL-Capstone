package com.hassan.dao;

import com.hassan.model.Product;

import java.math.BigDecimal;
import java.sql.*;

public class ProductDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/capstone?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product" + " (sku,name,description,unit_price,image_url,active,units_in_stock,date_created,last_updated)" +
            " VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id =?";


    public ProductDAO() {}

    protected Connection getConnection() {
    Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//MySQL database version 8.0
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return connection;
    }

    public void insertProduct(Product product) throws SQLException{
        System.out.println(INSERT_PRODUCT_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)){
            preparedStatement.setString(1, product.getSku());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setBigDecimal(4,product.getUnitPrice());
            preparedStatement.setString(5, product.getImageUrl());
            preparedStatement.setBoolean(6,product.isActive());
            preparedStatement.setInt(7,product.getUnitsInStock());
            preparedStatement.setDate(8, (Date) product.getDateCreated());
            preparedStatement.setDate(9, (Date) product.getDateCreated());
        }

    }

    public Product selectProduct(int id) {
        Product product = null;
        try (Connection connection = getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)){
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String sku = rs.getString("sku");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal unitPrice = BigDecimal.valueOf(rs.getInt(4));
                String imageUrl = rs.getString(5);
                boolean active = rs.getBoolean(6);
                int unitsInStock = rs.getInt(7);
                Date dateCreated = rs.getDate(8);
                Date lastUpdated = rs.getDate(9);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return product;
    }








}
