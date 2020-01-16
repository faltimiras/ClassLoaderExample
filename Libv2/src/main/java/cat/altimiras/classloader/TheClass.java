package cat.altimiras.classloader;

public class TheClass {

	private Delegate delegate = new Delegate();

	public String get(String name){
		return delegate.work(name);
	}
}
