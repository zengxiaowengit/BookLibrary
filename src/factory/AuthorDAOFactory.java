package factory;

import impl.AuthorDAOImpl;


public class AuthorDAOFactory {
	
	public static AuthorDAOImpl getAuthorDAOInstance() {
		// TODO Auto-generated method stub
		return new AuthorDAOImpl();
	}
}
