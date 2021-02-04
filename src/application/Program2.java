package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		List<Department> deps = new ArrayList<>();
		
		System.out.println("=== TEST 1: dep findById ===");
		Department dep = departmentDao.findById(2);		
		System.out.println(dep);
		
		System.out.println();
		
		System.out.println("=== TEST 2: dep findAll ===");
		deps = departmentDao.findAll();
		for(Department dep1: deps) {
			System.out.println(dep1);
		}
		
		System.out.println("=== TEST 3: insert ===");
		Department newDep = new Department(null, "TI");
		departmentDao.insert(newDep);
		System.out.println("Created! New id: "+ newDep.getId());
		
		System.out.println();
		
		System.out.println("=== TEST 4: dep Update ===");
		dep = departmentDao.findById(5);
		dep.setName("TECNOLOGIA");
		departmentDao.update(dep);
		System.out.println("Atualizado! "+ dep);
		
		System.out.println("=== TEST 5: dep delete ===");
		System.out.print("Selecione um id para deletar: ");
		int id = sc.nextInt();
		departmentDao.deleteById(5);
		System.out.println("Deletado! "+ id);

		sc.close();

	}
}
