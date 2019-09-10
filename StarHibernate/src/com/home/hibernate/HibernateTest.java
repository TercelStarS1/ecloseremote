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
		// ����һ����ȡ�������ļ��Ķ���
		Configuration cfg = new Configuration();
		// ��ȡ�������ļ�
		cfg.configure();
		// ����Session����
		SessionFactory factory = cfg.buildSessionFactory();
		// ��Session
		// session = factory.openSession();
		// ������������ļ���session�󶨵��߳��У����Կ��Դ��߳���ȡ��session
		session =  	factory.openSession();
		
        //3. ��������
        Transaction transaction = session.beginTransaction();
        
        //4. ִ�б������
        User user = new User("Sky","333","409169399@qq.com","����");
        session.save(user);
        
        //5. �ύʱ��
        transaction.commit();
        
        //6. �ر� Session
        session.close();
        //7. �ر� SessionFactory ����
        factory.close();
        
    }
}