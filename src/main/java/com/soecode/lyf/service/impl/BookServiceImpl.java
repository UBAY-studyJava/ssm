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

	// 注入Service依赖 서비스의존도 주입
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
	@Transactional
	/**
	 * 使用注解控制事务方法的优点： 1.开发团队达成一致约定，明确标注事务方法的编程风格
	 * 2.保证事务方法的执行时间尽可能短，不要穿插其他网络操作，RPC/HTTP请求或者剥离到事务方法外部
	 * 3.不是所有的方法都需要事务，如只有一条修改操作，只读操作不需要事务控制
	 * 
	 * 업무 제어 방법의 장점 설명 사용:
	 *1. 개발진이 약속하여 사무 방법의 프로그래밍 스타일을 명확하게 표시한다.
	 *2. 사무방법의 실행시간을 최대한 짧게 보장하고 다른 네트워크를 삽입하지 마십시오, RPC/HTTP.사무 방법 외부로 구하거나 박리
	 *3. 모든 방법이 사무가 필요한 것은 아닙니다. 단 한 가지 수정 조작이 있을 경우 읽기 조작은 사무제어가 필요 없습니다.
	 * 
	 */
	public AppointExecution appoint(long bookId, long studentId) {
		try {
			// 减库存 재고감소
			int update = bookDao.reduceNumber(bookId);
			if (update <= 0) {// 库存不足 재고부족 soldout
				throw new NoNumberException("no number");
			} else {
				// 执行预约操作 예약 조작 실행
				int insert = appointmentDao.insertAppointment(bookId, studentId);
				if (insert <= 0) {// 重复预约 중복예약
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
			// 所有编译期异常转换为运行期异常 모든 컴파일 시간 이상 징후를 런타임 이상 징후로 변환
			throw new AppointException("appoint inner error:" + e.getMessage());
		}
	}

}
