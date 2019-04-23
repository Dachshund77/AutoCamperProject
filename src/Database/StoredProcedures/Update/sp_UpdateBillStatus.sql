-- Update Bill status
GO
CREATE PROCEDURE sp_UpdateBillStatus(@oldStatus VARCHAR(50), @newStatus VARCHAR(50))
AS
UPDATE tbl_BillStatus
SET fld_BillStatus = @newStatus
WHERE fld_BillStatus = @oldStatus