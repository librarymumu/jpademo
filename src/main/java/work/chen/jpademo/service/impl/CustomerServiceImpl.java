package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chen.jpademo.dao.CustomerDao;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.service.CustomerService;

import java.util.List;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.service.impl
 * @ClassName: CustomerServiceImpl
 * @Author: chencmumu
 * @Description: 业务层实现
 * @Date: 2021/4/19 22:11
 * @Version: 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  @Override
  public List<CustomerEntity> findAll() {
    return customerDao.findAll();
  }
}
