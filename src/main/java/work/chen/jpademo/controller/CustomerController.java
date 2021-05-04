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


  /**
   * Hibernate: select customeren0_.id as id1_2_, customeren0_.age as age2_2_, customeren0_.name as name3_2_, customeren0_.phone as phone4_2_, customeren0_.sex as sex5_2_ from jpa_customer customeren0_
   * Hibernate: select orderentit0_.assid as assid3_0_0_, orderentit0_.oid as oid1_0_0_, orderentit0_.oid as oid1_0_1_, orderentit0_.tprice as tprice2_0_1_ from jap_order orderentit0_ where orderentit0_.assid=?
   * Hibernate: select orderentit0_.assid as assid3_0_0_, orderentit0_.oid as oid1_0_0_, orderentit0_.oid as oid1_0_1_, orderentit0_.tprice as tprice2_0_1_ from jap_order orderentit0_ where orderentit0_.assid=?
   * 查询 1 + N 次 （N表示主表中的数据数量）
   */
  @RequestMapping(value = "/findAll", method = RequestMethod.POST)
  public List<CustomerEntity> findAll() {
    return customerService.findAll();
  }

  @RequestMapping(value = "/findByid", method = RequestMethod.POST)
  public CustomerEntity findByid(){
    return customerService.findByid(1l);
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
