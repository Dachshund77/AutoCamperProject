GO
CREATE FUNCTION udf_FilterAutoCamper(@autoCamperID INT)
  RETURNS TABLE
    AS
    RETURN SELECT *
           FROM tbl_AutoCamper
           WHERE (@autoCamperID is NULL OR fld_AutoCamperID = @autoCamperID)