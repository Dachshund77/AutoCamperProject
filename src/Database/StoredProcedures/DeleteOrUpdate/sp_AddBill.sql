-- Insert/Update Bill
GO
CREATE PROCEDURE sp_AddBill(@ID INT, @dueDate DATE, @discount INT, @billStatus VARCHAR(50))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_Bill WHERE fld_BillID = @ID)
    BEGIN
      UPDATE tbl_Bill
      SET fld_DueDate    = @dueDate,
          fld_DiscountID = @discount,
          fld_BillStatus = @billStatus
      WHERE fld_DiscountID = @ID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_Bill VALUES (@dueDate, @discount, @billStatus)
    END
END