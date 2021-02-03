package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println();
		
		System.out.println("=== TEST 2: seller findByDep ===");
		Department dep = new Department(2, null);
		List<Seller> sellers = sellerDao.findByDepartment(dep);
		for(Seller seller1: sellers) {
			System.out.println(seller1);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 3: seller findAll ===");
		sellers = sellerDao.findAll();
		for(Seller seller1: sellers) {
			System.out.println(seller1);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 4: seller Insert ===");
		/*
		 * Seller newSeller = new Seller(null, "Gabriel", "gabrielsousa@snews.tv", new
		 * Date(), 2696.0 , dep); sellerDao.insert(newSeller);
		 * System.out.println("Inserted! New id = "+ newSeller.getId());
		 * 
		 * System.out.println();
		 */
		
		System.out.println("=== TEST 5: seller Update ===");
		seller = sellerDao.findById(1);
		seller.setName("Gabriel Oliveira");
		seller.setBaseSalary(9995.0);
		sellerDao.update(seller);
		System.out.println("Atualizado! "+ seller);
		
		System.out.println();
		
		System.out.println("=== TEST 6: seller Delete ===");
		System.out.print("Digite um Id: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete! "+ id);
		
		sc.close();

	}
}
