-- Find Customer by reservation
GO
CREATE PROCEDURE sp_GetCustomersByReservationID(@reservationID INT)
AS
SELECT *
FROM tbl_Customer
WHERE fld_CustomerID IN (
  SELECT fld_CustomerID FROM tbl_CustomerReservationBridge WHERE fld_ReservationID = @reservationID
)