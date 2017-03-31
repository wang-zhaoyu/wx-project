package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class DefaultAndStaticMethod {

	private interface Defaulable1{
		default String notReqired(){
			return "Default1 implementation";
		}
	}
	private static class Defaulable1Impl implements Defaulable1{
		
	}
	private static class OverrideDefaulable1Impl implements Defaulable1{
		@Override
		public String notReqired() {
			return "OverrideDefaulable11Impl implementation";
		}
	}
	//接口定义默认方法
	private interface Defaulable{
		default String notRequired(){
			return "Default implementation";
		}
	}
	
	private static class DefaulableImpl implements Defaulable{
		public void follow(){
			System.out.println("这是follow方法打印的东西");
		}
		
	}
	
	private static class OverrideDefaulableImpl implements Defaulable{
		@Override
		public String notRequired(){
			return "OverrideDefaulableImpl implementation";
		}
	}
	private interface DefaulableFactory{
		static<T> T create (Supplier<T> supplier){
			return supplier.get();
		}
	}
	public static void main(String[] args) {
		Defaulable defaulable = DefaulableFactory.create(DefaulableImpl::new);
		List<Defaulable> defaulableLst = Arrays.asList(defaulable);
		defaulableLst.forEach(d -> d.notRequired());
		defaulableLst.forEach(Defaulable::notRequired);
		System.out.println(defaulable.notRequired());
		defaulable = DefaulableFactory.create(OverrideDefaulableImpl::new);
		System.out.println(defaulable.notRequired());
		Defaulable1 defaulable1 = DefaulableFactory.create(Defaulable1Impl::new);
		System.out.println(defaulable1.notReqired());
		defaulable1 = DefaulableFactory.create(OverrideDefaulable1Impl::new);
		System.out.println(defaulable1.notReqired());
	}
}
