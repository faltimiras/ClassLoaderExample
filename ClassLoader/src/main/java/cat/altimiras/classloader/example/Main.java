package cat.altimiras.classloader.example;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Map;
import java.util.Properties;

public class Main {

	public static void main(String... args) throws Exception {

		Main m = new Main();
		m.run();
	}

	public void run() throws Exception {

		Properties properties = new Properties();
		try (InputStream resourceStream = ClassLoader.getSystemClassLoader().getResourceAsStream("impl.properties")) {
			properties.load(resourceStream);
		}

		for (Map.Entry<Object, Object> prop : properties.entrySet()) {

			String versionName = (String) prop.getKey();
			URL url = new URL("file://" + prop.getValue());
			ClassLoader theClassLoader = new URLClassLoader(new URL[]{url});

			Class theClassClass = Class.forName("cat.altimiras.classloader.TheClass", true, theClassLoader);
			Method theGetter = theClassClass.getMethod("get", String.class);
			Object theInstance = theClassClass.getConstructor().newInstance();
			String result = (String) theGetter.invoke(theInstance, "Buzz light year");

			System.out.println("Version: \"" + versionName + "\" Output: \"" + result + "\"");
		}
	}
}