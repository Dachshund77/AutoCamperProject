-- Filter tbl_AutCamperType
GO
CREATE FUNCTION udf_FilterAutoCamperStatus(@autoCamperStatus VARCHAR(30))
  RETURNS TABLE
    AS
    RETURN
    SELECT *
    FROM tbl_AutoCamperStatus
    WHERE (@autoCamperStatus IS NULL OR fld_AutoCamperStatus LIKE '%' + @autoCamperStatus + '%')