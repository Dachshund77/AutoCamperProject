-- Remove a bill to Fee Relation given Fee
GO
CREATE PROCEDURE sp_RemoveFeesFromBill(@billID INT)
AS
DELETE
FROM tbl_BillFeeBridge
WHERE fld_BillID = @billID