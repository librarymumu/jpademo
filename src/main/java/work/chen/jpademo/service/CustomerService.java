package work.chen.jpademo.service;

import work.chen.jpademo.bean.DataCustomerListResponse;

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

  List<DataCustomerListResponse> findAll();

}
