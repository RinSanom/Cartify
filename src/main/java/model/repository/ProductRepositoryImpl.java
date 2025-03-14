package model.repository;

import model.entity.Product;
import util.DatabaseConnection;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {

 //   @Override
//    public Optional<Product> findById(Integer id) {
//        String sql = "SELECT * FROM Products WHERE product_id = ?";
//        try (Connection conn = DatabaseConnection.getDataConnection()) {
//            if (conn == null) {
//                System.err.println("Failed to establish a database connection.");
//                return Optional.empty();
//            }
//
//            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
//                stmt.setInt(1, id);
//                try (ResultSet rs = stmt.executeQuery()) {
//                    if (rs.next()) {
//                        Product product = new Product();
//                        product.setProductId(rs.getInt("product_id"));
//                        product.setCategoryId(rs.getInt("category_id"));
//                        product.setName(rs.getString("name"));
//                        product.setPrice(rs.getDouble("price"));
//                        product.setStockQuantity(rs.getInt("stock_quantity"));
//                        product.setSold(rs.getBoolean("sold"));
//                        product.setDescription(rs.getString("discrtion"));
//                        product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
//                        return Optional.of(product);
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Error during findById: " + e.getMessage());
//        } catch (NullPointerException e) {
//            System.err.println("NullPointerException during findById: " + e.getMessage());
//        }
//        return Optional.empty();
//    }
    @Override
    public Optional<Product> findById(Integer id) {
        String sql = "SELECT * FROM Products WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getDataConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id); // Set the product_id parameter
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("product_id"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setStockQuantity(rs.getInt("stock_quantity"));
                    product.setSold(rs.getBoolean("sold"));
                    product.setDescription(rs.getString("discrtion"));
                    product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                    return Optional.of(product);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during findById: " + e.getMessage());
        }
        return Optional.empty();
    }


    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Products";
        try (Connection conn = DatabaseConnection.getDataConnection()) {
            if (conn == null) {
                System.err.println("Failed to establish a database connection.");
                return products;
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Product product = new Product();
                    product.setProductId(rs.getInt("product_id"));
                    product.setCategoryId(rs.getInt("category_id"));
                    product.setName(rs.getString("name"));
                    product.setPrice(rs.getDouble("price"));
                    product.setStockQuantity(rs.getInt("stock_quantity"));
                    product.setSold(rs.getBoolean("sold"));
                    product.setDescription(rs.getString("discrtion"));
//                    product.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());

                    products.add(product);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error during findAll: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException during findAll: " + e.getMessage());
        }
        return products;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO Products (category_id, name, price, stock_quantity, sold, discrtion, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getDataConnection()) {
            if (conn == null) {
                System.err.println("Failed to establish a database connection.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, product.getCategoryId());
                stmt.setString(2, product.getName());
                stmt.setDouble(3, product.getPrice());
                stmt.setInt(4, product.getStockQuantity());
                stmt.setBoolean(5, product.isSold());
                stmt.setString(6, product.getDescription());
                stmt.setTimestamp(7, Timestamp.valueOf(product.getCreatedAt()));
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error during save: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException during save: " + e.getMessage());
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE Products SET category_id = ?, name = ?, price = ?, stock_quantity = ?, sold = ?, discrtion = ? WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getDataConnection()) {
            if (conn == null) {
                System.err.println("Failed to establish a database connection.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, product.getCategoryId());
                stmt.setString(2, product.getName());
                stmt.setDouble(3, product.getPrice());
                stmt.setInt(4, product.getStockQuantity());
                stmt.setBoolean(5, product.isSold());
                stmt.setString(6, product.getDescription());
                stmt.setInt(7, product.getProductId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error during update: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException during update: " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM Products WHERE product_id = ?";
        try (Connection conn = DatabaseConnection.getDataConnection()) {
            if (conn == null) {
                System.err.println("Failed to establish a database connection.");
                return;
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Error during delete: " + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("NullPointerException during delete: " + e.getMessage());
        }
    }
}