package work.chen.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import work.chen.jpademo.entity.SingleTestEntity;

public interface SingleTestDao extends JpaRepository<SingleTestEntity, Long>, JpaSpecificationExecutor<SingleTestEntity> {
}
