package factory;

import dao.BookDAO;
import impl.BookDAOImpl;
<!-- this is the the third file of the second revise.-->
public class BookDAOFactory {
	public static BookDAO getBookDAOInstance()
	{
		return new BookDAOImpl() ;
	}
}
	