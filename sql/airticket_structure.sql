-- 创建业务员表
CREATE TABLE SalesAgents (
                             AgentID INT AUTO_INCREMENT PRIMARY KEY,
                             AgentName VARCHAR(100) NOT NULL,
                             ContactInfo VARCHAR(100)
);

-- 创建航班基本信息表
CREATE TABLE FlightInfo (
                            FlightID INT AUTO_INCREMENT PRIMARY KEY,
                            PlaneName VARCHAR(100) NOT NULL,
                            CabinClass VARCHAR(50) NOT NULL,
                            TotalSeats INT,
                            AvailableSeats INT
);

-- 创建预售状态表
CREATE TABLE PreSaleStatus (
                               StatusID INT AUTO_INCREMENT PRIMARY KEY,
                               FlightID INT NOT NULL,
                               PreSaleStatus VARCHAR(20) NOT NULL,
                               StatusDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);

-- 创建票价表
CREATE TABLE TicketPrices (
                              PriceID INT AUTO_INCREMENT PRIMARY KEY,
                              FlightID INT NOT NULL,
                              Price DECIMAL(10, 2) NOT NULL,
                              Discount DECIMAL(5, 2),
                              DiscountPrice DECIMAL(10, 2) GENERATED ALWAYS AS (Price * (1 - Discount / 100)),
                              FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);

-- 创建票价历史表
CREATE TABLE TicketPriceHistory (
                                    HistoryID INT AUTO_INCREMENT PRIMARY KEY,
                                    PriceID INT NOT NULL,
                                    OldPrice DECIMAL(10, 2) NOT NULL,
                                    NewPrice DECIMAL(10, 2) NOT NULL,
                                    ChangeDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                                    FOREIGN KEY (PriceID) REFERENCES TicketPrices(PriceID)
);

-- 创建经手记录表
CREATE TABLE HandledRecords (
                                RecordID INT AUTO_INCREMENT PRIMARY KEY,
                                FlightID INT NOT NULL,
                                AgentID INT NOT NULL,
                                HandledDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID),
                                FOREIGN KEY (AgentID) REFERENCES SalesAgents(AgentID)
);

-- 创建客户信息表
CREATE TABLE Customers (
                           CustomerID INT AUTO_INCREMENT PRIMARY KEY,
                           Name VARCHAR(100) NOT NULL,
                           ContactInfo VARCHAR(200),
                           IDNumber VARCHAR(50),
                           PaymentStatus VARCHAR(50)
);

-- 创建预订信息表
CREATE TABLE Bookings (
                          BookingID INT AUTO_INCREMENT PRIMARY KEY,
                          CustomerID INT,
                          FlightID INT,
                          BookingTime DATETIME,
                          BookingStatus VARCHAR(50),
                          FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID),
                          FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);

-- 创建航班行程表
CREATE TABLE FlightSchedule (
                                ScheduleID INT AUTO_INCREMENT PRIMARY KEY,
                                FlightID INT NOT NULL,
                                DepartureAirport VARCHAR(100) NOT NULL,
                                ArrivalAirport VARCHAR(100) NOT NULL,
                                DepartureDateTime DATETIME NOT NULL,
                                ArrivalDateTime DATETIME NOT NULL,
                                FlightDuration TIME,
                                FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);
