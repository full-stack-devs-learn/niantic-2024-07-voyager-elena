package com.niantic.services;

import com.niantic.models.Category;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDao {
    private final JdbcTemplate jdbcTemplate;

    public CategoryDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/northwind";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        String sql = """
                SELECT category_id, category_name, description
                FROM categories
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while (row.next()) {
            int categoryId = row.getInt("category_id");
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            Category category = new Category(categoryId, categoryName, description);

            categories.add(category);
        }

        return categories;
    }

    public Category getCategoryById(int categoryId) {
        Category category = null;

        String sql = """
                        SELECT category_id, category_name, description
                        FROM categories
                        WHERE category_id = ?
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, categoryId);

        if (row.next()) {
            String categoryName = row.getString("category_name");
            String description = row.getString("description");

            category = new Category(categoryId, categoryName, description);

        }

        return category;
    }

    public int addCategory(Category category) {
        String sql = """
                INSERT INTO categories (category_name, description)
                VALUES (?,?)
                """;

//        jdbcTemplate.update(sql
//                , category.getCategoryName()
//                , category.getDescription());

        // to get id of just added category
        // found this example here - https://www.springcloud.io/post/2022-06/jdbctemplate-id
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {

            // Pre-compiling SQL
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Set parameters
            preparedStatement.setString(1, category.getCategoryName());
            preparedStatement.setString(2, category.getDescription());

            return preparedStatement;

        }, generatedKeyHolder);

        return generatedKeyHolder.getKey().intValue();

    }


    public void updateCategory(Category category) {
        String sql = """
                UPDATE categories
                SET category_name = ?
                    , description = ?
                WHERE category_id = ?
                """;

        jdbcTemplate.update(sql
                , category.getCategoryName()
                , category.getDescription()
                , category.getCategoryId());
    }


    public void deleteCategory(int categoryId) {
        String sql = """
                DELETE FROM categories
                WHERE category_id = ?
                """;

        jdbcTemplate.update(sql, categoryId);
    }


}
