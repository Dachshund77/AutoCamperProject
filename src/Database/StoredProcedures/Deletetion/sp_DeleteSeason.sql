-- Delete Season
GO
CREATE PROCEDURE sp_DeleteSeason(@ID INT)
AS
DELETE
FROM tbl_Season
WHERE fld_SeasonID = @ID