package dev.kyuelin.patterns;


public class BuilderDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuilderObject bo = new BuilderObject.BuilderObjectBuilder(12).name("twelve").build();
		
		System.out.println("bo:" + bo.getId()+"-"+bo.getName());
	}

}

