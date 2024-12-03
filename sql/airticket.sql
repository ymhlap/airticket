-- 创建业务员表
CREATE TABLE SalesAgents (
                             AgentID INT AUTO_INCREMENT PRIMARY KEY,
                             AgentName VARCHAR(100) NOT NULL,
                             ContactInfo VARCHAR(100)
);

-- 插入业务员数据
INSERT INTO SalesAgents (AgentName, ContactInfo) VALUES
                                                     ('赵强', 'zq123@qq.com'),
                                                     ('钱伟', 'qw456@gmail.com'),
                                                     ('孙涛', 'st789@qq.com'),
                                                     ('李娜', 'ln1011@gmail.com'),
                                                     ('周杰', 'zj1213@qq.com');

-- 创建预售状态表
CREATE TABLE PreSaleStatus (
                               StatusID INT AUTO_INCREMENT PRIMARY KEY,
                               FlightID INT NOT NULL,
                               PreSaleStatus VARCHAR(20) NOT NULL,
                               StatusDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                               FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);

INSERT INTO PreSaleStatus (FlightID, PreSaleStatus) VALUES
                                                        (1, '开放'),
                                                        (2, '关闭'),
                                                        (3, '开放'),
                                                        (4, '开放'),
                                                        (5, '关闭');

-- 创建票价表
CREATE TABLE TicketPrices (
                              PriceID INT AUTO_INCREMENT PRIMARY KEY,
                              FlightID INT NOT NULL,
                              Price DECIMAL(10, 2) NOT NULL,
                              Discount DECIMAL(5, 2),
                              DiscountPrice DECIMAL(10, 2) GENERATED ALWAYS AS (Price * (1 - Discount / 100)),
                              FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID)
);

INSERT INTO TicketPrices (FlightID, Price, Discount) VALUES
                                                         (1, 1200.00, 10.00),
                                                         (2, 1800.00, 5.00),
                                                         (3, 2500.00, 0.00),
                                                         (4, 800.00, 20.00),
                                                         (5, 1500.00, 15.00);

-- 创建票价历史表
CREATE TABLE TicketPriceHistory (
                                    HistoryID INT AUTO_INCREMENT PRIMARY KEY,
                                    PriceID INT NOT NULL,
                                    OldPrice DECIMAL(10, 2) NOT NULL,
                                    NewPrice DECIMAL(10, 2) NOT NULL,
                                    ChangeDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                                    FOREIGN KEY (PriceID) REFERENCES TicketPrices(PriceID)
);

INSERT INTO TicketPriceHistory (PriceID, OldPrice, NewPrice) VALUES
                                                                 (1, 1200.00, 1080.00),
                                                                 (2, 1800.00, 1710.00),
                                                                 (3, 2500.00, 2500.00), -- 无折扣变化
                                                                 (4, 800.00, 640.00),
                                                                 (5, 1500.00, 1275.00);

-- 创建经手记录表
CREATE TABLE HandledRecords (
                                RecordID INT AUTO_INCREMENT PRIMARY KEY,
                                FlightID INT NOT NULL,
                                AgentID INT NOT NULL,
                                HandledDate DATETIME DEFAULT CURRENT_TIMESTAMP,
                                FOREIGN KEY (FlightID) REFERENCES FlightInfo(FlightID),
                                FOREIGN KEY (AgentID) REFERENCES SalesAgents(AgentID)
);

INSERT INTO HandledRecords (FlightID, AgentID) VALUES
                                                   (1, 1),
                                                   (2, 2),
                                                   (3, 3),
                                                   (4, 4),
                                                   (5, 5);

-- 创建客户信息表
CREATE TABLE Customers (
                           CustomerID INT AUTO_INCREMENT PRIMARY KEY,
                           Name VARCHAR(100) NOT NULL,
                           ContactInfo VARCHAR(200),
                           IDNumber VARCHAR(50),
                           PaymentStatus VARCHAR(50)
);

-- 插入客户信息数据
INSERT INTO Customers (Name, ContactInfo, IDNumber, PaymentStatus) VALUES
                                                                       ('吴刚', 'wg2015@qq.com', '110105197001011234', '已付款'),
                                                                       ('郑洁', 'zj2020@gmail.com', '320582198510056789', '未付款'),
                                                                       ('王磊', 'wl1989@qq.com', '330106198910218765', '部分付款'),
                                                                       ('张华', 'zh1992@gmail.com', '440301199209037610', '已付款'),
                                                                       ('刘洋', 'ly1985@qq.com', '210302198503040567', '未付款');

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

INSERT INTO Bookings (CustomerID, FlightID, BookingTime, BookingStatus) VALUES
                                                                            (1, 1, '2024-06-10 10:00:00', '已确认'),
                                                                            (2, 2, '2024-07-20 14:30:00', '待支付'),
                                                                            (3, 3, '2024-08-15 09:00:00', '已取消'),
                                                                            (4, 4, '2024-09-01 12:00:00', '已确认'),
                                                                            (5, 5, '2024-10-12 08:20:00', '待支付');

-- 创建航班基本信息表
CREATE TABLE FlightInfo (
                            FlightID INT AUTO_INCREMENT PRIMARY KEY,
                            PlaneName VARCHAR(100) NOT NULL,
                            CabinClass VARCHAR(50) NOT NULL,
                            TotalSeats INT,
                            AvailableSeats INT
);

-- 插入航班基本信息数据
INSERT INTO FlightInfo (PlaneName, CabinClass, TotalSeats, AvailableSeats) VALUES
                                                                               ('波音737', '经济舱', 150, 145),
                                                                               ('空客A320', '商务舱', 30, 28),
                                                                               ('波音787', '头等舱', 10, 8),
                                                                               ('空客A350', '经济舱', 300, 280),
                                                                               ('波音777', '商务舱', 50, 45);

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

-- 插入航班行程数据
INSERT INTO FlightSchedule (FlightID, DepartureAirport, ArrivalAirport, DepartureDateTime, ArrivalDateTime, FlightDuration) VALUES
                                                                                                                                (1, '北京首都国际机场', '上海浦东国际机场', '2024-06-01 07:00:00', '2024-06-01 09:30:00', '02:30:00'),
                                                                                                                                (2, '广州白云国际机场', '成都双流国际机场', '2024-07-15 12:00:00', '2024-07-15 14:00:00', '02:00:00'),
                                                                                                                                (3, '深圳宝安国际机场', '杭州萧山国际机场', '2024-08-20 07:30:00', '2024-08-20 09:45:00', '02:15:00'),
                                                                                                                                (4, '西安咸阳国际机场', '昆明长水国际机场', '2024-09-05 10:00:00', '2024-09-05 12:45:00', '02:45:00'),
                                                                                                                                (5, '重庆江北国际机场', '南京禄口国际机场', '2024-10-10 08:20:00', '2024-10-10 10:35:00', '02:15:00');
