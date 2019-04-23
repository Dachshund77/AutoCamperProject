-- Find Bill by ID
GO
CREATE PROCEDURE sp_GetBillByID(@ID INT)
AS
SELECT *
FROM tbl_Bill
WHERE fld_BillID = @ID