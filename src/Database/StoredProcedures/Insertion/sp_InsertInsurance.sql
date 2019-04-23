-- Insert Insurance
GO
CREATE PROCEDURE sp_InsertInsurance(@ID INT, @insuranceName VARCHAR(30), @basePrice NUMERIC(18, 2),
                                    @pricePerWeek NUMERIC(18, 2),
                                    @description NVARCHAR(MAX))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_Insurance WHERE fld_InsuranceID = @ID)
    BEGIN
      INSERT INTO tbl_Insurance
      VALUES (@insuranceName, @basePrice, @pricePerWeek, @description, SYSDATETIME())
    END
END