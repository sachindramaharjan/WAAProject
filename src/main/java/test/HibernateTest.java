package test;


import java.util.Date;

import mum.waaproject.enumeration.OrderStatus;
import mum.waaproject.enumeration.PaymentMethod;
import mum.waaproject.enumeration.PaymentStatus;
import mum.waaproject.enumeration.Role;
import mum.waaproject.enumeration.StockStatus;
import mum.waaproject.model.Address;
import mum.waaproject.model.Category;
import mum.waaproject.model.Customer;
import mum.waaproject.model.Invoice;
import mum.waaproject.model.Order;
import mum.waaproject.model.OrderLine;
import mum.waaproject.model.Payment;
import mum.waaproject.model.Product;
import mum.waaproject.model.Stock;
import mum.waaproject.model.Store;
import mum.waaproject.model.User;
import mum.waaproject.model.UserRole;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//create user and user role
public class HibernateTest {
	
	static Session session ;
	
	public static void main(String[] args) {
	
		UserTest();
	}
	
	public static void UserTest(){
		//create user roles
				UserRole role1 = new UserRole(Role.ROLE_ADMIN);
				UserRole role2 = new UserRole(Role.ROLE_USER);
				
				Address address = new Address();
				address.setCity("Fairfield");
				address.setStreet("1000 North Fourth Street");
				address.setState("Iowa");
				address.setZip("52557");
				address.setCountry("USA");
			
				Customer customer = new Customer();
				customer.setFirstname("Sachindra");
				customer.setLastname("Maharjan");
				customer.setMobile("9841562537");
				customer.setPhone("5548458");
				customer.setAddress(address);
				
				User user1 = new User();
				user1.setUsername("sachin");
				user1.setPassword("password");
				user1.setCustomer(customer);
				user1.addUserRole(role1);
				user1.addUserRole(role2);
				
				User user2 = new User();
				user2.setUsername("sachin1");
				user2.setPassword("password");
				user2.setCustomer(customer);
				user2.addUserRole(role1);
				user2.addUserRole(role2);
				
				/*Store store1 = new Store();
				store1.setName("Book Store");
				store1.setUser(user1);
				store1.setDescription("Book Store");
				
				Store store2 = new Store();
				store2.setName("Pet Store");
				store2.setUser(user2);
				store2.setDescription("Pet Store");
				
				Category category1 = new Category();
				category1.setName("Womens");
				category1.setDescription("");
				category1.setStore(store1);
				category1.setLeaf(false);
				
				Category category2 = new Category();
				category2.setName("Mens");
				category2.setDescription("");
				category2.setStore(store1);
				category2.setLeaf(false);
				
				Category category3 = new Category();
				category3.setName("Dress");
				category3.setDescription("");
				category3.setStore(store1);
				category3.setLeaf(true);
				category3.setParent(category1);
				
				Category category4 = new Category();
				category4.setName("Shoe");
				category4.setDescription("");
				category4.setStore(store1);
				category4.setLeaf(true);
				category4.setParent(category1);
				
				Category category5 = new Category();
				category5.setName("Jewellery");
				category5.setDescription("");
				category5.setStore(store1);
				category5.setLeaf(true);
				category5.setParent(category1);
				
				Product product1 = new Product();
				product1.setName("Product1");
				product1.setProductcode("P124");
				product1.setPrice(12.44);
				product1.setCategory(category3);
				product1.setStore(store1);
				
				Product product2 = new Product();
				product2.setName("Product2");
				product2.setProductcode("P224");
				product2.setPrice(12.44);
				product2.setCategory(category3);
				product2.setStore(store1);

				Product product3 = new Product();
				product3.setName("Product1");
				product3.setProductcode("P124");
				product3.setPrice(12.44);
				product3.setCategory(category3);
				product3.setStore(store2);
				
				Product product4 = new Product();
				product4.setName("Product2");
				product4.setProductcode("P224");
				product4.setPrice(12.44);
				product4.setCategory(category3);
				product4.setStore(store2);
				
				
				Order order1 = new Order();
				order1.setUser(user1);
				order1.setOrderedDate(new Date());
				order1.setShippedDate(new Date());
				order1.setStatus(OrderStatus.NEW.name());
				order1.setTotalAmount(100.22);
				
				OrderLine orderline1 = new OrderLine();
				orderline1.setOrder(order1);
				orderline1.setPrice(12.44);
				orderline1.setQuantity(2);
				orderline1.setProduct(product1);
				
				OrderLine orderline2 = new OrderLine();
				orderline2.setOrder(order1);
				orderline2.setPrice(10.77);
				orderline2.setQuantity(4);
				orderline2.setProduct(product2);
				
				Invoice invoice1 = new Invoice();
				invoice1.setCustomer(customer);
				invoice1.setOrder(order1);
				
				Payment payment1 = new Payment();
				payment1.setUser(user1);
				payment1.setOrder(order1);
				payment1.setMethod(PaymentMethod.MASTERCARD.name());
				payment1.setStatus(PaymentStatus.PROCESSED.name());
				*/
				
				SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
				Session session = sessionfactory.openSession();
				session.beginTransaction();
				
				//save user role
				session.save(role1);
				session.save(role2);
				
				session.save(user1);
				session.save(user2);
				
//				session.save(store1);
//				session.save(store2);
//				
//				session.save(category1);
//				session.save(category2);
//				session.save(category3);
//				session.save(category4);	
//				session.save(category5);
//			
//				session.save(product1);
//				session.save(product2);
//				session.save(product3);
//				session.save(product4);
//				//session.save(stock);
//			
//				session.save(order1);
//				session.save(orderline1);
//				session.save(orderline2);
//				session.save(invoice1);
//				session.save(payment1);
			
				session.getTransaction().commit();
				session.close();
			}
	}
	
