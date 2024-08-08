package com.niantic.services;

import com.niantic.models.Vendor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;

public class VendorDao {
    private final JdbcTemplate jdbcTemplate;

    public VendorDao() {
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

    public ArrayList<Vendor> getAllVendors() {
        ArrayList<Vendor> vendors = new ArrayList<>();

        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql);

        while (row.next()) {
            vendors.add(new Vendor(
                    row.getInt("vendor_id"),
                    row.getString("vendor_name"),
                    row.getString("website")
            ));
        }

        return vendors;
    }

    public Vendor getVendorById(int vendorId) {
        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors
                WHERE vendor_id = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, vendorId);

        if (row.next()) {
            return new Vendor(
                    row.getInt("vendor_id"),
                    row.getString("vendor_name"),
                    row.getString("website")
            );
        }

        return null;
    }

    public Vendor getVendorByName(String vendorName) {
        String sql = """
                SELECT vendor_id
                    , vendor_name
                    , website
                FROM vendors
                WHERE vendor_name = ?;
                """;

        SqlRowSet row = jdbcTemplate.queryForRowSet(sql, vendorName);

        if (row.next()) {
            return new Vendor(
                    row.getInt("vendor_id"),
                    row.getString("vendor_name"),
                    row.getString("website")
            );
        }

        return null;
    }

    public void addVendor(Vendor vendor) {
        String sql = "INSERT INTO vendors (vendor_name, website) VALUES (?,?);";

        jdbcTemplate.update(sql,
                vendor.getName(),
                vendor.getWebsite()
        );
    }

    public void updateVendor(Vendor vendor) {
        String sql = """
                UPDATE vendors
                SET vendor_name = ?
                	, website = ?
                WHERE vendor_id = ?;
                """;

        jdbcTemplate.update(sql,
                vendor.getName(),
                vendor.getWebsite(),
                vendor.getVendorId()
        );
    }

    public void deleteVendor(int vendorId) {
        String sql = "DELETE FROM vendors WHERE vendor_id = ?;";

        jdbcTemplate.update(sql, vendorId);
    }

}
