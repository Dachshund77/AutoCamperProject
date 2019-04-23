-- Find discount by ID
GO
CREATE PROCEDURE sp_GetDiscountByID(@ID INT)
AS
SELECT *
FROM tbl_Discount
WHERE fld_DiscountID = @ID