-- Find Reservation by Customer
GO
CREATE PROCEDURE sp_GetReservationsByCustomerID(@customerID INT)
AS
SELECT *
FROM tbl_Reservation
WHERE fld_ReservationID IN (
  SELECT fld_ReservationID FROM tbl_CustomerReservationBridge WHERE fld_CustomerID = @customerID
)