CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(45) DEFAULT NULL,
  `DEPARTMENT` varchar(45) DEFAULT NULL,
  `HIRE_DATE` datetime DEFAULT NULL,
  `SALARY` decimal(11,4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8