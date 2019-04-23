-- Insert/Update AutoCamper WHAT ABOUT THE BRIDGE??????????????
GO
CREATE PROCEDURE sp_AddAutoCamper(@ID INT,
                                  @newNumberPlate VARCHAR(20),
                                  @newAutoCamperType INT,
                                  @newHeightInCm INT,
                                  @newLengthInCm INT,
                                  @newWeightInKG INT,
                                  @newNoOfBeds INT,
                                  @newNoOfSeats INT,
                                  @newMileageInKm INT,
                                  @newEngine VARCHAR(50),
                                  @newGears INT,
                                  @newTypeOfGas VARCHAR(30),
                                  @newKitchenDescription NVARCHAR(MAX),
                                  @newHeatingDescription NVARCHAR(MAX),
                                  @newMediaDescription NVARCHAR(MAX),
                                  @newGeneralDescription NVARCHAR(MAX))
AS
BEGIN
  IF EXISTS(SELECT * FROM tbl_AutoCamper WHERE fld_AutoCamperID = @ID)
    BEGIN
      UPDATE tbl_AutoCamper
      SET fld_NumberPlate        = @newNumberPlate,
          fld_AutoCamperType     = @newAutoCamperType,
          fld_HeightInCm         = @newHeightInCm,
          fld_LengthInCm         = @newLengthInCm,
          fld_WeightInKG         = @newWeightInKG,
          fld_NoOfBeds           = @newNoOfBeds,
          fld_NoOfSeats          = @newNoOfSeats,
          fad_MileageInKm        = @newMileageInKm,
          fld_Engine             = @newEngine,
          fld_Gears              = @newGears,
          fld_TypeOfGas          = @newTypeOfGas,
          fld_KitchenDescription = @newKitchenDescription,
          fld_HeatingDescription = @newHeatingDescription,
          fld_MediaDescription   = @newMediaDescription,
          fld_GeneralDescription = @newGeneralDescription
      WHERE fld_AutoCamperID = @ID
    END
  ELSE
    BEGIN
      INSERT INTO tbl_AutoCamper
      VALUES (@newNumberPlate,
              @newAutoCamperType,
              @newHeightInCm,
              @newLengthInCm,
              @newWeightInKG,
              @newNoOfBeds,
              @newNoOfSeats,
              @newMileageInKm,
              @newEngine,
              @newGears,
              @newTypeOfGas,
              @newKitchenDescription,
              @newHeatingDescription,
              @newMediaDescription,
              @newGeneralDescription)
    END
END