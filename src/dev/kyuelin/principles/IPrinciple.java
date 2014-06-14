package dev.kyuelin.principles;

// interface segregation principle - good example
public interface IPrinciple {
	interface IWorkable {
		public void work();
	}
	interface IFeedable {
		public void eat();
	}
	class Worker implements IWorkable, IFeedable {
		public void work() {}
		public void eat() {}
	}
	class Robot implements IWorkable {
		public void work() {}
	}
	class SuperWorker implements IWorkable, IFeedable {
		public void work() {}
		public void eat() {}
	}
	class Manager {
		IWorkable worker;
		public void setWorker(IWorkable w) {worker = w;}
		public void manage() {worker.work();}
	}
}
