package dao;
import java.util.List;
public interface BookDAO {

	public void delete(String title) throws Exception;
	public List<Book> queryByAuthor(String author) throws Exception;
	public List<Book> queryByTitle(String title) throws Exception;
	public void revise(Book book) throws Exception;
}
