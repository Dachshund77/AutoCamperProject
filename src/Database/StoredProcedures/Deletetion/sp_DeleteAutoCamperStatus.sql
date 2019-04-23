-- Delete AutoCamperStatus
GO
CREATE PROCEDURE sp_DeleteAutoCamperStatus(
  @ID VARCHAR(30))
AS
DELETE
FROM tbl_AutoCamperStatus
WHERE fld_AutoCamperStatus = @ID