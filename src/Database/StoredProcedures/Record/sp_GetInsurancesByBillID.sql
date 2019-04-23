-- Find Insurance by Bill
GO
CREATE PROCEDURE sp_GetInsurancesByBillID(@billID INT)
AS
SELECT *
FROM tbl_Insurance
WHERE fld_InsuranceID IN (
  SELECT fld_InsuranceID FROM tbl_BillInsuranceBridge WHERE fld_BillID = @billID
)