-- Insert Season
GO
CREATE PROCEDURE sp_InsertSeason(@ID INT,
                                 @newOffSeasonStart INT,
                                 @newOffSeasonEnd INT,
                                 @newInSeasonStart INT,
                                 @newInSeasonEnd INT)
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_Season WHERE fld_SeasonID = @ID)
    BEGIN
      INSERT INTO tbl_Season
      VALUES (@newOffSeasonStart, @newOffSeasonEnd, @newInSeasonStart, @newInSeasonEnd, SYSDATETIME())
    END
END