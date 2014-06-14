package dev.kyuelin.patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class HFBeverageDecorator {

	
	private static Logger logger = LoggerFactory.getLogger(HFBeverageDecorator.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HFBeverageDecorator deco = new HFBeverageDecorator();
		
		Beverage b1 = deco.new Expresso();
		logger.debug(b1.getDescription()+":"+b1.cost());

		Beverage b2 = deco.new DarkRoast();
		b2 = deco.new Mocha(b2);
		b2 = deco.new Mocha(b2);
		b2 = deco.new Milk(b2);
		logger.debug(b2.getDescription()+":"+b2.cost());
		
		
	}

	public abstract class Beverage {

		private String description = "Uknown Beverage";

		public String getDescription() {
			return description;
		}

		public abstract double cost();
	}

	public class DarkRoast extends Beverage {

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return 1.59;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "DarkRoast";
		}
	}

	public class Expresso extends Beverage {

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return 1.79;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return "Expresso";
		}
	}

	// Decorator
	public abstract class Condiments extends Beverage {
		public abstract String getDescription();
	}

	public class Milk extends Condiments {
		
		Beverage bvg;

		public Milk(Beverage b) {
			this.bvg=b;
		}

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return bvg.cost() + 0.5;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return bvg.getDescription()+", Milk";
		}

	}

	public class Chocolate extends Condiments {

		Beverage bvg;

		public Chocolate(Beverage b) {
			this.bvg=b;

		}

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return bvg.cost() + 0.5;
		}

		@Override
		public String getDescription() {
			// TODO Auto-generated method stub
			return bvg.getDescription()+", Chocolate";
		}

	}
	
	public class Mocha extends Condiments {
		
		Beverage bvg;

		public Mocha(Beverage b) {
			this.bvg = b;
		}

		@Override
		public String getDescription() {
			return bvg.getDescription()+", Mocha";
		}

		@Override
		public double cost() {
			// TODO Auto-generated method stub
			return 0.2 + bvg.cost();
		}
		
	}
}
