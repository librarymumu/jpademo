package work.chen.jpademo.service;

import work.chen.jpademo.bean.DataLibraryListResponse;
import work.chen.jpademo.entity.LibraryEntity;

import java.util.List;

public interface LibraryService {

	List<LibraryEntity> findAll();

	List<DataLibraryListResponse> getLibraryAndBookData();

}
