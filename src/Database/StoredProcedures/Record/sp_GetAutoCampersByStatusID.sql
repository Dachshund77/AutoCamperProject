-- Find AutoCamper by Status
GO
CREATE PROCEDURE sp_GetAutoCampersByStatusID(@statusID VARCHAR(30))
AS
SELECT *
FROM tbl_AutoCamper
WHERE fld_AutoCamperID IN
      (SELECT fld_AutoCamperID FROM tbl_AutoCamperStatusAutoCamperBridge WHERE fld_AutoCamperStatus = @statusID)