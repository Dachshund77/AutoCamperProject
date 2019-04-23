-- Find Reservations by Bill
GO
CREATE PROCEDURE sp_GetReservationsByBillID(@billID INT)
AS
SELECT *
FROM tbl_Reservation
WHERE fld_ReservationID IN (
  SELECT fld_ReservationID FROM tbl_BillReservationBridge WHERE fld_BillID = @billID
)