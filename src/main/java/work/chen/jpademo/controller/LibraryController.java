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

	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<LibraryEntity> findAll() {
		return libraryService.findAll();
	}


	@RequestMapping(value = "/findLibrayAndBookData", method = RequestMethod.POST)
	public List<DataLibraryListResponse> findLibrayAndBookData() {
		return libraryService.getLibraryAndBookData();
	}
}
