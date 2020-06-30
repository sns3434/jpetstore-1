package com.example.jpetstore.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.AuctionDao;
import com.example.jpetstore.dao.CategoryDao;
import com.example.jpetstore.dao.EventDao;
import com.example.jpetstore.dao.ItemDao;
import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.ProductDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

/**
 * JPetStore primary business object.
 * 
 * <p>This object makes use of five DAO objects, decoupling it
 * from the details of working with persistence APIs. So
 * although this application uses iBATIS for data access,
 * a different persistence tool could be dropped in without
 * breaking this class.
 *
 * <p>The DAOs are made available to the instance of this object
 * using Dependency Injection. (The DAOs are in turn configured using
 * Dependency Injection themselves.) We use Setter Injection here,
 * exposing JavaBean setter methods for each DAO. This means there is
 * a JavaBean property for each DAO. In the present case, the properties
 * are write-only: there are no corresponding getter methods. Getter
 * methods for configuration properties are optional: Implement them
 * only if you want to expose those properties to other business objects.
 *
 * <p>There is one instance of this class in the JPetStore application.
 * In Spring terminology, it is a "singleton", referring to a
 * per-Application Context singleton. The factory creates a single
 * instance; there is no need for a private constructor, static
 * factory method etc as in the traditional implementation of
 * the Singleton Design Pattern. 
 *
 * <p>This is a POJO. It does not depend on any Spring APIs.
 * It's usable outside a Spring container, and can be instantiated
 * using new in a JUnit test. However, we can still apply declarative
 * transaction management to it using Spring AOP.
 *
 * <p>This class defines a default transaction annotation for all methods.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified by Changsup Park
 */
@Service
@Transactional
public class PetStoreImpl implements PetStoreFacade { 
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private AuctionDao auctionDao;
	@Autowired
	private OrderDao orderDao;

