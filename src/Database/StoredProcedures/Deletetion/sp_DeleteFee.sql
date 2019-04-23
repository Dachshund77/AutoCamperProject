-- Delete Fee
GO
CREATE PROCEDURE sp_DeleteFee(@name VARCHAR(30))
AS
DELETE
FROM tbl_Fee
WHERE fld_Name = @name
