package com.home.hibernate;

import static org.junit.Assert.*;

import javax.imageio.spi.ServiceRegistry; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

    @Test
    public void test() { 
         //ceshi 
        Session session = null;
		// 创建一个读取主配置文件的对象
		Configuration cfg = new Configuration();
		// 读取主配置文件
		cfg.configure();
		// 创建Session工厂
		SessionFactory factory = cfg.buildSessionFactory();
		// 打开Session
		// session = factory.openSession();
		// 如果在主配置文件将session绑定到线程中，所以可以从线程中取出session
		session =  	factory.openSession();
		
        //3. 开启事务
        Transaction transaction = session.beginTransaction();
        
        //4. 执行保存操作
        User user = new User("Sky","333","409169399@qq.com","厦门");
        session.save(user);
        
        //5. 提交时务
        transaction.commit();
        
        //6. 关闭 Session
        session.close();
        //7. 关闭 SessionFactory 对象
        factory.close();
        
    }
}