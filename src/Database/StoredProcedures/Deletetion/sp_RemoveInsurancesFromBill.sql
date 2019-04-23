-- Remove a bill to insurance relation given bill
GO
CREATE PROCEDURE sp_RemoveInsurancesFromBill(@billID INT)
AS
DELETE
FROM tbl_BillInsuranceBridge
WHERE fld_BillID = @billID