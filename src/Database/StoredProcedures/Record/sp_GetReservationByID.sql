-- Find Reservation by ID
GO
CREATE PROCEDURE sp_GetReservationByID(@ID INT)
AS
SELECT *
FROM tbl_Reservation
WHERE fld_ReservationID = @ID