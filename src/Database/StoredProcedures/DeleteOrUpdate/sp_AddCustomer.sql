-- Insert/Update Customer
GO
CREATE PROCEDURE sp_AddCustomer(@customerID INT,
                                @newCustomerName VARCHAR(50),
                                @newPhoneNR VARCHAR(12),
                                @newEMail VARCHAR(50),
                                @newZip VARCHAR(5),
                                @@newAddress VARCHAR(50))
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_Customer WHERE fld_CustomerID = @customerID)
    BEGIN
      UPDATE tbl_Customer
      SET fld_CustomerName = @newCustomerName,
          fld_PhoneNR      = @newPhoneNR,
          fld_EMail        = @newEMail,
          fld_Zip          = @newZip,
          fad_Address      = @@newAddress
      WHERE fld_CustomerID = @customerID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_Customer VALUES (@newCustomerName, @newPhoneNR, @newEMail, @newZip, @@newAddress)
    END
END