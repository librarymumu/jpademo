package work.chen.jpademo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

//@Data
@Setter
@Getter
@Entity
@Table(name = "jpa_book")
public class BookEntity implements Serializable {

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

	@ManyToOne(targetEntity = LibraryEntity.class)
	@JoinColumn(name = "assid", referencedColumnName = "lid", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private LibraryEntity libraryEntity;

}
