
import junit.framework.TestCase;


public class SaveLoaderTest extends TestCase {

	public SaveLoaderTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testSaverLoader() {
		SaverLoader test = new SaverLoader();
	}
	
	public void testSavingKeraajaWithoutPath() {
		SaverLoader test = new SaverLoader();
		Keraaja testikeraaja = new Keraaja();	
		assertTrue(test.saveObject(testikeraaja));
	}
	
	public void testSavingKeraajaWithPath() {
		SaverLoader test = new SaverLoader();
		Keraaja testikeraaja = new Keraaja();
		assertTrue(test.saveObject(testikeraaja, "../joku"));
	}
	
	public void testSavingObjectWithoutPath() {
		SaverLoader test = new SaverLoader();
		Object testiobject = new Object();	
		assertFalse(test.saveObject(testiobject));
	}
	
	public void testSavingObjectWithPath() {
		SaverLoader test = new SaverLoader();
		Object testiobject = new Object();
		assertFalse(test.saveObject(testiobject, "../joku"));
	}
	
	public void testSavingObjectWithPathWithoutRights() {
		SaverLoader test = new SaverLoader();
		Object testiobject = new Object();
		assertFalse(test.saveObject(testiobject, "/var/testi"));
	}
	
	public void testSavingNullWithPath() {
		SaverLoader test = new SaverLoader();
		assertFalse(test.saveObject(null, "../joku"));
	}
	
	public void testSavingNullWithPathWithoutRights() {
		SaverLoader test = new SaverLoader();
		assertFalse(test.saveObject(null, "/var/testi"));
	}
	
	public void testLoadObjectWithPath() {
		SaverLoader test = new SaverLoader();
		assertTrue(test.loadObject("testi") instanceof Object);
	}
}
