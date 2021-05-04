package work.chen.jpademo.service;

import org.springframework.data.domain.Page;
import work.chen.jpademo.bean.DataCustomerListRequest;
import work.chen.jpademo.bean.DataCustomerListResponse;
import work.chen.jpademo.entity.CustomerEntity;

import java.util.List;

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

  /**
   * 查询所有
   * @return
   */
  List<CustomerEntity> findAll();

  CustomerEntity findByid(long l);

  List<CustomerEntity> getList();

  Page<CustomerEntity> list(DataCustomerListRequest dataCustomerListRequest);

  List<CustomerEntity> leftJoin();

}
