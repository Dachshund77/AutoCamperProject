USE MASTER
GO
-- Delete existing Database if its there
IF EXISTS(SELECT *
          FROM sys.databases
          WHERE name = 'db_AutoCamperDatabase')
  BEGIN
    ALTER DATABASE db_AutoCamperDatabase
      SET SINGLE_USER
      WITH ROLLBACK IMMEDIATE;
    DROP DATABASE db_AutoCamperDatabase;
  END

CREATE DATABASE db_AutoCamperDatabase
GO
USE db_AutoCamperDatabase;

-- Creation of tables
CREATE TABLE tbl_Zip
(
  fld_Zip  VARCHAR(5) PRIMARY KEY,
  fld_City VARCHAR(50)
);

CREATE TABLE tbl_Customer
(
  fld_CustomerID   INT IDENTITY (1,1) PRIMARY KEY,
  fld_CustomerName VARCHAR(50) NOT NULL,
  fld_PhoneNR      VARCHAR(12) NOT NULL,
  fld_EMail        VARCHAR(50),
  fld_Zip          VARCHAR(5)  NOT NULL,
  FOREIGN KEY (fld_Zip) REFERENCES tbl_Zip (fld_Zip),
  fad_Address      VARCHAR(50) NOT NULL,
);

CREATE TABLE tbl_AutoCamperStatus
(
  fld_AutoCamperStatus VARCHAR(30) PRIMARY KEY
);

CREATE TABLE tbl_AutoCamperType
(
  fld_AutoCamperTypeID     INT IDENTITY (1,1) PRIMARY KEY,
  fld_CategoryName         VARCHAR(30)    NOT NULL,
  fld_Date                 DATETIME       NOT NULL,
  fld_WeeklyPriceInSeason  NUMERIC(18, 2) NOT NULL,
  fld_WeeklyPriceOffSeason NUMERIC(18, 2) NOT NULL
);

-- Ill guess we need to protect the removal of the last status of a given autoCamper by stored procedure?
CREATE TABLE tbl_AutoCamper
(
  fld_AutoCamperID       INT IDENTITY (1,1) PRIMARY KEY,
  fld_NumberPlate        VARCHAR(20) NOT NULL,
  fld_AutoCamperType     INT         NOT NULL,
  FOREIGN KEY (fld_AutoCamperType) REFERENCES tbl_AutoCamperType (fld_AutoCamperTypeID),
  fld_HeightInCm         INT,
  fld_LengthInCm         INT,
  fld_WeightInKG         INT,
  fld_NoOfBeds           INT,
  fld_NoOfSeats          INT,
  fad_MileageInKm        INT,
  fld_Engine             VARCHAR(50),
  fld_Gears              INT,
  fld_TypeOfGas          VARCHAR(30),
  fld_KitchenDescription NVARCHAR(MAX),
  fld_HeatingDescription NVARCHAR(MAX),
  fld_MediaDescription   NVARCHAR(MAX),
  fld_GeneralDescription NVARCHAR(MAX)
);

-- The cascading of Delete needs a test
CREATE TABLE tbl_AutoCamperStatusAutoCamperBridge
(
  fld_AutoCamperStatus VARCHAR(30),
  FOREIGN KEY (fld_AutoCamperStatus) REFERENCES tbl_AutoCamperStatus (fld_AutoCamperStatus) ON DELETE CASCADE,
  fld_AutoCamperID     INT,
  FOREIGN KEY (fld_AutoCamperID) REFERENCES tbl_AutoCamper (fld_AutoCamperID) ON DELETE CASCADE
);

-- Year must be stripped out for the sake of stored procedures
CREATE TABLE tbl_Season
(
  fld_SeasonID           INT IDENTITY (1,1) PRIMARY KEY,
  fld_WeekOffSeasonStart INT      NOT NULL,
  fld_WeekOffSeasonEnd   INT      NOT NULL,
  fld_WeekInSeasonStart  INT      NOT NULL,
  fld_WeekInSeasonEnd    INT      NOT NULL,
  fld_Date               DATETIME NOT NULL
);

CREATE TABLE tbl_ReservationStatus
(
    fld_ReservationStatus VARCHAR(50) PRIMARY KEY
);

-- Protect again last removal of customer
CREATE TABLE tbl_Reservation
(
  fld_ReservationID      INT IDENTITY (1,1) PRIMARY KEY,
  fld_StartDate          DATE NOT NULL,
  fld_EndDate            DATE NOT NULL,
  fed_MileageAtDeparture INT  NOT NULL,
  fad_MileageAtArrival   INT,
  fld_AutoCamper         INT  NOT NULL,
  FOREIGN KEY (fld_AutoCamper) REFERENCES tbl_AutoCamper (fld_AutoCamperID),
  fld_Season             INT  NOT NULL,
  FOREIGN KEY (fld_Season) REFERENCES tbl_Season (fld_SeasonID),
  fld_ReservationStatus VARCHAR(50),
  FOREIGN KEY (fld_ReservationStatus) REFERENCES tbl_ReservationStatus (fld_ReservationStatus)

);

