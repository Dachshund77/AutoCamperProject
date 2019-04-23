-- Delete Custom Fee
GO
CREATE PROCEDURE sp_DeleteCustomFee(@ID INT)
AS
DELETE
FROM tbl_CustomFee
WHERE fld_CustomFeeID = @ID