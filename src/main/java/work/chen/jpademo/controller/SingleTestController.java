package work.chen.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.chen.jpademo.entity.SingleTestEntity;
import work.chen.jpademo.service.SingleTestService;

import java.util.List;

@RestController
@RequestMapping(value = "/single")
public class SingleTestController {

	@Autowired
	private SingleTestService singleTestService;

	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<SingleTestEntity> findAll() {
		return singleTestService.findAll();
	}

	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public SingleTestEntity findById(long id) {
		return singleTestService.findById(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public SingleTestEntity update(long id) {
		 return singleTestService.update(id);
	}
}
