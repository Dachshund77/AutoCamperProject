-- Find Bill by insurance
GO
CREATE PROCEDURE sp_GetBillsByInsuranceID(@insuranceID INT)
AS
SELECT *
FROM tbl_Bill
WHERE fld_BillID IN (
  SELECT fld_BillID FROM tbl_BillInsuranceBridge WHERE fld_InsuranceID = @insuranceID
)