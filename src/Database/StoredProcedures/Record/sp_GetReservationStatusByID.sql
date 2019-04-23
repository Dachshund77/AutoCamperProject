-- Find Reservation Status by status ID
GO
CREATE PROCEDURE sp_GetReservationStatusByID(@statusID VARCHAR(50))
AS
SELECT *
FROM tbl_ReservationStatus
WHERE fld_ReservationStatus = @statusID