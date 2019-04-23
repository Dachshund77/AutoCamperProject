-- Insert/Update Payment
GO
CREATE PROCEDURE sp_AddPayment(@ID INT, @date DATE, @amount NUMERIC(18, 2), @billID INT)
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_Payment WHERE fld_PaymentID = @ID)
    BEGIN
      UPDATE tbl_Payment
      SET fld_Date   = @date,
          fld_Amount = @amount,
          fld_BillID = @billID
      WHERE fld_PaymentID = @ID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_Payment VALUES (@date, @amount, @billID)
    END
END