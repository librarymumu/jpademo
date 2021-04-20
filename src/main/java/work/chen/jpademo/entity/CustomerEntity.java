package work.chen.jpademo.entity;

        import com.fasterxml.jackson.annotation.JsonIgnore;
        import lombok.Data;

        import javax.persistence.*;
        import java.util.ArrayList;
        import java.util.List;

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
public class CustomerEntity {

  // 主键自增
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(length = 11)
  private long cid;

  // 客户姓名
  @Column(length = 255)
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

  @OneToMany(targetEntity = OrderEntity.class)
  @JoinColumn(name = "assid", referencedColumnName = "cid",  foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT) )
  private List<OrderEntity> orderEntities = new ArrayList<>();
}
