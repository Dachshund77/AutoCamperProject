-- Find CustomFee by ID
GO
CREATE PROCEDURE sp_GetCustomFeeByID(@ID INT)
AS
SELECT *
FROM tbl_CustomFee
WHERE fld_CustomFeeID = @ID