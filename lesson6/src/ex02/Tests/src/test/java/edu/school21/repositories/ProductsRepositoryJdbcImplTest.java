package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductsRepositoryJdbcImplTest {

    ProductsRepositoryJdbcImpl productsRepositoryJdbc;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product(1L, "Product1", 10.00),
            new Product(2L, "Product2", 20.00),
            new Product(3L, "Product3", 30.00),
            new Product(4L, "Product4", 40.00),
            new Product(5L, "Product5", 50.00)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(4L, "Product4", 40.00);

    final List<Product> EXPECTED_FIND_ALL_AFTER_SAVE = Arrays.asList(
            new Product(1L, "Product1", 10.00),
            new Product(2L, "Product2", 20.00),
            new Product(3L, "Product3", 30.00),
            new Product(4L, "Product4", 40.00),
            new Product(5L, "Product5", 50.00),
            new Product(6L, "HEHE", 66.99)
    );
    final Product EXPECTED_UPDATED_PRODUCT = new Product(4L, "ABOBUS", 228.08);

    @BeforeEach
    public void init() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("/schema.sql")
                .addScript("/data.sql")
                .build();
        productsRepositoryJdbc = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    public void findAllTest() {
        List<Product> products = productsRepositoryJdbc.findAll();
        assertIterableEquals(EXPECTED_FIND_ALL_PRODUCTS, products);
    }

    @Test
    public void findByIdTest() {
        Optional<Product> product = productsRepositoryJdbc.findById(4L);
        assertEquals(EXPECTED_FIND_BY_ID_PRODUCT, product.orElse(null));
    }

    @Test
    public void updateTest(){
        Product product = new Product(4L, "ABOBUS", 228.08);
        productsRepositoryJdbc.update(product);
        Optional<Product> updated = productsRepositoryJdbc.findById(4L);
        assertEquals(EXPECTED_UPDATED_PRODUCT, updated.orElse(null));
    }

    @Test
    public void saveDeleteTest() {
        Product product = new Product(6L, "HEHE", 66.99);
        productsRepositoryJdbc.save(product);
        assertIterableEquals(productsRepositoryJdbc.findAll(), EXPECTED_FIND_ALL_AFTER_SAVE);
        productsRepositoryJdbc.delete(6L);
        assertIterableEquals(productsRepositoryJdbc.findAll(), EXPECTED_FIND_ALL_PRODUCTS);
    }

}