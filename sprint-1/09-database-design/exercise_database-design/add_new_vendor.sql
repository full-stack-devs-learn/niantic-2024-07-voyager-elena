-- This script creates a new Vendor using vendor name entered by the user

-- To add a Vendor, please provide the following information: 
-- Vendor name VARCHAR(200)

SET @vendor_name = 'Udemy';

USE budget;

INSERT INTO vendors (vendor_name)
VALUES (@vendor_name);