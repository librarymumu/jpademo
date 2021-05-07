package work.chen.jpademo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import work.chen.jpademo.dao.LibraryDao;
import work.chen.jpademo.entity.LibraryEntity;

import java.util.List;

@SpringBootTest
class JpaDemoApplicationTests {


  @Autowired
  private LibraryDao libraryDao;




  @Test
  @Transactional
  @Rollback(false)
  public void LibrarySelect() {
    List<LibraryEntity> libraryEntities = libraryDao.findAll();
   for (LibraryEntity libraryEntity : libraryEntities) {
     System.out.println(libraryEntity.getLibraryname() + "-" + libraryEntity.getLibraryname());
   }
  }

}
