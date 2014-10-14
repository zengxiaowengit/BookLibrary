package dao;

import java.math.BigDecimal;
import java.util.List;

public interface AuthorDAO{

	public List<Author> queryAuthor(BigDecimal authorID) throws Exception;
}
