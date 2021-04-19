package work.chen.jpademo.service;

import org.springframework.stereotype.Service;
import work.chen.jpademo.entity.CustomerEntity;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.service
 * @ClassName: CustomerService
 * @Author: chencmumu
 * @Description: 业务层接口
 * @Date: 2021/4/19 22:10
 * @Version: 1.0
 */
public interface CustomerService {

  List<CustomerEntity> findAll();

}
