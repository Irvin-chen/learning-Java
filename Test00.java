/**
*应用IO流+Properties+反射机制实现动态创建对象
*
*/
import java.util.*;
import java.io.*;
public class Test00
{
	public static void main(String[] args){
		//1、创建Properties
		Properties p = new Properties();
		FileInputStream fis = null;

		try{
			//2、创建IO流
			fis = new FileInputStream("class.properties");
			//3、加载
			p.load(fis);
			//通过key值获取value
			String className = p.getProperty("ClassName");//注意方法是getProperty();不是getProperties
			//反射获取类名
			Class c = Class.forName(className);

			//创建对象
			Object o = c.newInstance();
			System.out.println(o);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fis != null){
				try{
					//关闭IO流
					fis.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}		
	}
}