package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDep ===");
		Department dep = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(dep);
		for(Seller seller1: sellers) {
			System.out.println(seller1);
		}
		
		System.out.println("=== TEST 3: seller findAll ===");
		sellers = sellerDao.findAll();
		for(Seller seller1: sellers) {
			System.out.println(seller1);
		}
		
		System.out.println("=== TEST 4: seller Insert ===");
		Seller newSeller = new Seller(null, "Gabriel", "gabrielsousa@snews.tv", new Date(), 2696.0 , dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = "+ newSeller.getId());

	}
}
