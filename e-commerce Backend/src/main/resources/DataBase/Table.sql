CREATE TABLE Product(
    Idp INT PRIMARY KEY NOT NULL,
    ProductId INT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Description VARCHAR(280) NOT NULL,
    BasePrice DECIMAL NOT NULL,
    TaxRate DECIMAL NOT NULL,
    ProductStatus VARCHAR(10),
    InventoryQuantity INT NOT NULL
)
GO

CREATE TABLE Users(
    Idu INT PRIMARY KEY NOT NULL,
    Email VARCHAR(30) NOT NULL,
    Password VARCHAR(30) NOT NULL
)
GO

CREATE TABLE Orders(
    Number_order VARCHAR(50) PRIMARY KEY NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    OrderStatus VARCHAR(10) NOT NULL,
    ProductIdentification INT FOREIGN KEY REFERENCES PRODUCT(ProductId),
)
GO