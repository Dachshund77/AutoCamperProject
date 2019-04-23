-- Find Insurance by ID
GO
CREATE PROCEDURE sp_GetInsuranceByID(@ID INT)
AS
SELECT *
FROM tbl_Insurance
WHERE fld_InsuranceID = @ID