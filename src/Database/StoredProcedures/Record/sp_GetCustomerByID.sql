-- Find Customer by ID
GO
CREATE PROCEDURE sp_GetCustomerByID(@ID INT)
AS
SELECT *
FROM tbl_Customer
WHERE fld_CustomerID = @ID