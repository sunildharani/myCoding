package inheritance;

public class TestMainClass {

	public static void main(String[] args) {
		TestInheritanceParent tp = new TestInheritanceParent();
		System.out.println(tp.getName());
		System.out.println(tp.getThisName());
		
		TestInheritence ti = new TestInheritence();
		System.out.println(ti.getName());
		System.out.println(ti.getThisName());
	
		TestInheritanceParent tip = new TestInheritence();
		System.out.println(tip.getName());
		System.out.println(tip.getThisName());
		
	}
	
	
}
