-- Delete Insurance
GO
CREATE PROCEDURE sp_DeleteInsurance(@insuranceName VARCHAR(30))
AS
DELETE
FROM tbl_Insurance
WHERE fld_InsuranceName = @insuranceName