create table if not exists tb_patient(
    ID           INT            NOT NULL AUTO_INCREMENT PRIMARY KEY
   ,NAME         VARCHAR(50)    NOT NULL
   ,EMAIL        VARCHAR(255)   NOT NULL UNIQUE
   ,PHONE        VARCHAR(20)    NOT NULL
   ,DOCUMENT     VARCHAR(11)    NOT NULL UNIQUE
   ,STREET_NAME  VARCHAR(100)   NOT NULL
   ,CITY         VARCHAR(50)    NOT NULL
   ,STATE        VARCHAR(50)    NOT NULL
   ,HOUSE_NUMBER VARCHAR(10)    NOT NULL
   ,ZIP_CODE     VARCHAR(8)     NOT NULL
);

create table if not exists tb_doctor(
     ID             INT            NOT NULL AUTO_INCREMENT PRIMARY KEY
    ,NAME           VARCHAR(50)    NOT NULL
    ,EMAIL          VARCHAR(255)   NOT NULL UNIQUE
    ,PHONE          VARCHAR(20)    NOT NULL
    ,MEDIC_DOCUMENT VARCHAR(11)    NOT NULL UNIQUE
    ,SPECIALTY      VARCHAR(30)    NOT NULL
    ,STREET_NAME    VARCHAR(100)   NOT NULL
    ,CITY           VARCHAR(50)    NOT NULL
    ,STATE          VARCHAR(50)    NOT NULL
    ,HOUSE_NUMBER   VARCHAR(10)    NOT NULL
    ,ZIP_CODE       VARCHAR(8)     NOT NULL
);

create table if not exists tb_medical_appointment(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY
   ,ID_DOCTOR INT NOT NULL
   ,ID_PATIENT INT NOT NULL
   ,DATE_MEDICAL_APPOINTMENT DATE NOT NULL
   ,FOREIGN KEY (ID_DOCTOR) references tb_doctor(id)
   ,FOREIGN KEY (ID_PATIENT) references tb_patient(id)
);

create table if not exists tb_medical_appointment_canceled(
     ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY
    ,ID_DOCTOR INT NOT NULL
    ,ID_PATIENT INT NOT NULL
    ,DATE_MEDICAL_APPOINTMENT DATE NOT NULL
    ,CANCELED_DATE DATE NOT NULL
    ,CANCELLATION_REASON varchar(255)
    ,FOREIGN KEY (ID_DOCTOR) references tb_doctor(id)
    ,FOREIGN KEY (ID_PATIENT) references tb_patient(id)
)
