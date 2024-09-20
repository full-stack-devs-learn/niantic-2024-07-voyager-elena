package com.niantic.services;

import com.niantic.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

@Repository
public class MySqlProductDao implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySqlProductDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public ArrayList<Product> getProductsByCategory(int categoryId) {
        ArrayList<Product> products = new ArrayList<>();

        String sql = """
                    SELECT product_id
                        , category_id
                        , product_name
                        , quantity_per_unit
                        , unit_price
                        , units_in_stock
                        , units_on_order
                        , reorder_level
                    FROM products
                    WHERE category_id = ?
                    ORDER BY product_name
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while (row.next()) {
            int productId = row.getInt("product_id");
            String productName = row.getString("product_name");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            Product product = new Product(
                    productId,
                    categoryId,
                    productName,
                    quantityPerUnit,
                    unitPrice,
                    unitsInStock,
                    unitsOnOrder,
                    reorderLevel
            );
            products.add(product);
        }

        return products;
    }

    @Override
    public Product getProductByProductId(int productId) {

        String sql = """
                    SELECT product_id
                        , category_id
                        , product_name
                        , quantity_per_unit
                        , unit_price
                        , units_in_stock
                        , units_on_order
                        , reorder_level
                    FROM products
                    WHERE product_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, productId);

        if (row.next()) {
            int categoryId = row.getInt("category_id");
            String productName = row.getString("product_name");
            String quantityPerUnit = row.getString("quantity_per_unit");
            double unitPrice = row.getDouble("unit_price");
            int unitsInStock = row.getInt("units_in_stock");
            int unitsOnOrder = row.getInt("units_on_order");
            int reorderLevel = row.getInt("reorder_level");

            return new Product(
                    productId,
                    categoryId,
                    productName,
                    quantityPerUnit,
                    unitPrice,
                    unitsInStock,
                    unitsOnOrder,
                    reorderLevel
            );
        }

        return null;
    }

    @Override
    public int addProduct(Product product) {
        String sql = """
                INSERT INTO products (product_name, category_id, quantity_per_unit, unit_price, units_in_stock, units_on_order, reorder_level)
                VALUES (?, ?, ?, ?, ?, ?, ?);
                """;

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {

            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set parameters
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getCategoryId());
            preparedStatement.setString(3, product.getQuantityPerUnit());
            preparedStatement.setDouble(4, product.getUnitPrice());
            preparedStatement.setInt(5, product.getUnitsInStock());
            preparedStatement.setInt(6, product.getUnitsOnOrder());
            preparedStatement.setInt(7, product.getReorderLevel());

            return preparedStatement;

        }, generatedKeyHolder);

        return generatedKeyHolder.getKey().intValue();
    }

    @Override
    public void updateProduct(Product product) {
        String sql = """
                UPDATE products
                SET product_name = ?
                  , category_id = ?
                  , quantity_per_unit = ?
                  , unit_price = ?
                  , units_in_stock = ?
                  , units_on_order = ?
                  , reorder_level = ?
                WHERE product_id = ?;
                """;

        jdbcTemplate.update(sql
                , product.getProductName()
                , product.getCategoryId()
                , product.getQuantityPerUnit()
                , product.getUnitPrice()
                , product.getUnitsInStock()
                , product.getUnitsOnOrder()
                , product.getReorderLevel()
                , product.getProductId());
    }

    @Override
    public void deleteProduct(int id) {
        String sql = """
                DELETE FROM products
                WHERE product_id = ?;
                """;

        jdbcTemplate.update(sql, id);
    }

}
