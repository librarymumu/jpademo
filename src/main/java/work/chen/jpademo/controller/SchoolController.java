package work.chen.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.chen.jpademo.entity.SchoolEntity;
import work.chen.jpademo.service.SchoolService;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

	@Autowired
	private SchoolService schoolService;

	/**
	 * select schoolenti0_.id as id1_4_0_, studentent1_.id as id1_6_1_, schoolenti0_.address as address2_4_0_, schoolenti0_.name as name3_4_0_, studentent1_.age as age2_6_1_, studentent1_.sex as sex3_6_1_, studentent1_.username as username4_6_1_, studentent1_.scid as scid5_6_0__, studentent1_.id as id1_6_0__ from jpa_school schoolenti0_ left outer join jpa_student studentent1_ on schoolenti0_.id=studentent1_.scid
	 * @return
	 */
	@RequestMapping(value = "/findAll", method = RequestMethod.POST)
	public List<SchoolEntity> findAll() {
		return schoolService.findAll();
	}
}
