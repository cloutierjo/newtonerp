package newtonERP.orm;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;
import newtonERP.orm.exceptions.OrmException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class OrmTest.
 */
public class OrmTest {

	/** The orm. */
	private Orm orm;

	/**
	 * Sets the up.
	 * 
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		orm = Orm.getInstance("unitTesting");
	}

	/**
	 * Tear down.
	 * 
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
		orm.disconnect();
	}

	/**
	 * Test get instance.
	 */
	@Test
	public final void testGetInstance() {
		assertSame(orm, Orm.getInstance("unitTesting"));
	}

	/**
	 * Test get instance not already instentiate.
	 */
	@Test
	public final void testGetInstanceNotAlreadyInstentiate() {
		assertNotSame(orm, Orm.getInstance("sqlite"));
	}

	/**
	 * Test get instance after disconect.
	 */
	@Test
	public final void testGetInstanceAfterDisconect() {
		orm.disconnect();
		assertNotSame(orm, Orm.getInstance("unitTesting"));
	}

	/**
	 * Test get instance not existing.
	 */
	@Test(expected = OrmException.class)
	public final void testGetInstanceNotExisting() {
		Orm.getInstance("noneExistingDB");
	}

	/**
	 * Test disconnect.
	 */
	@Test
	public final void testDisconnectTwice() {
		orm.disconnect();
		try{
			orm.disconnect();
		}catch(Exception e){
			fail();
		}
	}

	/**
	 * Test disconnect.
	 */
	@Test
	public final void testDisconnectUsedAfter() {
		orm.disconnect();
		fail("Not yet implemented");
	}
}