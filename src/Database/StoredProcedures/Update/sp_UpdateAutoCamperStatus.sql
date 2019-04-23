-- Update AutoCamperStatus
GO
CREATE PROCEDURE sp_UpdateAutoCamperStatus(@oldStatus VARCHAR(30),
                                           @newStatus VARCHAR(30))
AS
UPDATE tbl_AutoCamperStatus
SET fld_AutoCamperStatus = @newStatus
WHERE fld_AutoCamperStatus = @oldStatus