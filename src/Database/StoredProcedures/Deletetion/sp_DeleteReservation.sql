-- Delete Reservation
GO
CREATE PROCEDURE sp_DeleteReservation(@ID INT)
AS
DELETE
FROM tbl_Reservation
WHERE fld_ReservationID = @ID