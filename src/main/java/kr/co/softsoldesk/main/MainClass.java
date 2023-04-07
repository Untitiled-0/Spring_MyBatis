package kr.co.softsoldesk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softsoldesk.beans.JdbcBean;
import kr.co.softsoldesk.config.BeanConfigClass;
import kr.co.softsoldesk.mapper.MapperInterface;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		MapperInterface mapper = ctx.getBean("test_mapper", MapperInterface.class);
		 
	
		 
		mapper.insert_data(new JdbcBean(1,"s"));
		 
		/* mapper.delete_data(1); */
		
		
		List<JdbcBean> list1 = mapper.select_data(1);
		for(JdbcBean bean1 : list1) {
			System.out.printf("int_data : %d\n", bean1.getInt_data());
			System.out.printf("str_data : %s\n", bean1.getStr_data());
		}
		
		
		ctx.close();
	}
}