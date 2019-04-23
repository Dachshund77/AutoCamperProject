-- Find Fee by Bill
GO
CREATE PROCEDURE sp_GetFeesByBillID(@billID INT)
AS
SELECT *
FROM tbl_Fee
WHERE fld_FeeID IN
      (SELECT fld_FeeID FROM tbl_BillFeeBridge WHERE fld_BillID = @billID)