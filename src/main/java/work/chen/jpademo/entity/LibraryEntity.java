package work.chen.jpademo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
	 */
//	@OneToMany(targetEntity = BookEntity.class)
//	@JoinColumn(name = "assid", referencedColumnName = "lid", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	/**
	 * cascade 级联操作 - CascadeType.ALL （相当于 ）
	 *
	 */
	@OneToMany(mappedBy = "libraryEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookEntity> bookEntities = new ArrayList<>();


}
