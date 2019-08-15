package model.dao;

import org.junit.Test;

public class ConnectDBTest {

	@Test
	public void test() throws Exception {
		ConnectDB cdb = new ConnectDB();
		cdb.connectOracle1();
	}

}
