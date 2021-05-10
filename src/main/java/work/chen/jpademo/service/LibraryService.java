package work.chen.jpademo.service;

import work.chen.jpademo.bean.DataLibraryListResponse;
import work.chen.jpademo.entity.LibraryEntity;

import java.util.List;

public interface LibraryService {

	/**
	 * 模拟主表(jpa_library)及从表(jpa_booke)数据保存
	 * @return
	 */
	LibraryEntity save();

	/**
	 *  模拟主表(jpa_library)数据更新
	 * @return
	 */
	LibraryEntity update();

	/**
	 * 查找主表(jpa_library)所有的数据
	 * @return
	 */
	List<LibraryEntity> findAll();

	/**
	 * 查找主表(jpa_library)及对应从表(jpa_booke)数据
	 * @return
	 */
	List<DataLibraryListResponse> getLibraryAndBookData();

}
