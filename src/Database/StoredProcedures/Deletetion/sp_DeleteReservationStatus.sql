--Delete Reservation Status
GO
CREATE PROCEDURE sp_DeleteReservationStatus(@ID VARCHAR(50))
AS
DELETE
FROM tbl_ReservationStatus
WHERE fld_ReservationStatus = @ID
