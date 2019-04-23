-- Remove a bill to Fee Relation given Bill
GO
CREATE PROCEDURE sp_RemoveBillsFromFee(@FeeID INT)
AS
DELETE
FROM tbl_BillFeeBridge
WHERE fld_FeeID = @FeeID