-- Insert bill to Fee Relation
GO
CREATE PROCEDURE sp_InsertBillFeeRelation(@billID INT, @feeID INT)
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_BillFeeBridge WHERE fld_BillID = @billID AND fld_FeeID = @feeID)
    BEGIN
      INSERT INTO tbl_BillFeeBridge
      VALUES (@billID, @feeID)
    END
END