	private EventDao eventDao;
	@Autowired		// applicationContext.xml�뜝�럥�뱺 �뜝�럩�젧�뜝�럩踰ε뜝�럥彛� scheduler �뤆�룇鍮섊뙼�뮁紐닷뜝占� �썒�슣�닔占쎈엷 �뛾�룇猷뉛옙踰�
	private ThreadPoolTaskScheduler scheduler;


	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	@Override
	public void insertAuctionItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.insertAuctionItem(item);
	}

	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.insertItem(item);
		
	}

	public List<Item> getItemListIsAuction() {
		// TODO Auto-generated method stub
		return itemDao.getItemListIsAuction();
	}

	public Account getAccount(String username) {
		return accountDao.getAccount(username);
	}

	public Account getAccount(String username, String password) {
		return accountDao.getAccount(username, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<String> getUsernameList() {
		return accountDao.getUsernameList();
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Product> getProductList() {
		// TODO Auto-generated method stub
		return productDao.getProductList();
	}


	public Product getProductByName(String name) {
		// TODO Auto-generated method stub
		return productDao.getProductByName(name);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}
	public List<Item> searchItemList(String keywords) {
		System.out.println("'%"+keywords+"%'");
		return itemDao.searchItemList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}

	public List<Item> getItemListByProduct(String productId) {
		return itemDao.getItemListByProduct(productId);
	}
	
	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}

	public boolean isItemInStock(String itemId) {
		return itemDao.isItemInStock(itemId);
	}

	public void insertOrder(Order order) {
		itemDao.updateQuantity(order);	    
		orderDao.insertOrder(order);
	}
	
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}
public void testScheduler(Date closingTime) {
		
		Runnable updateTableRunner = new Runnable() {	
			// anonymous class �뜝�럩�젧�뜝�럩踰�
			@Override
			public void run() {   // �뜝�럥裕욑옙�냲�삕辱됰봾占쏙옙�몠�뜝�럥�뱺 �뜝�럩踰ε뜝�럥�돵 亦껋꼶梨띰옙�굥�뜝�럩踰� �뜝�럥諭잌뜝�럩�젧 �뜝�럥六삣뜝�럩�젍�뜝�럥�뱺 �뜝�럥堉꾢뜝�럥六у뜝�럥彛� �뜝�럩�굚�뜝�럥�뵜�뜝�럩諭� �뜝�럩�젧�뜝�럩踰�				
				Date curTime = new Date();
				// �뜝�럥堉꾢뜝�럥六� �뜝�럥六삣뜝�럩�젍�뜝�럩踰� �뜝�럥六삥뤆�룄�궚占쎈굵 �뜝�럩�쓧�뜝�럥堉롥뜝�럥由��뜝�럥�뿰 �윜諭꾩삕 �뜝�럥六삥뤆�룊�삕 �뜝�럩逾졾뜝�럩�쓧�뜝�럩踰� closing time �뤆�룆占썬굦諭� �뤆�룆�돱占쎈츎 event�뜝�럩踰� �뜝�럡留믣뜝�럡臾띰옙紐닷뜝占� �솻洹⑥삕�뇦猿볦삕 

				//二쇱꽍eventDao.closeEvent(curTime);	// EVENTS �뜝�럥占쎈���삕占쎈턄占쎈눀�겫�슦踰� �뜝�럩�읉占쎄턀�겫�뼔援� �뤆�룄�돫占쎈뼁	

				itemDao.closeEvent(curTime);	// EVENTS �뜝�럥占쎈���삕占쎈턄占쎈눀�겫�슦踰� �뜝�럩�읉占쎄턀�겫�뼔援� �뤆�룄�돫占쎈뼁	

				System.out.println("updateTableRunner is executed at " + curTime);
			}
		};
		

		//二쇱꽍HashMap<String, Date> hashMap = new HashMap<String, Date>();
		//二쇱꽍hashMap.put("curTime", new Date());			// �뜝�럩寃긷뜝�럩�궨 �뜝�럥六삥뤆�룊�삕: PK �뤆�룆占썬굦紐드슖�댙�삕 �뜝�럡�뀬�뜝�럩�뮔
		//二쇱꽍hashMap.put("closingTime", closingTime);	// 亦껋꼶梨띰옙�굥�뜝�럩踰� 占쎈꽞占쎄턁筌앾옙 �뜝�럥六삥뤆�룊�삕
		//二쇱꽍eventDao.insertNewEvent(hashMap);	// EVENTS �뜝�럥占쎈���삕占쎈턄占쎈눀�겫�슜�뱺 �뜝�럩�읉占쎄턀�겫�뼔援� �뜝�럡�븳�뜝�럩肉�

		// �뜝�럥裕욑옙�냲�삕繞벿우삕 �뜝�럡臾멨뜝�럡�뎽: closingTime�뜝�럥�뱺 updateTableRunner.run() 嶺뚮∥�뾼占쎄틬�뜝�럥援� �뜝�럥堉꾢뜝�럥六�


		scheduler.schedule(updateTableRunner, closingTime);  
		
		System.out.println("updateTableRunner has been scheduled to execute at " + closingTime);
	}


public void insertQuantity(String itemId, int qty) {
	// TODO Auto-generated method stub
	itemDao.insertQuantity(itemId, qty);
}

	@Override
	public List<Auction> getAuctionByUsername(String username) {
		// TODO Auto-generated method stub
		return auctionDao.getAuctionByUsername(username);
	}
	
	@Override
	public Auction getAuctionByAuctionId(int auctionId) {
		return auctionDao.getAuctionByAuctionId(auctionId);
	}
  
@Override
public List<Item> getItemListByUsername(String username) {
	// TODO Auto-generated method stub
	return itemDao.getItemListByUsername(username);
}


public void insertAuction(Auction auction) {
	// TODO Auto-generated method stub
	auctionDao.insertAuction(auction);
	
}

@Override
public void updateAuctionItem(Item item) {
	itemDao.updateAuctionItem(item);
	
}

@Override
public List<Item> getAuctionItemListByUsername(String username) {
	// TODO Auto-generated method stub
	return itemDao.getAuctionItemListByUsername(username);
}

@Override
public void updateAuctionId(Auction auction) {
	// TODO Auto-generated method stub
	itemDao.updateAuctionId(auction);
}

@Override
public int getMaxAuctionId(String itemId) {
	// TODO Auto-generated method stub
	return auctionDao.getMaxAuctionId(itemId);
}

public void updateItem(Item item) {
	// TODO Auto-generated method stub
	itemDao.updateItem(item);
}

@Override
public void deleteItem(String itemId) {
	// TODO Auto-generated method stub
	itemDao.deleteItem(itemId);

}

@Override
public void deleteAuctionbyAuctionId(int auctionId) {
	// TODO Auto-generated method stub
	auctionDao.deleteAuctionbyAuctionId(auctionId);
	
}


@Override
public int getAuctionIdByItem(String itemId) {
	// TODO Auto-generated method stub
	return auctionDao.getAuctionIdByItem(itemId);
}

@Override
public void updateIsSuccessful(Auction auction) {
	// TODO Auto-generated method stub
	auctionDao.updateIsSuccessful(auction);
}

}