-- Delete Customer to Reservation Relation
GO
CREATE PROCEDURE sp_DeleteCustomerToReservationRelation(@CustomerID INT,
                                                        @ReservationID INT)
AS
DELETE
FROM tbl_CustomerReservationBridge
WHERE fld_CustomerID = @CustomerID
  AND fld_ReservationID = @ReservationID