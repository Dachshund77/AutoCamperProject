-- Delete Payment
GO
CREATE PROCEDURE sp_DeletePayment(@ID INT)
AS
DELETE
FROM tbl_Payment
WHERE fld_PaymentID = @ID