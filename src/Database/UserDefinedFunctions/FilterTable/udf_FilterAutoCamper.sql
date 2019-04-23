GO
CREATE FUNCTION udf_FilterAutoCamper(@autoCamperID INT, @numberPlate VARCHAR(20))
  RETURNS TABLE
    AS
    RETURN SELECT *
           FROM tbl_AutoCamper
           WHERE (@autoCamperID is NULL OR fld_AutoCamperID = @autoCamperID) AND
             (@numberPlate is NULL OR fld_NumberPlate LIKE '%'+@numberPlate+'%')