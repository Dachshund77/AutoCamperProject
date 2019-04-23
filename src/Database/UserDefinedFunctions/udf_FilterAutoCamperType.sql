-- Filter tbl_AutoCamperType
GO
CREATE FUNCTION udf_FilterAutoCamperType(@autoCamperTypeID INT, @category VARCHAR(30),
                                         @maxWeeklyPriceInSeason NUMERIC(18, 2),
                                         @minWeeklyPriceInSeason NUMERIC(18, 2),
                                         @maxWeeklyPriceOffSeason NUMERIC(18, 2),
                                         @minWeeklyPriceOffSeason NUMERIC(18, 2))
  RETURNS TABLE
    AS
    RETURN SELECT *
           FROM tbl_AutoCamperType
           WHERE (@autoCamperTypeID IS NULL OR fld_AutoCamperTypeID = @autoCamperTypeID)
             AND (@maxWeeklyPriceInSeason IS NULL OR fld_WeeklyPriceInSeason <= @maxWeeklyPriceInSeason)
             AND (@minWeeklyPriceInSeason IS NULL OR fld_WeeklyPriceInSeason >= @minWeeklyPriceInSeason)
             AND (@maxWeeklyPriceOffSeason IS NULL OR fld_WeeklyPriceOffSeason <= @maxWeeklyPriceOffSeason)
             AND (@minWeeklyPriceOffSeason IS NULL OR fld_WeeklyPriceOffSeason >= @minWeeklyPriceOffSeason)