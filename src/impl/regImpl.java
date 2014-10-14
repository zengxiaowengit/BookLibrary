package impl;

import impl.reg;
import impl.select;

public class regImpl {
	reg reg1 = new reg();
	select select1 = new select();
	
	//校验业务,select  
    public int findByUserName(String userName) {  

    	int count = select1.selectByName(userName);
        return count;  
    }  
      
    //注册业务，insert  
    public int register(String userName, String passWord) throws Exception {  
        int count = reg1.register(userName,passWord);
        return count;  
    }  
}
