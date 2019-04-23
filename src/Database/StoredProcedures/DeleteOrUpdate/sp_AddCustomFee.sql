-- Insert Custom Fee
GO
CREATE PROCEDURE sp_AddCustomFee(@ID INT, @amount NUMERIC(18, 2), @name VARCHAR(30), @comment NVARCHAR(MAX),
                                 @billID INT)
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_CustomFee WHERE fld_CustomFeeID = @ID)
    BEGIN
      UPDATE tbl_CustomFee
      SET fld_Amount  = @amount,
          fld_Name    =@name,
          fld_Comment = @comment,
          fld_BillID  = @billID
      WHERE fld_CustomFeeID = @ID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_CustomFee VALUES (@amount, @name, @comment, @billID)
    END
END