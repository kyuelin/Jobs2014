package dev.kyuelin.nonblocking;

public class NewClass {

	private final ICallback cb;

	public NewClass(ICallback cb_) {
		cb=cb_;
	}
	
	public void callBackFromMain() {
		//do something

		//callback
		cb.callback();
	}

}
