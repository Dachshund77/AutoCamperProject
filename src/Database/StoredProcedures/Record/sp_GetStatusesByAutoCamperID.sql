-- Find Status by AutoCamper
GO
CREATE PROCEDURE sp_GetStatusesByAutoCamperID(@autoCamperID INT)
AS
SELECT *
FROM tbl_AutoCamperStatus
WHERE fld_AutoCamperStatus IN
      (SELECT fld_AutoCamperStatus FROM tbl_AutoCamperStatusAutoCamperBridge WHERE fld_AutoCamperID = @autoCamperID)