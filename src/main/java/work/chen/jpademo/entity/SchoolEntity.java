package work.chen.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @NamedEntityGraph : 解决findAll 查询 1 + N 条结果
 *		name ： 表示实体图名
 *			对应SchoolDao findAll 方法上的 @EntityGraph 注解 value 值 保持一致
 *		attributeNodes ：表示被标注的要懒加载的的节点 比如此例中 : 要懒加载的子分类Set集合studentEntities
 * 	n
 */

@Data
@Entity
@Table(name = "jpa_school")
@NamedEntityGraph(name = "studentEntities.Graph", attributeNodes = {@NamedAttributeNode("studentEntities")})
public class SchoolEntity implements Serializable {

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String address;

	@OneToMany(targetEntity = StudentEntity.class)
	@JoinColumn(name = "scid", referencedColumnName = "id", foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT))
	private Set<StudentEntity> studentEntities = new HashSet<>();

}