CREATE TABLE tbl_CustomerReservationBridge
(
  fld_CustomerID    INT NOT NULL,
  FOREIGN KEY (fld_CustomerID) REFERENCES tbl_cUSTOMER (fld_CustomerID) ON DELETE CASCADE,
  fld_ReservationID INT NULL,
  FOREIGN KEY (fld_ReservationID) REFERENCES tbl_Reservation (fld_ReservationID) ON DELETE CASCADE
);

CREATE TABLE tbl_BillStatus
(
  fld_BillStatus VARCHAR(50) PRIMARY KEY
);

CREATE TABLE tbl_Discount
(
  fld_DiscountID         INT IDENTITY (1,1) PRIMARY KEY,
  fld_NoOfRentals        INT           NOT NULL,
  fld_DiscountPercentage NUMERIC(8, 5) NOT NULL,
  fld_Date               DATETIME      NOT NULL
);

CREATE TABLE tbl_Insurance
(
  fld_InsuranceID   INT IDENTITY (1,1) PRIMARY KEY,
  fld_InsuranceName VARCHAR(30)    NOT NULL,
  fld_BasePrice     NUMERIC(18, 2) NOT NULL,
  fld_PricePerWeek  NUMERIC(18, 2) NOT NULL,
  fld_Description   NVARCHAR(MAX)  NOT NULL,
  fld_Date          DATETIME       NOT NULL
);

CREATE TABLE tbl_Fee
(
  fld_FeeID  INT IDENTITY (1,1) PRIMARY KEY,
  fld_Name   VARCHAR(30)    NOT NULL,
  fld_Amount NUMERIC(18, 2) NOT NULL,
  fld_Date   DATETIME       NOT NULL
);

CREATE TABLE tbl_Bill
(
  fld_BillID     INT IDENTITY (1,1) PRIMARY KEY,
  fld_DueDate    DATE        NOT NULL,
  fld_DiscountID INT,
  FOREIGN KEY (fld_DiscountID) REFERENCES tbl_Discount (fld_DiscountID),
  fld_BillStatus VARCHAR(50) NOT NULL,
  FOREIGN KEY (fld_BillStatus) REFERENCES tbl_BillStatus (fld_BillSTatus)
);

CREATE TABLE tbl_BillInsuranceBridge
(
  fld_BillID      INT NOT NULL,
  FOREIGN KEY (fld_BillID) REFERENCES tbl_Bill (fld_BillID) ON DELETE CASCADE,
  fld_InsuranceID INT NOT NULL,
  FOREIGN KEY (fld_InsuranceID) REFERENCES tbl_Insurance (fld_InsuranceID) ON DELETE CASCADE
);

CREATE TABLE tbl_BillFeeBridge
(
  fld_BillID INT NOT NULL,
  FOREIGN KEY (fld_BillID) REFERENCES tbl_Bill (fld_BillID) ON DELETE CASCADE,
  fld_FeeID  INT NOT NULL,
  FOREIGN KEY (fld_FeeID) REFERENCES tbl_Fee (fld_FeeId) ON DELETE CASCADE
);
-- oops forgot bill
CREATE TABLE tbl_Payment
(
  fld_PaymentID INT IDENTITY (1,1) PRIMARY KEY,
  fld_Date      DATE           NOT NULL,
  fld_Amount    NUMERIC(18, 2) NOT NULL,
  fld_BillID    INT            NOT NULL,
  FOREIGN KEY (fld_BillID) REFERENCES tbl_Bill (fld_BillID)
);

CREATE TABLE tbl_CustomFee
(
  fld_CustomFeeID INT IDENTITY (1,1) PRIMARY KEY,
  fld_Amount      NUMERIC(18, 2) NOT NULL,
  fld_Name        VARCHAR(30)    NOT NULL,
  fld_Comment     NVARCHAR(MAX)  NOT NULL,
  fld_BillID      INT            NOT NULL,
  FOREIGN KEY (fld_BillID) REFERENCES tbl_Bill (fld_BillID)
);

CREATE TABLE tbl_BillReservationBridge
(
  fld_BillID        INT NOT NULL,
  FOREIGN KEY (fld_BillID) REFERENCES tbl_Bill (fld_BillID) ON DELETE CASCADE,
  fld_ReservationID INT NOT NULL,
  FOREIGN KEY (fld_ReservationID) REFERENCES tbl_Reservation (fld_ReservationID) ON DELETE CASCADE
);