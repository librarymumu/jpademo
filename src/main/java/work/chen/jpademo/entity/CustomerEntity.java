package work.chen.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: jpa-demo
 * @Package: work.chen.jpademo.entity
 * @ClassName: CustomerEntity
 * @Author: chencmumu
 * @Description: 客户实体类
 * @Date: 2021/4/19 21:23
 * @Version: 1.0
 */
@Entity
@Table(name="jpa_customer")
@Data
public class CustomerEntity implements Serializable {

  // 主键自增
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 11)
  private long id;

  // 客户姓名
  private String name;

  // 客户性别 0： 男  1： 女
  @Column(length = 1)
  private String sex;

  // 客户性别
  @Column(length = 3)
  private int age;

  // 客户手机号码
  @Column(length = 11)
  private String phone;

  /**
   *  @OneToMany
   *    targetEntity : 需要关联的目标实体类字节码文件
   *    fetch
   *      fetch = FetchType.EAGER 立即加载
   *      fetch = FetchType.LAZY  延迟加载
   *
   *  @JoinColumn
   *    name ： 关联字段名称 （在从表中显示）
   *    referencedColumnName ： 主表中与从表中的关联字段（一般是主表的主键）
   *  foreignKey
   *    @ForeignKey(value = ConstraintMode.NO_CONSTRAINT) 取消数据库中外键关联
   *
   *  cascade
   *    级联操作
   */
  @OneToMany(targetEntity = OrderEntity.class, cascade = CascadeType.ALL)
  @JoinColumn(name = "cid", referencedColumnName = "id",  foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT) )
  private Set<OrderEntity> orderEntities = new HashSet<>();
}
