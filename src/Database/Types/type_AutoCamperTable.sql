CREATE TYPE type_AutoCamperTable
AS TABLE
(
  fld_AutoCamperTypeID     INT,
  fld_CategoryName         VARCHAR(30),
  fld_Date                 DATETIME,
  fld_WeeklyPriceInSeason  NUMERIC(18, 2),
  fld_WeeklyPriceOffSeason NUMERIC(18, 2)
)