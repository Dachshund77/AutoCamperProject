-- Find Bill by Fee
GO
CREATE PROCEDURE sp_GetBillsByFeeID(@feeID INT)
AS
SELECT *
FROM tbl_Bill
WHERE fld_BillID IN
      (SELECT fld_BillID FROM tbl_BillFeeBridge WHERE fld_feeID = @feeID)