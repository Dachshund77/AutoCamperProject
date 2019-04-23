-- Delete status to AutoCamper relation
GO
CREATE PROCEDURE sp_DeleteStatusToAutoCamperRelation(@AutoCamperStatus VARCHAR(30),
                                                     @AutoCamperID INT)
AS
DELETE
FROM tbl_AutoCamperStatusAutoCamperBridge
WHERE fld_AutoCamperID = @AutoCamperID
  AND fld_AutoCamperStatus = @AutoCamperStatus