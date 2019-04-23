-- Find Bill by Reservations
GO
CREATE PROCEDURE sp_GetBillsByReservation(@reservationID INT)
AS
SELECT *
FROM tbl_Bill
WHERE fld_BillID IN (
  SELECT fld_BillID FROM tbl_BillReservationBridge WHERE fld_ReservationID = @reservationID
)