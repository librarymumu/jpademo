package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.dao.SingleTestDao;
import work.chen.jpademo.entity.SingleTestEntity;
import work.chen.jpademo.service.SingleTestService;

import java.util.List;

@Service
@Transactional
public class SingleTestServiceImpl implements SingleTestService {

	@Autowired
	private SingleTestDao singleTestDao;

	@Cacheable(cacheNames = "singleFindAll")
	@Override
	public List<SingleTestEntity> findAll() {
		return singleTestDao.findAll();
	}
}
