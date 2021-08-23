DROP TABLE `appointment`;


CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'bookID',
  `name` varchar(100) NOT NULL COMMENT 'name',
  `number` int(11) NOT NULL COMMENT 'number',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='bookList';


INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
	(1000, 'JavaProgramming', 10),
	(1001, 'dataStructure', 10),
	(1002, 'desigModel', 10),
	(1003, 'EditPrinciples', 10);


CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT 'bookID',
  `student_id` bigint(20) NOT NULL COMMENT 'studentId',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'ReservationTime' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BookAppointment';


CREATE TABLE users (
  user_id VARCHAR(255) NOT NULL COMMENT 'bookID',
  user_name VARCHAR(255) NOT NULL COMMENT 'studentId',
  user_pwd VARCHAR(255) NOT NULL COMMENT 'saltedpassword',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='usertable';


SELECT * FROM `book`;
SELECT * FROM `appointment`;


