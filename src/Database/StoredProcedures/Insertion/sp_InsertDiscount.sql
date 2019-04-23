-- Insert discount
GO
CREATE PROCEDURE sp_InsertDiscount(@ID INT, @noOfRentals INT, @discountPercentage NUMERIC(8, 5))
AS
BEGIN
  IF NOT EXISTS(SELECT * FROM tbl_Discount WHERE fld_DiscountID = @ID)
    BEGIN
      INSERT INTO tbl_Discount
      VALUES (@noOfRentals, @discountPercentage, SYSDATETIME())
    END
END