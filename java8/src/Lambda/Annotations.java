package Lambda;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

public class Annotations {

	@Retention(RetentionPolicy.RUNTIME)//生命周期的注解(RetentionPolicy.SOURCE  : 注解只保留在源文件中,RetentionPolicy.CLASS  : 注解保留在class文件中，在加载到JVM虚拟机时丢弃RetentionPolicy.RUNTIME  : 注解保留在程序运行期间，此时可以通过反射获得定义在某个类上的所有注解。)
	@Target({ElementType.TYPE_USE,ElementType.TYPE_PARAMETER})
	public @interface NonEmpty{//
		
	}
	public static class Holder<T> extends Object{
		public void method() throws Exception{
			
		}
	}
	
	public static void main(String[] args) {
		final Holder<String> holder = new Holder<String>();
		Collection<String> strings = new ArrayList<>();
	}
}
