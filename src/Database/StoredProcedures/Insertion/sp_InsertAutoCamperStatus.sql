-- Insert AutoCamperStatus
GO
CREATE PROCEDURE sp_InsertAutoCamperStatus(
  @newStatus VARCHAR(30))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_AutoCamperStatus WHERE fld_AutoCamperStatus = @newStatus)
    BEGIN
      INSERT INTO tbl_AutoCamperStatus
      VALUES (@newStatus)
    END
END