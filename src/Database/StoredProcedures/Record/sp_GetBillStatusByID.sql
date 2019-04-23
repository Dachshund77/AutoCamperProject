-- Find BillStatus by ID
GO
CREATE PROCEDURE sp_GetBillStatusByID(@ID INT)
AS
SELECT *
FROM tbl_BillStatus
WHERE fld_BillStatus = @ID