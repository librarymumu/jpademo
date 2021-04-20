package work.chen.jpademo.bean;

import lombok.Data;
import work.chen.jpademo.entity.CustomerEntity;
import work.chen.jpademo.entity.OrderEntity;

import java.io.Serializable;
import java.util.List;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.bean
 * @ClassName: DataCustomerListResponse
 * @Author: chencmumu
 * @Description: 客户列表返回结果bean
 * @Date: 2021/4/20 19:27
 * @Version: 1.0
 */
@Data
public class DataCustomerListResponse implements Serializable {

  private CustomerEntity customerEntity;

  private List<OrderEntity> orderEntities;

}
