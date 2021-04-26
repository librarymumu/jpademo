package work.chen.jpademo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "jpa_single_test")
@Data
public class SingleTestEntity implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(length = 11)
	private long id;

	private String username;

	@Column(length = 11)
	private String cell;

	@Column(length = 1000)
	private String introduce;



}
