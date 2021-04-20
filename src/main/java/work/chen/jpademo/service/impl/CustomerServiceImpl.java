package work.chen.jpademo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.bean.DataCustomerListResponse;
import work.chen.jpademo.dao.CustomerDao;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.entity.OrderEntity;
import work.chen.jpademo.service.CustomerService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
@Transactional
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDao customerDao;

  @Override
  public List<DataCustomerListResponse> findAll() {
    List<DataCustomerListResponse> response = new ArrayList<>();
    DataCustomerListResponse dataCustomerListResponse = new DataCustomerListResponse();
    List<CustomerEntity> customerEntities = customerDao.findAll();
    for(CustomerEntity customerEntity : customerEntities) {
      List<OrderEntity> orderEntities = customerEntity.getOrderEntities();
      dataCustomerListResponse.setCustomerEntity(customerEntity);
      dataCustomerListResponse.setOrderEntities(orderEntities);
      response.add(dataCustomerListResponse);
    }
    return response;
  }

  @Override
  public List<CustomerEntity> getList() {
    return customerDao.findAll();
  }

  @Override
  public Page<CustomerEntity> list() {
    Page<CustomerEntity> customerEntities = customerDao.findAll(new Specification<CustomerEntity>() {
      @Override
      public Predicate toPredicate(Root<CustomerEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        // 查询条件
        return null;


      }
    }, PageRequest.of(0, 10));
    return customerEntities;
  }
}
