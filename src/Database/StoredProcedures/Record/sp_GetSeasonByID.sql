-- Find Season by ID
GO
CREATE PROCEDURE sp_GetSeasonByID(@ID INT)
AS
SELECT *
FROM tbl_Season
WHERE fld_SeasonID = @ID