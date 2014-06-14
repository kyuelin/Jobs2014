package com.ms.linken.logging;

public class SingleThreadTest implements TestInterface {

	private Runnable task; 
	
	public void setTask(Runnable t) {		
		task = t;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		new Thread(task).start();
	}

}
