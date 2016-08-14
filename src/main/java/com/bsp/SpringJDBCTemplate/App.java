package com.bsp.SpringJDBCTemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bsp.dao.CustomerDao;
import com.bsp.model.Customer;

public class App {
    public static void main( String[] args ){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("Main.xml");
        
        CustomerDao dao = (CustomerDao) context.getBean("customerDAO");
        dao.insert(new Customer(4, "Harry Carr", "9 Butterfield Way", "hcarr3@sina.com.cn"));
        dao.insert(new Customer(5, "Willie Campbell", "48 Hayes Drive", "wcampbell4@archive.org"));
        dao.insert(new Customer(6, "Amanda Parker", "095 Londonderry Alley", "aparker5@plala.or.jp"));
        
        Customer customer1 = dao.findByCustomerId(4);
        System.out.println(customer1);
    }
}
