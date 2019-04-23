-- Insert/Update Reservation
GO
CREATE PROCEDURE sp_AddReservation(@ID INT,
                                   @newStartDate DATE,
                                   @newEndDate DATE,
                                   @newMileageAtDeparture INT,
                                   @newMileageAtArrival INT,
                                   @newAutoCamper INT,
                                   @newSeason INT)
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_Reservation WHERE fld_ReservationID = @ID)
    BEGIN
      UPDATE tbl_Reservation
      SET fld_StartDate          = @newStartDate,
          fld_EndDate            = @newEndDate,
          fed_MileageAtDeparture = @newMileageAtDeparture,
          fad_MileageAtArrival   = @newMileageAtArrival,
          fld_AutoCamper         = @newAutoCamper,
          fld_Season             = @newSeason
      WHERE fld_ReservationID = @ID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_Reservation
      VALUES (@newStartDate, @newEndDate, @newMileageAtDeparture, @newMileageAtArrival, @newAutoCamper, @newSeason)
    END
END