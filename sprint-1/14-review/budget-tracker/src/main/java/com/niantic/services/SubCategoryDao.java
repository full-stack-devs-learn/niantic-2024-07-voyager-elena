package com.niantic.services;

import com.niantic.models.SubCategory;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;

public class SubCategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public SubCategoryDao() {
        String databaseUrl = "jdbc:mysql://localhost:3306/budget";
        String userName = "root";
        String password = "P@ssw0rd";
        DataSource dataSource = new BasicDataSource() {{
            setUrl(databaseUrl);
            setUsername(userName);
            setPassword(password);
        }};

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public ArrayList<SubCategory> getSubCategoriesByCategory(int categoryId) {
        ArrayList<SubCategory> subcategories = new ArrayList<>();

        String sql = """
                SELECT sub_category_id
                         , category_id
                         , sub_category_name
                         , description
                FROM sub_categories
                WHERE category_id = ?;
                """;

        var row = jdbcTemplate.queryForRowSet(sql, categoryId);

        while (row.next()) {
            subcategories.add(new SubCategory(
                    row.getInt("sub_category_id"),
                    row.getInt("category_id"),
                    row.getString("sub_category_name"),
                    row.getString("description"))
            );
        }

        return subcategories;
    }

    public SubCategory getSubCategoryById(int subCategoryId) {
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                WHERE sub_category_id = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, subCategoryId);

        if (row.next()) {
            return new SubCategory(
                    row.getInt("sub_category_id"),
                    row.getInt("category_id"),
                    row.getString("sub_category_name"),
                    row.getString("description")
            );
        }

        return null;
    }

    public SubCategory getSubCategoryByName(String name) {
        String sql = """
                SELECT sub_category_id
                    , category_id
                    , sub_category_name
                    , description
                FROM sub_categories
                WHERE sub_category_name = ?
                """;

        var row = jdbcTemplate.queryForRowSet(sql, name);

        if (row.next()) {
            return new SubCategory(
                    row.getInt("sub_category_id"),
                    row.getInt("category_id"),
                    row.getString("sub_category_name"),
                    row.getString("description")
            );
        }

        return null;
    }

    public void addSubCategory(SubCategory subCategory) {
        String sql = "INSERT INTO sub_categories (category_id, sub_category_name, description) VALUES (?,?,?);";

        jdbcTemplate.update(sql,
                subCategory.getCategoryId(),
                subCategory.getSubCategoryName(),
                subCategory.getDescription());
    }

    public void updateSubCategory(SubCategory subCategory) {
        String sql = """
                UPDATE sub_categories
                SET category_id = ?
                    , sub_category_name = ?
                	, description = ?
                WHERE sub_category_id = ?;
                """;

        jdbcTemplate.update(sql,
                subCategory.getCategoryId(),
                subCategory.getSubCategoryName(),
                subCategory.getDescription(),
                subCategory.getSubCategoryId()
        );
    }

    public void deleteSubCategory(int subCategoryId) {
        String sql = "DELETE FROM sub_categories WHERE sub_category_id = ?;";

        jdbcTemplate.update(sql, subCategoryId);
    }

}
