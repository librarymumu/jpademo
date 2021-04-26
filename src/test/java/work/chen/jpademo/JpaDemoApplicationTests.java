package work.chen.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.dao.CustomerDao;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.entity.OrderEntity;

import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {

  @Autowired
  private CustomerDao customerDao;



  @Autowired
  private RedisTemplate<String,String> redisTemplate;

  @Test
  public void set(){
    redisTemplate.opsForValue().set("myKey","myValue");
    System.out.println(redisTemplate.opsForValue().get("myKey"));
  }


  @Test
  @Transactional
  @Rollback(false)
  void testSelect() {
    List<CustomerEntity> customerEntities = customerDao.findAll();
    for(CustomerEntity customerEntity : customerEntities) {
      List<OrderEntity> orderEntities = customerEntity.getOrderEntities();
      for(OrderEntity orderEntity : orderEntities) {
        System.out.println(orderEntity);
      }
    }
  }

}
