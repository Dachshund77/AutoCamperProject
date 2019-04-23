-- Delete AutoCamperType
GO
CREATE PROCEDURE sp_DeleteAutoCamperType(@categoryName VARCHAR(50))
AS
DELETE
FROM tbl_AutoCamperType
WHERE fld_CategoryName = @categoryName
