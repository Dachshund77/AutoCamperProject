-- Create new AutoCamper to Status relation
GO
CREATE PROCEDURE sp_InsertStatusToAutoCamperRelation(@AutoCamperStatus VARCHAR(30),
                                                     @AutoCamperID INT)
AS
BEGIN
  IF NOT EXISTS(SELECT *
                FROM tbl_AutoCamperStatusAutoCamperBridge
                WHERE fld_AutoCamperStatus = @AutoCamperStatus
                  AND fld_AutoCamperID = @AutoCamperID)
    BEGIN
      INSERT INTO tbl_AutoCamperStatusAutoCamperBridge
      VALUES (@AutoCamperStatus, @AutoCamperID)
    END
END