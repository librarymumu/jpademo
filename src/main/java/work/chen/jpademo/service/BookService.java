package work.chen.jpademo.service;

import work.chen.jpademo.entity.BookEntity;

import java.util.List;

public interface BookService {

	public List<BookEntity> findAll();
}
