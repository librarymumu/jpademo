package work.chen.jpademo.service;

import work.chen.jpademo.entity.BookEntity;
import work.chen.jpademo.entity.LibraryEntity;

import java.util.List;

public interface BookService {

	public List<LibraryEntity> findAll();
}
