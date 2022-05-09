package com.revature.GroupDP2;


import com.revature.GroupDP2.model.*;
import com.revature.GroupDP2.repository.CategoryRepository;
import com.revature.GroupDP2.util.StorageManager;
import com.revature.GroupDP2.util.TransactionManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GroupDp2Application {


	public static void main(String[] args) {
		SpringApplication.run(GroupDp2Application.class, args);

		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Payment.class);
		configuration.addAnnotatedClass(Cart.class);
		configuration.addAnnotatedClass(Product.class);
		configuration.addAnnotatedClass(Category.class);
		//Add your class to configuration.addAnnotatedClass here


		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		//Add your transactions in between


		//add your code here

		transaction.commit();

		/*
			StorageManager storageManager = new StorageManager();
			storageManager.addAnnotatedClass(Category.class);
			Session session = storageManager.initializeDatasource();
			TransactionManager transactionManager = new TransactionManager(session);
			CategoryRepository categoryRepository = new CategoryRepository(transactionManager,session);

			Category newCategory = new Category("Rock");
			categoryRepository.create(newCategory);
			//categoryRepository.delete(newCategory);
			//System.out.println(categoryRepository.getById(1));
			System.out.println(categoryRepository.getByCategoryName(newCategory));
		 */


	}

}
