package work.chen.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.chen.jpademo.bean.DataLibraryListResponse;
import work.chen.jpademo.entity.LibraryEntity;
import work.chen.jpademo.service.LibraryService;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public LibraryEntity save() {
		return libraryService.save();
	}


	/**
	 * 只查询主表数据
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<LibraryEntity> findAll() {
		return libraryService.findAll();
	}


	/**
	 * 查询主表数据及从表数据
	 * @return
	 */
	@RequestMapping(value = "/findLibrayAndBookData", method = RequestMethod.POST)
	public List<DataLibraryListResponse> findLibrayAndBookData() {
		return libraryService.getLibraryAndBookData();
	}
}
