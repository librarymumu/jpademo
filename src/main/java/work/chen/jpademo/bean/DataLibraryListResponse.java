package work.chen.jpademo.bean;

import lombok.Getter;
import lombok.Setter;
import work.chen.jpademo.entity.BookEntity;
import work.chen.jpademo.entity.LibraryEntity;

import java.util.List;


@Setter
@Getter
public class DataLibraryListResponse {

	private LibraryEntity libraryEntity;

	private List<BookEntity> bookEntities;


}
