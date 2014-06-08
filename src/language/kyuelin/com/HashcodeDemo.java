package language.kyuelin.com;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


class HashcodeDemo {
	
	public static Logger logger = LoggerFactory.getLogger(HashcodeDemo.class.getName());
						
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> sString = new HashSet<String>();
		sString.add("123");
		
		String s = "123";
		s="234";
	
		logger.warn(s);
		logger.warn("tests");
		logger.debug("tests");
		logger.info("tests");

	}
	
}
