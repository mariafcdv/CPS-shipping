CREATE DATABASE CPS_Shipping;
GO
USE CPS_Shipping;
GO
------
CREATE TABLE Region (
    Region_ID INT IDENTITY(1,1) NOT NULL,
    Name VARCHAR(50) NOT NULL,

    CONSTRAINT PK_Region PRIMARY KEY (Region_ID),
    CONSTRAINT UQ_Region_Name UNIQUE (Name)
);
GO

CREATE TABLE Country (
    Country_ID INT IDENTITY(1,1) NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Rate DECIMAL(10,2) NOT NULL,
    Region_ID INT NOT NULL,

    CONSTRAINT PK_Country PRIMARY KEY (Country_ID),
    CONSTRAINT UQ_Country_Name UNIQUE (Name),
    CONSTRAINT CK_Country_Rate CHECK (Rate >= 0),

    CONSTRAINT FK_Country_Region
    FOREIGN KEY (Region_ID)
    REFERENCES dbo.Region(Region_ID)
);

CREATE TABLE Client_Type (
    Client_Type_ID     INT IDENTITY(1,1) NOT NULL,
    Name      VARCHAR(20) NOT NULL,
    Discount  INT NOT NULL,  

    CONSTRAINT PK_Client_Type PRIMARY KEY (Client_Type_ID),
    CONSTRAINT UQ_Client_Type_Name UNIQUE (Name),
    CONSTRAINT CK_Client_Type_Discount CHECK (Discount >= 0 AND Discount <= 100)
);

------ SEEDS ------

INSERT INTO dbo.Region (Name) VALUES 
('North America'), 
('Central America'), 
('Asia'), 
('Africa'), 
('Europe');

INSERT INTO dbo.Country (Name, Rate, Region_ID) VALUES
('Miami', 5.2, 1), 
('Mexico', 5.6, 1),
('Guatemala', 2.5, 2), 
('Japan', 8.35, 3), 
('Kenya', 6, 4), 
('Italy', 3, 5);

INSERT INTO dbo.Client_Type (Name, Discount) VALUES
('Visitante', 0), 
('Premium', 5), 
('Super Premium', 10);