-- Insert Bill Reservation Bridge
GO
CREATE PROCEDURE sp_InsertBillReservationRelation(@billID INT, @reservationID INT)
AS
BEGIN
  IF NOT EXISTS(
      SELECT * FROM tbl_BillReservationBridge WHERE fld_BillID = @billID AND fld_ReservationID = @reservationID)
    BEGIN
      INSERT INTO tbl_BillReservationBridge
      VALUES (@billID, @reservationID)
    END
END