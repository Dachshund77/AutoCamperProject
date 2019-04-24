CREATE TYPE type_AutoCamperTypeTable
AS TABLE
(
  fld_AutoCamperTypeID     INT PRIMARY KEY,
  fld_CategoryName         VARCHAR(30)    NOT NULL,
  fld_Date                 DATETIME       NOT NULL,
  fld_WeeklyPriceInSeason  NUMERIC(18, 2) NOT NULL,
  fld_WeeklyPriceOffSeason NUMERIC(18, 2) NOT NULL
)