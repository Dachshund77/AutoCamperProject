-- Insert Reservation Status
GO
CREATE PROCEDURE sp_InsertReservationStatus(@newStatus varchar(50))
AS
    BEGIN
        IF NOT EXISTS(SELECT * FROM tbl_ReservationStatus WHERE fld_ReservationStatus = @newStatus)
        BEGIN
            INSERT INTO tbl_ReservationStatus
            VALUES (@newStatus)
        END
    END