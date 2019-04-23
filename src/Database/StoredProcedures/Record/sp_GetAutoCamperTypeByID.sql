-- Find AutoCamper type
GO
CREATE PROCEDURE sp_GetAutoCamperTypeByID(@ID INT)
AS
SELECT *
FROM tbl_AutoCamperType
WHERE fld_AutoCamperTypeID = @ID