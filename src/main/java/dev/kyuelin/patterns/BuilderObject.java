package dev.kyuelin.patterns;

public class BuilderObject {
	
	private final int id;
	private final String name;
	
	private BuilderObject(BuilderObjectBuilder b) {
		id=b.id;
		name=b.name;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static class BuilderObjectBuilder {
		private final int id;
		private String name;
		
		public BuilderObjectBuilder(int i) {
			id=i;
		}
		
		public BuilderObjectBuilder name (String n) {
			this.name=n;
			return this;
		}
		
		public BuilderObject build() {
			return new BuilderObject(this);
		}
		
	}
}
