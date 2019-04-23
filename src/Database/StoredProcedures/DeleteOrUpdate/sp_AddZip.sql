-- Insert/Update Zip
GO
CREATE PROCEDURE sp_AddZip(@newZip VARCHAR(5),
                           @newCity VARCHAR(50))
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_Zip WHERE fld_Zip = @newZip)
    BEGIN
      UPDATE tbl_Zip SET fld_City = @newCity WHERE fld_Zip = @newZip
    END
  ELSE
    BEGIN
      INSERT INTO tbl_Zip VALUES (@newZip, @newCity)
    END
END