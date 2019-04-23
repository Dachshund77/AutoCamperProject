-- Delete Customer
GO
CREATE PROCEDURE sp_DeleteCustomer(
  @ID INT)
AS
DELETE
FROM tbl_Customer
WHERE fld_CustomerID = @ID