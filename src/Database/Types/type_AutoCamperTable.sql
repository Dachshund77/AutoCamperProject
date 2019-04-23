CREATE TYPE type_AutoCamperTable
AS TABLE
(
  fld_AutoCamperID       INT PRIMARY KEY,
  fld_NumberPlate        VARCHAR(20) NOT NULL,
  fld_AutoCamperType     INT         NOT NULL,
  fld_HeightInCm         INT,
  fld_LengthInCm         INT,
  fld_WeightInKG         INT,
  fld_NoOfBeds           INT,
  fld_NoOfSeats          INT,
  fld_MileageInKm        INT,
  fld_Engine             VARCHAR(50),
  fld_Gears              INT,
  fld_TypeOfGas          VARCHAR(30),
  fld_KitchenDescription NVARCHAR(MAX),
  fld_HeatingDescription NVARCHAR(MAX),
  fld_MediaDescription   NVARCHAR(MAX),
  fld_GeneralDescription NVARCHAR(MAX)
)