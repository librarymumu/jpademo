package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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

	@Override
	@Cacheable(value = "findById")
	public SingleTestEntity findById(long id) {
		return singleTestDao.findById(id).get();
	}

	@Override
	@CachePut(value = "findById", key = "#id")
	public SingleTestEntity update(long id) {
		SingleTestEntity singleTestEntity = new SingleTestEntity();
		singleTestEntity.setId(1L);
		singleTestEntity.setUsername("木木111");
		singleTestEntity.setIntroduce("introduce11111");
		SingleTestEntity entity = singleTestDao.save(singleTestEntity);
		return entity;
	}
}
