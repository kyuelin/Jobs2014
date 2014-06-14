package patterns;

public class Proxy {	
	interface IAction {
		public void doAction();
	}
	
	class RealAction implements IAction {
		@Override
		public void doAction() {
			System.out.println("RealAction::doAction()");
		}
	}
	
	class ProxyAction implements IAction {
		private RealAction action = null; 
		@Override
		public void doAction() {
			if (action == null) {
				action = new RealAction();				
			}
			action.doAction();
		}						
	}

	public static void main(String[] args) {	
		IAction act = new Proxy().new ProxyAction();		
		act.doAction();
	}
}


