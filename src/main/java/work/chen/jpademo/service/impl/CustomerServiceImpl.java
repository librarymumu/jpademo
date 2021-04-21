package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import work.chen.jpademo.bean.DataCustomerListRequest;
import work.chen.jpademo.bean.DataCustomerListResponse;
import work.chen.jpademo.dao.CustomerDao;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.entity.OrderEntity;
import work.chen.jpademo.service.CustomerService;

import javax.persistence.criteria.Predicate;
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
  public Page<CustomerEntity> list(DataCustomerListRequest dataCustomerListRequest) {
    // 排序字段 及 排序
     Sort sort = null;
    if (!"".equals(dataCustomerListRequest.getSortFiled())) {
      if ("DESC".equals(dataCustomerListRequest.getSort())) {
         sort = Sort.by(Sort.Direction.DESC,dataCustomerListRequest.getSort());
      } else {
        sort = sort.by(dataCustomerListRequest.getSort()).ascending();
      }
    } else {
      sort = Sort.unsorted();
    }
    Page<CustomerEntity> customerEntities = customerDao.findAll((Specification<CustomerEntity>) (root, criteriaQuery, criteriaBuilder) -> {
      // 查询条件
      List<Predicate> predicates = new ArrayList<>();
      if (!"".equals(dataCustomerListRequest.getName())) {
        predicates.add(criteriaBuilder.like(root.get("name"), dataCustomerListRequest.getName()));
      }
      return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
    }, PageRequest.of(dataCustomerListRequest.getPage(), dataCustomerListRequest.getSize(), sort));
    return customerEntities;
  }
}
