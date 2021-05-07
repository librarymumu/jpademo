package work.chen.jpademo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.bean.DataCustomerListRequest;
import work.chen.jpademo.dao.CustomerDao;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.entity.OrderEntity;
import work.chen.jpademo.service.CustomerService;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
  public int saveCustomerAndOrder() {
    CustomerEntity customerEntity = new CustomerEntity();
    OrderEntity orderEntity = new OrderEntity();
    orderEntity.setTprice(new BigDecimal(3476.23));
    customerEntity.setName("张三");
    customerEntity.setAge(16);
    customerEntity.setPhone("19890989761");
    customerEntity.setSex("1");
    customerEntity.getOrderEntities().add(orderEntity);
    CustomerEntity entity = customerDao.save(customerEntity);
    if (entity != null) {
      return 1;
    }
    return 0;
  }

  @Override
  public List<CustomerEntity> findAll() {
    return customerDao.findAll();
  }

  @Override
  @Cacheable(cacheNames = "customerEntity")
  public CustomerEntity findByid(long l) {
    CustomerEntity customerEntity = customerDao.findById(1L).get();
//    CustomerEntity customerEntity = new CustomerEntity();
//    customerEntity.setName("木木");
//    customerEntity.setCid(3L);
//    redisTemplate.opsForValue().set("customerEntity", JSON.toJSONString(customerEntity));
    return customerEntity;
  }


  @Override
  public List<CustomerEntity> getList() {
    List<CustomerEntity> entities = customerDao.findAll();
//    redisTemplate.opsForSet().add("entities", entities);
    return entities;
  }


  @Override
  public Page<CustomerEntity> list(DataCustomerListRequest dataCustomerListRequest) {
    // 排序字段 及 排序
     Sort sortType;
    if (!"".equals(dataCustomerListRequest.getSortFiled())) {
      if ("DESC".equals(dataCustomerListRequest.getSort())) {
        sortType = Sort.by(dataCustomerListRequest.getSortFiled()).descending();
      } else {
        sortType = Sort.by(dataCustomerListRequest.getSortFiled()).ascending();
      }
    } else {
      sortType = Sort.unsorted();
    }
    Page<CustomerEntity> customerEntities = customerDao.findAll((Specification<CustomerEntity>) (root, criteriaQuery, criteriaBuilder) -> {
      // 查询条件
      List<Predicate> predicates = new ArrayList<>();
      if (!"".equals(dataCustomerListRequest.getName())) {
        predicates.add(criteriaBuilder.like(root.get("name"), '%' + dataCustomerListRequest.getName() + '%'));
      }
      return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
    }, PageRequest.of(dataCustomerListRequest.getPage(), dataCustomerListRequest.getSize(), sortType));
    return customerEntities;
  }

  @Override
  public List<CustomerEntity> leftJoin() {
    List<CustomerEntity> listResponses = customerDao.findAll((Specification<CustomerEntity>) (root, criteriaQuery, criteriaBuilder) -> {
      Join<CustomerEntity, OrderEntity> entityJoin = root.join("orderEntities", JoinType.LEFT);
      Predicate predicate = criteriaBuilder.equal(entityJoin.get("oid"), "3");
      return predicate;
    });
    return listResponses;
  }
}
