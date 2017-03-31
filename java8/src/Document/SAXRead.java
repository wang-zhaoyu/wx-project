package Document;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class SAXRead {
	
	/**
	 * 传入xml字符串
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	private static Document paseXmlStr2Document(String xml) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new ByteArrayInputStream(xml.getBytes()));
		return doc;
	}
	/**
	 * 传入xml文件路径
	 * @param filePath
	 * @return
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	private static Document paseFileStr2Document1(String filePath) throws DocumentException, FileNotFoundException{
		SAXReader reader = new SAXReader();
		File xmlFile = new File(filePath);
		return reader.read(xmlFile);
	}
	/**
	 * 传入xml文件路径
	 * @param filePath
	 * @return
	 * @throws DocumentException
	 * @throws FileNotFoundException
	 */
	private static Document paseFileStr2Document(String filePath) throws DocumentException, FileNotFoundException{
		SAXReader reader = new SAXReader();
		File xmlFile = new File(filePath);
		FileInputStream fis = new FileInputStream(xmlFile);
		return reader.read(fis);
	}
	
	public static void main(String[] args) {
		try {
			Document doc = paseFileStr2Document1("D:/s.xml");
			Element root = doc.getRootElement();
			//打印根节点下某节点名对应的节点值
			System.out.println(root.elementText("节点名"));
			//打印根节点的名字
			System.out.println(root.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
