-- Find AutoCamper by ID
GO
CREATE PROCEDURE sp_GetAutoCamperByID(@ID INT)
AS
SELECT *
FROM tbl_AutoCamper
WHERE fld_AutoCamperID = @ID