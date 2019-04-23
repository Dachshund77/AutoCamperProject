-- Removal of related AutoCamper to status Bridge given An status
GO
CREATE PROCEDURE sp_RemoveAutoCampersFromStatus(@Status VARCHAR(30))
AS
DELETE
FROM tbl_AutoCamperStatusAutoCamperBridge
WHERE fld_AutoCamperStatus = @Status