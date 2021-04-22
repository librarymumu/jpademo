package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chen.jpademo.dao.BookDao;
import work.chen.jpademo.entity.BookEntity;
import work.chen.jpademo.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {


	@Autowired
	private BookDao bookDao;

	@Override
	public List<BookEntity> findAll() {
		return bookDao.findAll();
	}
}
