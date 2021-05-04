package work.chen.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "jpa_student")
public class StudentEntity implements Serializable {

	@Id
	@Column(length = 11)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String username;

	@Column(length = 4)
	private int age;

	@Column(length = 1)
	private String sex;
}
