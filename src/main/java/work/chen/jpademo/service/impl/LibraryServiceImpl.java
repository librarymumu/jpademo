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
	public LibraryEntity save() {
		LibraryEntity libraryEntity = new LibraryEntity();
		BookEntity bookEntity = new BookEntity();
		BookEntity bookEntity1 = new BookEntity();
		List<BookEntity> bookEntities = new ArrayList<>();
		libraryEntity.setLibraryname("名称002");
		libraryEntity.setAddress("无锡市");
		libraryEntity.setTel("1909897");
		bookEntity.setAuthor("作者002");
		bookEntity.setBookpagesize(345);
		bookEntity.setIntroduce("测试数据简介");
		bookEntity1.setAuthor("作者002");
		bookEntity1.setBookpagesize(345);
		bookEntity1.setIntroduce("测试数据简介");
		bookEntities.add(bookEntity);
		bookEntities.add(bookEntity1);
		/**
		 * 绑定关系 ：
		 * 		一定要双向绑定 否则 从表数据关联键会是空值
		 */
		libraryEntity.setBookEntities(bookEntities);
		bookEntity.setLibraryEntity(libraryEntity);
		bookEntity1.setLibraryEntity(libraryEntity);
		/**
		 * 需要在 LibraryEntity 中配置级联操作 否则只会保存对应Entity的数据
		 */
		LibraryEntity entity = libraryDao.save(libraryEntity);
		return entity;
	}

	@Override
	public LibraryEntity update() {
		/**
		 * 部分更新 - 先查 在统一更新 否则 不为空的数据 会被更新为空
		 */
		LibraryEntity libraryEntity = libraryDao.findById(7L).get();
		libraryEntity.setAddress("长沙");
		LibraryEntity entity = libraryDao.save(libraryEntity);
		return entity;
	}

	@Override
	public List<LibraryEntity> findAll() {
		return libraryDao.findAll();
	}

	@Override
	public List<DataLibraryListResponse> getLibraryAndBookData() {
		List<DataLibraryListResponse> responses = new ArrayList<>();
		List<LibraryEntity> libraryEntities = libraryDao.findAll();
		for (LibraryEntity libraryEntity : libraryEntities) {
			DataLibraryListResponse dataLibraryListResponse = new DataLibraryListResponse();
			dataLibraryListResponse.setLibraryEntity(libraryEntity);
			List<BookEntity> bookEntities = libraryEntity.getBookEntities();
			dataLibraryListResponse.setBookEntities(bookEntities);
			responses.add(dataLibraryListResponse);
		}
		return responses;
	}
}
