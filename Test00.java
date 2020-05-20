/**
*Ӧ��IO��+Properties+�������ʵ�ֶ�̬��������
*
*/
import java.util.*;
import java.io.*;
public class Test00
{
	public static void main(String[] args){
		//1������Properties
		Properties p = new Properties();
		FileInputStream fis = null;

		try{
			//2������IO��
			fis = new FileInputStream("class.properties");
			//3������
			p.load(fis);
			//ͨ��keyֵ��ȡvalue
			String className = p.getProperty("ClassName");//ע�ⷽ����getProperty();����getProperties
			//�����ȡ����
			Class c = Class.forName(className);

			//��������
			Object o = c.newInstance();
			System.out.println(o);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(fis != null){
				try{
					//�ر�IO��
					fis.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}		
	}
}