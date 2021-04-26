package work.chen.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.chen.jpademo.bean.DataCustomerListRequest;
import work.chen.jpademo.bean.DataCustomerListResponse;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.controller
 * @ClassName: CustomerController
 * @Author: chencmumu
 * @Description: 客户控制层  Cuetomer Order 一对多
 * @Date: 2021/4/19 22:12
 * @Version: 1.0
 */

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "/findByid", method = RequestMethod.POST)
  public CustomerEntity findByid(){
    return customerService.findByid(1l);
  }

  @RequestMapping(value = "/findAll", method = RequestMethod.POST)
  public List<DataCustomerListResponse> findAll() {
    return customerService.findAll();
  }


  /**
   * 一对多查询所有
   * @return
   */
  @RequestMapping(value = "/getlist", method = RequestMethod.POST)
  public List<CustomerEntity> getList() {
    return customerService.getList();
  }

  /**
   * 分页 及 多条件 排序 查询
   * @param dataCustomerListRequest
   * @return
   */
  @RequestMapping(value = "/list", method = RequestMethod.POST)
  public Page<CustomerEntity> list(DataCustomerListRequest dataCustomerListRequest) {
    return customerService.list(dataCustomerListRequest);
  }

  /**
   * left join 查询
   * @return
   */
  @RequestMapping(value = "/leftJoin", method = RequestMethod.POST)
  public List<CustomerEntity> leftJoin() {
    return customerService.leftJoin();
  }



}
