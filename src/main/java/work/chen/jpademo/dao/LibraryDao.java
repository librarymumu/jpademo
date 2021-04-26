package work.chen.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import work.chen.jpademo.entity.LibraryEntity;

public interface LibraryDao extends JpaRepository<LibraryEntity, Long>, JpaSpecificationExecutor<LibraryEntity> {
}
