-- Deletion of Zip
GO
CREATE PROCEDURE sp_DeleteZip(
  @ID VARCHAR(4))
AS
DELETE
FROM tbl_Zip
WHERE fld_Zip = @ID