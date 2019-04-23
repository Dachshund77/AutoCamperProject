-- Delete all bill to insurance relations
GO
CREATE PROCEDURE sp_DeleteBillInsuranceBridge(@billID INT, @insuranceID INT)
AS
DELETE
FROM tbl_BillInsuranceBridge
WHERE fld_BillID = @billID
  AND fld_InsuranceID = @insuranceID