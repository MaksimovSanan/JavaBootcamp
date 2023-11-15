package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{

    private final DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()) {
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM product");
            while(resultSet.next()) {
                Product product = new Product(
                        resultSet.getLong("identifier"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM product WHERE identifier = ?");
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();
            if(!resultSet.next()) return Optional.empty();
            Product product = new Product(
                    resultSet.getLong("identifier"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price")
            );
            return Optional.of(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("UPDATE product SET name = ?, price = ? WHERE identifier = ?");
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setLong(3, product.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Product product) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO product(identifier, name, price) VALUES (?, ?, ?)");
            stmt.setLong(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setDouble(3,product.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = dataSource.getConnection()) {
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM product WHERE identifier = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
