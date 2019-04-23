-- Insert fee
GO
CREATE PROCEDURE sp_InsertFee(@ID INT, @name VARCHAR(30), @amount NUMERIC(18, 2))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_Fee WHERE fld_FeeID = @ID)
    BEGIN
      INSERT INTO tbl_Fee
      VALUES (@name, @amount, SYSDATETIME())
    END
END