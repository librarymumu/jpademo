package work.chen.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "jpa_book")
public class BookEntity {

	/**
	 * 自增主键
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 11)
	private long id;

	/**
	 * 书籍名称
	 */
	private String name;

	/**
	 * 书籍作者
	 */
	private String author;

	/**
	 * 书籍总页数
	 */
	@Column(length = 8)
	private int bookpagesize;

	/**
	 * 书籍简介
	 */
	@Column(length = 1000)
	private String introduce;

	/**
	 * @ManyToOne 多对一（声明在的多的一方）
	 *		targetEntity : 目标实体类Class对象
	 * @JoinColumn	关联关系
	 * 		name :  关联字段名称（从表中关联字段的名称）
	 *		referencedColumnName : 关联关系参照主表中的那个字段（这里是jpa_library表中的主键lid）
	 *		foreignKey : 外键
	 *			@ForeignKey(value = ConstraintMode.NO_CONSTRAINT) 放弃外键维护
	 * @JsonIgnore ： Json压缩时忽略此属性（此属性压缩时不做处理）当使用Springboot的@RestController注解时，一定要追加
	 * private LibraryEntity libraryEntity 一的一方 类与类之间的绑定
	 */
	@ManyToOne(targetEntity = LibraryEntity.class)
	@JoinColumn(name = "assid", referencedColumnName = "lid", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	@JsonIgnore
	private LibraryEntity libraryEntity;


}
