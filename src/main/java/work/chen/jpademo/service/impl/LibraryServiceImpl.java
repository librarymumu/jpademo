package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.bean.DataLibraryListResponse;
import work.chen.jpademo.dao.LibraryDao;
import work.chen.jpademo.entity.BookEntity;
import work.chen.jpademo.entity.LibraryEntity;
import work.chen.jpademo.service.LibraryService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryDao libraryDao;

	@Override
	public List<LibraryEntity> findAll() {
		return libraryDao.findAll();
	}

	@Override
	public List<DataLibraryListResponse> getLibraryAndBookData() {
		List<DataLibraryListResponse> responses = new ArrayList<>();
		DataLibraryListResponse dataLibraryListResponse = new DataLibraryListResponse();
		List<LibraryEntity> libraryEntities = libraryDao.findAll();
		for (LibraryEntity libraryEntity : libraryEntities) {
			dataLibraryListResponse.setLibraryEntity(libraryEntity);
			List<BookEntity> bookEntities = libraryEntity.getBookEntities();
			dataLibraryListResponse.setBookEntities(bookEntities);
			responses.add(dataLibraryListResponse);
		}
		return responses;
	}
}
