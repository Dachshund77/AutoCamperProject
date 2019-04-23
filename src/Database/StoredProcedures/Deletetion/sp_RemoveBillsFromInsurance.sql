-- Remove a bill to insurance relation given insurance
GO
CREATE PROCEDURE sp_RemoveBillsFromInsurance(@insuranceID INT)
AS
DELETE
FROM tbl_BillInsuranceBridge
WHERE fld_InsuranceID = @insuranceID