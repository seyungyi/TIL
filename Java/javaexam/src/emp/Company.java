package emp;

interface Bonus {
	public abstract void incentive(int pay);
}
abstract class Employee {
	private String name;
	private int number;
	private String department;
	private int salary;
	
	Employee() {}
	Employee(String name, int number, String department, int salary) {
		this.name = name;
		this.number = number;
		this.department = department;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public abstract double tax();
}

class Secretary extends Employee implements Bonus {
	Secretary() {}
	Secretary(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	public double tax() {
		return getSalary()*0.1;
	}
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay*0.8));
	}
}
class Sales extends Employee implements Bonus {
	Sales() {}
	Sales(String name, int number, String department, int salary) {
		super(name, number, department, salary);
	}
	public double tax() {
		return getSalary()*0.13;
	}
	public void incentive(int pay) {
		setSalary(getSalary() + (int)(pay*1.2));
	}
	public double getExtraPay() {
		return getSalary()*0.03;
	}
}


public class Company {
	public static void main(String[] args) {
		Employee[] emp = new Employee[2];
		emp[0]= new Secretary("Duke", 1, "Secretary", 800);
		emp[1] = new Sales("Tuxi", 2, "Sales", 1200);
		printEmployee(emp, false); // 세금 안냄
		System.out.println();
		System.out.println("[인센티브 100 지급]");
		((Secretary)emp[0]).incentive(100);
		((Sales)emp[1]).incentive(100);
		/*
		 for(Employee data : emp)
		 	((Bonus)data).incentive(100);
		 */
		printEmployee(emp, true); // 세금 냄
		
	}
	public static void printEmployee(Employee[] emp, boolean isTax) {
		if(isTax == false) {
			System.out.println("   name\t  department\tsalary\textra pay");
			System.out.println("----------------------------------------------");
			for(int i=0; i<emp.length; i++) {
				System.out.printf("   %s\t  %s\t", emp[i].getName(),
						emp[i].getDepartment());
				if(emp[i] instanceof Sales) {
					System.out.printf("\t%d\t", emp[i].getSalary());
					System.out.println(((Sales)emp[i]).getExtraPay());
				} else {
					System.out.printf("%d\t", emp[i].getSalary());
					System.out.println();
				}
			}
		} else {
			System.out.println("   name\t  department\tsalary\ttax\textra pay");
			System.out.println("--------------------------------------------------");
			for(int i=0; i<emp.length; i++) {
				System.out.printf("   %s\t  %s\t", emp[i].getName(),emp[i].getDepartment());
				if(emp[i] instanceof Sales) {
					System.out.printf("\t%d\t%.1f\t", emp[i].getSalary(), emp[i].tax());
					System.out.println(((Sales)emp[i]).getExtraPay());
				} else {
					System.out.printf("%d\t%.1f", emp[i].getSalary(), emp[i].tax());
					System.out.println();
				}
			}
		}
	}
}
