package Lambda;

import java.util.function.Supplier;

/**
 * �����ƶ�
 * @author wangzhaoyu
 *
 */
public class TypeInfer<T> {
	public static<E> E create(Supplier<E> supplier){
		return supplier.get();
	}

	public static<T> T defaultValue(){
		return null;
	}
	
	public T getOrDefault(T value,T defaultValue){
		return value == null ? value : defaultValue;
	}
	public static void main(String[] args) {
//		final TypeInfer<String> infer = TypeInfer.create(TypeInfer::new);
		final TypeInfer<String> infer =(TypeInfer<String>) ((Supplier)TypeInfer::new).get();
		System.out.println(infer.getOrDefault("22", TypeInfer.defaultValue()));;
	}
}
