-- Insert Bill status
GO
CREATE PROCEDURE sp_InsertBillStatus(@newStatus VARCHAR(50))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_BillStatus WHERE fld_BillStatus = @newStatus)
    BEGIN
      INSERT INTO tbl_BillStatus
      VALUES (@newStatus)
    END
END