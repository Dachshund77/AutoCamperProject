-- List all Bills
GO
CREATE PROCEDURE sp_GetAllBills
AS
SELECT *
FROM tbl_Bill