package work.chen.jpademo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * LibraryEntity 主表类（一的一方）
 * @Setter
 * @Getter
 *	注意：这里不可以使用lombok的@Data注解 （双向绑定后重新toString查询时会导致内存溢出）
 */

@Setter
@Getter
@Entity
@Table(name = "jpa_library")
public class LibraryEntity {

	/**
	 * 自增主键
	 */
	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long lid;

	/**
	 * 图书馆名称
	 */
	private String libraryname;

	/**
	 * 图书馆地址
	 */
	@Column(length = 1000)
	private String address;

	/**
	 * 图书馆电话
	 */
	@Column(length = 11)
	private String tel;

	/**
	 * 放弃关联维护 - 参照对方的关系进行维护
	 * JsonIgnore ： json 在序列化的时候 忽略bookEntities属性
	 * @OneToMany(targetEntity = BookEntity.class)
	 * @JoinColumn(name = "assid", referencedColumnName = "lid", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	 */


	/**
	 *
	 * 	@OneToMany : 一对多（声明一的一方）
	 *		mappedBy ： 放弃关联键维护 （一对多关联关系参照对方）
	 *			libraryEntity	: 这里指的是BookEntity中的绑定的 LibraryEntity 的名称 libraryEntity
	 *		cascade	: 级联操作
	 *			CascadeType.ALL ：主从的增删改查可以保持同步 （也可单独开启，一般全部开启）
	 *	@JsonIgnore ： Json压缩时忽略此属性（此属性压缩时不做处理）当使用Springboot的@RestController注解时，一定要追加
	 * 	List<BookEntity> bookEntities = new ArrayList<>(); 多的一方的实体类放入List中
	 *
	 */
	@OneToMany(mappedBy = "libraryEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookEntity> bookEntities = new ArrayList<>();


}
