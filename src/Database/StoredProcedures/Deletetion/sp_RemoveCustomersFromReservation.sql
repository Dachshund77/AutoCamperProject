-- Removal of related Customer to Reservation Given Reservation
GO
CREATE PROCEDURE sp_RemoveCustomersFromReservation(@ReservationID INT)
AS
DELETE
FROM tbl_CustomerReservationBridge
WHERE fld_ReservationID = @ReservationID