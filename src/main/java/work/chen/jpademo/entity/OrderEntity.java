package work.chen.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.entity
 * @ClassName: OrderEntity
 * @Author: chencmumu
 * @Description: 订单实体类
 * @Date: 2021/4/19 21:23
 * @Version: 1.0
 */
@Entity
@Table(name = "jap_order")
@Data
public class OrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 11)
  private long oid;

  // 订单总价
  @Column(precision = 23, scale = 6)
  private BigDecimal tprice;

  /**
   * 多对一关联关系
   * JoinColumn 关联关系
   *    name : 目标字段 参考 主表关联字段
   *    referencedColumnName : 本表字段名
   */
  @ManyToOne
  @JoinColumn(name = "assid", referencedColumnName = "cid",  foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT) )
  private CustomerEntity customerEntity;
}
