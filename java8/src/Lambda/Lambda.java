package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda {
	public static void main(String[] args) {
		List<String> lst = new ArrayList<String>();
		lst.add("wang");
		lst.add("zhao");
		lst.add("yu");
		pringListDouble(lst);
	}

	private static void printList(List<String> list){
		list.forEach(e -> System.out.println(e.toString() +"�ĳ���Ϊ"+e.length()));
	}
	private static void pringListDouble(List<String> list) {
		list.forEach(e -> {
			e = e + "haha";
			System.out.println(e.toString() +"�ĳ���Ϊ"+e.length());
		});
	}
}
