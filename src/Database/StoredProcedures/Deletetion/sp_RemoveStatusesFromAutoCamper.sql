-- Removal of related AutoCamper to Status Bridge given an AutoCamper
GO
CREATE PROCEDURE sp_RemoveStatusesFromAutoCamper(@AutoCamperID INT)
AS
DELETE
FROM tbl_AutoCamperStatusAutoCamperBridge
WHERE fld_AutoCamperID = @AutoCamperID