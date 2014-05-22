package language;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


class HashcodeDemo {
	
	public static Log logger = LogFactory.getLog(HashcodeDemo.class.getName());
						
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> sString = new HashSet<String>();
		sString.add("123");
		
		String s = "123";
		s="234";
	
		logger.warn(s);
		logger.warn("tests");

	}
	
}
