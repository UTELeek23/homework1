use homework1;

CREATE TABLE RoleName(
    RoleID INT AUTO_INCREMENT PRIMARY KEY,
    NameRole VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE Questions(
	QuestID INT AUTO_INCREMENT primary key,
    Content NVARCHAR(100) NOT NULL unique
);

CREATE TABLE Users (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    FullName NVARCHAR(255),
    Username VARCHAR(100) NOT NULL UNIQUE,
    Password VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    QuestID INT,
    Answer nvarchar(100) not null,
    RoleID INT,
    FOREIGN KEY (RoleID) REFERENCES RoleName(RoleID),
    FOREIGN KEY (QuestID) REFERENCES Questions(QuestID)
);



