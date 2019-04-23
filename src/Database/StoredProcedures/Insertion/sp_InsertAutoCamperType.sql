-- Insert AutoCamperType
GO
CREATE PROCEDURE sp_InsertAutoCamperType(@ID INT,
                                         @newCategoryName VARCHAR(30),
                                         @newWeeklyPriceInSeason NUMERIC(18, 2),
                                         @newWeeklyPriceOffSeason NUMERIC(18, 2))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_AutoCamperType WHERE fld_AutoCamperTypeID = @ID)
    BEGIN
      INSERT INTO tbl_AutoCamperType
      VALUES (@newCategoryName, SYSDATETIME(), @newWeeklyPriceInSeason, @newWeeklyPriceOffSeason)
    END
END