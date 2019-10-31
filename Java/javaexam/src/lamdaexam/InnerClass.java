package lamdaexam;

public class InnerClass { 
	public static void main(String[] args) {
		MyFunctionalInterface1 fi;
		
		fi= new MyFunctionalInterface1() {
				public void method1() {
					String str = "method call1";
					System.out.println(str);
				}
			};
		fi.method1();
		
		fi = new MyFunctionalInterface1() {
				public void method1() { 
					System.out.println("method call2");		
				}
			};
		fi.method1();
	}
}











