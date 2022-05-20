package com.revature.GroupDP2;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.CartRepository;
import com.revature.GroupDP2.repository.ProductRepository;
import com.revature.GroupDP2.model.*;

import com.revature.GroupDP2.repository.CategoryRepository;
import com.revature.GroupDP2.repository.UserRepository;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication(scanBasePackages = "com.revature.GroupDP2")
public class GroupDp2Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GroupDp2Application.class, args);
		//this is how you get a bean, beans act as global
		StorageManager storageManager = context.getBean(StorageManager.class);
		storageManager.addAnnotatedClass(User.class,Cart.class,Category.class,Product.class,Payment.class);
		context.start();
		

	}
}

