-- Delete AutoCamper
GO
CREATE PROCEDURE sp_DeleteAutoCamper(
  @ID INT)
AS
DELETE
FROM tbl_AutoCamper
WHERE fld_AutoCamperID = @ID