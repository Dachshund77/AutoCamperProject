-- Find closest discount
GO
CREATE PROCEDURE sp_GetDiscountByNoOfReservations(@noOfReservations INT)
AS
SELECT TOP 1 *
FROM tbl_Discount
WHERE fld_NoOfRentals <= @noOfReservations
ORDER BY fld_NoOfRentals DESC, fld_Date DESC