package contacts;

import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class TestNGPractice extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void test1() {
		System.out.println("Test 1");
	}
	
	@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test(dependsOnMethods = "test1")
	public void test3() {
		System.out.println("Test 3");
	}
	
}
