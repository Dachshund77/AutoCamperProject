CREATE FUNCTION udf_JoinAutoCamperInfo(@autoCamper type_AutoCamperTable READONLY,
                                       @status type_AutoCamperStatusTable READONLY,
                                       @statusAutoCamperBridge type_AutoCamperStatusAutoCamperBridgeTable READONLY,
                                       @type type_AutoCamperTypeTable READONLY)
  RETURNS TABLE
    RETURN(
    SELECT [@autoCamper].fld_AutoCamperID,
           [@autoCamper].fld_NumberPlate,
           [@autoCamper].fld_HeightInCm,
           [@autoCamper].fld_LengthInCm,
           [@autoCamper].fld_WeightInKG,
           [@autoCamper].fld_NoOfBeds,
           [@autoCamper].fld_NoOfSeats,
           [@autoCamper].fld_MileageInKm,
           [@autoCamper].fld_Engine,
           [@autoCamper].fld_Gears,
           [@autoCamper].fld_TypeOfGas,
           [@autoCamper].fld_KitchenDescription,
           [@autoCamper].fld_HeatingDescription,
           [@autoCamper].fld_MediaDescription,
           [@autoCamper].fld_GeneralDescription,
           [@type].fld_AutoCamperTypeID,
           [@type].fld_CategoryName,
           [@type].fld_Date,
           [@type].fld_WeeklyPriceInSeason,
           [@type].fld_WeeklyPriceOffSeason,
           [@status].fld_AutoCamperStatus

    FROM @autoCamper
           INNER JOIN @type ON [@autoCamper].fld_AutoCamperType = [@type].fld_AutoCamperTypeID
           INNER JOIN @statusAutoCamperBridge
                ON [@autoCamper].fld_AutoCamperID = [@statusAutoCamperBridge].fld_AutoCamperID
           INNER JOIN @status ON [@statusAutoCamperBridge].fld_AutoCamperStatus = [@status].fld_AutoCamperStatus)

