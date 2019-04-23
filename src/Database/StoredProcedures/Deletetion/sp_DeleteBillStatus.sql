-- Delete Bill Status
GO
CREATE PROCEDURE sp_DeleteBillStatus(@ID VARCHAR(50))
AS
DELETE
FROM tbl_BillStatus
WHERE fld_BillStatus = @ID
