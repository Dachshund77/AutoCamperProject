CREATE TYPE type_AutoCamperTypeTable
AS TABLE (  fld_AutoCamperTypeID     INT IDENTITY,
            fld_CategoryName         VARCHAR(30),
            fld_Date                 DATETIME,
            fld_WeeklyPriceInSeason  NUMERIC(18, 2),
            fld_WeeklyPriceOffSeason NUMERIC(18, 2))