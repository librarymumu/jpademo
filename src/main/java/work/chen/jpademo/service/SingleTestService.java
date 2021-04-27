package work.chen.jpademo.service;

import work.chen.jpademo.entity.SingleTestEntity;

import java.util.List;

public interface SingleTestService {

	List<SingleTestEntity> findAll();

	SingleTestEntity findById(long id);

	SingleTestEntity update(long id);
}
