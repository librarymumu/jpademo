package work.chen.jpademo.dao;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import work.chen.jpademo.entity.SchoolEntity;

import java.util.List;


public interface SchoolDao extends JpaRepository<SchoolEntity, Long>, JpaSpecificationExecutor<SchoolEntity> {

	@EntityGraph(value = "studentEntities.Graph", type = EntityGraph.EntityGraphType.FETCH)
	List<SchoolEntity> findAll();
}
