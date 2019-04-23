-- Create a new Customer to Reservation relation
GO
CREATE PROCEDURE sp_InsertCustomerReservationRelation(@CustomerID INT,
                                                      @ReservationID INT)
AS
BEGIN
  IF NOT EXISTS(SELECT *
                FROM tbl_CustomerReservationBridge
                WHERE fld_CustomerID = @CustomerID
                  AND fld_ReservationID = @ReservationID)
    BEGIN
      INSERT INTO tbl_CustomerReservationBridge
      VALUES (@CustomerID, @ReservationID)
    END
END