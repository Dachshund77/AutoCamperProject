-- Delete all bill to Fee Relation
GO
CREATE PROCEDURE sp_DeleteBillFeeRelation(@billID INT, @feeId INT)
AS
DELETE
FROM tbl_BillFeeBridge
WHERE fld_BillID = @billID
  AND fld_FeeID = @feeId