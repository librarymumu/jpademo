package work.chen.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
 * @Description: 客户控制层
 * @Date: 2021/4/19 22:12
 * @Version: 1.0
 */

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {


  @Autowired
  private CustomerService customerService;

  @RequestMapping(value = "/findAll", method = RequestMethod.POST)
  public List<CustomerEntity> list() {
    return customerService.findAll();
  }

}
