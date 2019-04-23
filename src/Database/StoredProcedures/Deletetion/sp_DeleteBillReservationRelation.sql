-- Delete bill Reservation Bridge
GO
CREATE PROCEDURE sp_DeleteBillReservationRelation(@billID INT, @reservationID INT)
AS
DELETE
FROM tbl_BillReservationBridge
WHERE fld_BillID = @billID
  AND fld_ReservationID = @reservationID