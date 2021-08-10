-- 创建图书表 도서표 만들기
CREATE TABLE `book` (
  `book_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'bookID',
  `name` varchar(100) NOT NULL COMMENT 'name', --도서명
  `number` int(11) NOT NULL COMMENT 'number', --소장수량
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='bookList'; --도서목록

-- 初始化图书数据 도서 데이터 초기화
INSERT INTO `book` (`book_id`, `name`, `number`)
VALUES
	(1000, 'JavaProgramming', 10), --자바프로그래밍
	(1001, 'dataStructure', 10), --데이터구조
	(1002, 'desigModel', 10), --디자인 모델
	(1003, 'EditPrinciples', 10); --편집 번역 원리

-- 创建预约图书表 예약 도서표 만들기
CREATE TABLE `appointment` (
  `book_id` bigint(20) NOT NULL COMMENT 'bookID',
  `student_id` bigint(20) NOT NULL COMMENT 'studentId',
  `appoint_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'ReservationTime' ,
  PRIMARY KEY (`book_id`, `student_id`),
  INDEX `idx_appoint_time` (`appoint_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='BookAppointment'; --예약도서표
