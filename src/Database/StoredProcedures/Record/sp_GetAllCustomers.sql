-- List All Customers
GO
CREATE PROCEDURE sp_GetAllCustomers
AS
SELECT *
FROM tbl_Customer