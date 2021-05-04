package work.chen.jpademo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "jpa_library")
public class LibraryEntity implements Serializable {

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

	@OneToMany(mappedBy = "libraryEntity")
	private Set<BookEntity> bookEntities = new HashSet<>();

}
