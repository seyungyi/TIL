package model.dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("최초에 한 번만 수행됨!!");
	}	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("마지막에 한 번만 수행됨!!");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("테스트 메서드가 호출될 때마다 먼저 수행됨!!");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("테스트 메서드가 호출될 때마다 나중에 수행됨!!");
	}

	@Test
	public void test1() {
		//fail("Not yet implemented");
		System.out.println("테스트 수행 메서드-1");
	}
	
	@Test
	public void test2() {
		//fail("Not yet implemented");
		System.out.println("테스트 수행 메서드-2");
	}
	
	@Test
	public void test3() {
		//fail("Not yet implemented");
		System.out.println("테스트 수행 메서드-3");
	}
}
