package work.chen.jpademo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import work.chen.jpademo.entity.BookEntity;

public interface BookDao extends JpaRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> { }
