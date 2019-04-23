-- Delete Bill
GO
CREATE PROCEDURE sp_DeleteBill(@ID INT)
AS
DELETE
FROM tbl_Bill
WHERE fld_DiscountID = @ID