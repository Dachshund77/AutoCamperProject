-- List all Reservations
GO
CREATE PROCEDURE sp_GetAllReservations
AS
SELECT *
FROM tbl_Reservation