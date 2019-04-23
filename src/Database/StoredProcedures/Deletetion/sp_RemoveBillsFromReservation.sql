-- Remove Bills from a reservation
GO
CREATE PROCEDURE sp_RemoveBillsFromReservation(@reservationID INT)
AS
DELETE
FROM tbl_BillReservationBridge
WHERE fld_ReservationID = @reservationID