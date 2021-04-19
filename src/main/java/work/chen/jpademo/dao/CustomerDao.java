package work.chen.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import work.chen.jpademo.entity.CustomerEntity;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.dao
 * @ClassName: CustomerDao
 * @Author: chencmumu
 * @Description: 客户操作
 * @Date: 2021/4/19 21:50
 * @Version: 1.0
 */
public interface CustomerDao extends JpaRepository<CustomerEntity, Long>, JpaSpecificationExecutor<CustomerEntity> { }
