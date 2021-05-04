package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chen.jpademo.dao.SchoolDao;
import work.chen.jpademo.entity.SchoolEntity;
import work.chen.jpademo.service.SchoolService;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolDao schoolDao;

	@Override
	public List<SchoolEntity> findAll() {
		return schoolDao.findAll();
	}
}
