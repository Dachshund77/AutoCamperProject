-- Find Payment by ID
GO
CREATE PROCEDURE sp_GetPaymentByID(@ID INT)
AS
SELECT *
FROM tbl_Payment
WHERE fld_PaymentID = @ID