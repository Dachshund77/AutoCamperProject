-- Insert Bill to Insurance relation
GO
CREATE PROCEDURE sp_InsertBillInsuranceBridge(@billID INT, @insuranceID INT)
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_BillInsuranceBridge WHERE fld_InsuranceID = @insuranceID AND fld_BillID = @billID)
    BEGIN
      INSERT INTO tbl_BillInsuranceBridge
      VALUES (@billID, @insuranceID)
    END
END