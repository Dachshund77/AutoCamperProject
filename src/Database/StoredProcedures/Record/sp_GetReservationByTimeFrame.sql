-- List all Reservations in given Timeframe
GO
CREATE PROCEDURE sp_GetReservationByTimeFrame(@startDate Date, @endDate DATE)
AS
SELECT *
FROM tbl_Reservation
WHERE @endDate > fld_EndDate
  AND @startDate < fld_StartDate