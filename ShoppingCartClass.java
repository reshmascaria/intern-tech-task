package shoppingCart;


import java.util.*;


class Product {  
	int productID, productPrice;  
	String productName;    
	public Product(int productID, String productName, int productPrice) {  
		this.productID = productID; 
		this.productName = productName; 
		this.productPrice = productPrice;   
	}  
}  

/*
 *Class to store product details. Five products are available in the store
 */

class Products{
	final List<Product> products = new ArrayList<Product>();
	
	public Products(){
		//Creating Products  
	    Product p1 = new Product(101,"iphone7",749);  
	    Product p2 = new Product(102,"iphone 7 plus", 929);  
	    Product p3 = new Product(103,"iphone 8", 979);
	    Product p4 = new Product(104,"iphone XR", 1229);
	    Product p5 = new Product(105,"iphone XS", 1629);
	    
	    //Adding Product to list  
	    products.add(p1);  
	    products.add(p2);  
	    products.add(p3); 
	    products.add(p4);
	    products.add(p5);
	}
	
	public List<Product> getProducts(){
		return products;
	}
}

class User{
	String userID, userName;
	int cartID;
	
	public User (String userID, String userName, int cartID) {
		this.userID = userID;
		this.userName = userName;
		this.cartID = cartID;
	}
	
	public Integer getCartID() {
		return cartID;
	}
}


/*
 * Class to store user details. Three users are present in the store.
 * Each user has userId, username and cartID
 */
class Users{
	final List<User> users = new ArrayList<User>();
	
	public Users(){
		//Creating users
		User u1 = new User("jsmith", "John Smith", 1001);
		User u2 = new User("lmason", "Lily Mason", 1002);
		User u3 = new User("fhills", "Frank Hills", 1003);
		
		users.add(u1);
		users.add(u2);
		users.add(u3);
		
	}
	
	public List<User> getUsers(){
		return users;
	}	
}


public class ShoppingCartClass {  
	
    List<User> users = new Users().getUsers();
    
    int flag =0, cartID = 0;
    String userName;

    
    public void InitialOut() {
    	
    	/*
    	 * UserId of user is inputed and welcome message is displayed
    	 * If invalid userId error message is displayed
    	 */
    	System.out.println("Enter userId : ");
		Scanner scanner = new Scanner (System.in);
		String user = scanner.nextLine();
		
		scanner.close();
		for(User u:users) {
			if(user.equals(u.userID)) {
				flag = 1;
				userName = u.userName;
				cartID = u.cartID; 
				break;
			}
			else
				continue;
		}
    	if(flag == 1) {
			System.out.println("Welcome " + userName);
			System.out.println("\nOur shop contains the following products");
			
			// Entire products in the shop is displayed
			List<Product> products = new Products().getProducts(); 
	 	    //Traversing list of products in store
	  	    System.out.println("PRODUCT ID \t PRODUCT NAME \t\t PRICE" );
	   	    for(Product p:products){  
	   	    	System.out.println(p.productID+"\t\t "+p.productName+"\t\t "+p.productPrice);  
	   	    }
    	}
    	else
    		System.out.println("Invalid user");

    }
    
	public static void main(String[] args) {  
		ShoppingCartClass shop = new ShoppingCartClass();
		
		// Only welcome message is displayed initially
		shop.InitialOut();
	}  

}  
