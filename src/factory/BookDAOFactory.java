package factory;

import dao.BookDAO;
import impl.BookDAOImpl;

public class BookDAOFactory {
	public static BookDAO getBookDAOInstance()
	{
		return new BookDAOImpl() ;
	}
}
	