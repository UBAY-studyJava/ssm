package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.dao.AppointmentDao;
import com.soecode.lyf.dao.BookDao;
import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.enums.AppointStateEnum;
import com.soecode.lyf.exception.AppointException;
import com.soecode.lyf.exception.NoNumberException;
import com.soecode.lyf.exception.RepeatAppointException;
import com.soecode.lyf.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖 주입Service의존
	@Autowired
	private BookDao bookDao;

	@Autowired
	private AppointmentDao appointmentDao;


	@Override
	public Book getById(long bookId) {
		return bookDao.queryById(bookId);
	}

	@Override
	public List<Book> getList() {
		return bookDao.queryAll(0, 1000);
	}
	
	@Override
	public int modify(long bookId, String name, int number) {
		return bookDao.modifyDetail(bookId, name, number);
	}
	
	@Override
	public int delete(long bookId) {
		return bookDao.delete(bookId);
	}

	@Override
	public int insert(String name, int number) {
		return bookDao.insert(name, number);
	}

	
	
	
	@Override
	@Transactional
	/**
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格			주석 제어 트랜잭션 방법의 장점 : 1. 개발진이 만장일치로 트랜잭션 방법의 프로그래밍 스타일을 명시하기로 약속함
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部	2. 트랜잭션 메서드의 실행 시간을 최대한 짧게 보장하며, 다른 네트워크 조작, RPC/HTTP 요청 또는자는 사무방법의 외부로 박리된다.
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制					3. 모든 방법에 트랜잭션이 필요한 것은 아닙니다. 만약 단 하나의 수정 작업만 있다면, 읽기 작업에는 트랜잭션 제어가 필요 없습니다.
	 * 
	 */
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			// 减库存 재고 감소
			int update = bookDao.reduceNumber(bookId);
			if (update <= 0) {// 库存不足 재고 부족
				throw new NoNumberException("no number");
			} else {
				// 执行预约操作 예약 작업을 실행
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if (insert <= 0) {// 重复预约 중복 예약
					throw new RepeatAppointException("repeat appoint");
				} else {// 预约成功 예약 성공
					Appointment appointment = appointmentDao.queryByKeyWithBook(bookId, studentId);
					return new AppointExecution(bookId, AppointStateEnum.SUCCESS, appointment);
				}
			}
		} catch (NoNumberException e1) {
			throw e1;
		} catch (RepeatAppointException e2) {
			throw e2;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			// 所有编译期异常转换为运行期异常 모든 컴파일러 기간이 비정상적으로 운영 기간 이상으로 전환됨
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}
	
	@Override
	public List<Appointment> getAppointment(){
		return appointmentDao.appointAll();
	}

}
