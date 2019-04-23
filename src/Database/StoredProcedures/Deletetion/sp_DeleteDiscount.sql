-- Delete discount
GO
CREATE PROCEDURE sp_DeleteDiscount(@ID INT)
AS
DELETE
FROM tbl_Discount
WHERE fld_DiscountID = @ID