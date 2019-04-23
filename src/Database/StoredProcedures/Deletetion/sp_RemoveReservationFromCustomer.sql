-- Removal of related Customer to Reservation Given Customer
GO
CREATE PROCEDURE sp_RemoveReservationFromCustomer(@CustomerID INT)
AS
DELETE
FROM tbl_CustomerReservationBridge
WHERE fld_CustomerID = @CustomerID