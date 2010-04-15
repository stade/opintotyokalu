
import junit.framework.TestCase;

public class ExporterTest extends TestCase {
	
	public ExporterTest(String name) {
		super(name);
	}
	
	public void testExporter() {
		Exporter test = new Exporter();
	}

	public void testprintCourses() {
		Exporter test = new Exporter();
		Keraaja testikeraaja = new Keraaja();
		
		test.printCourses(testikeraaja);
		
	}
	
	public void testprintTimetable() {
		Exporter test = new Exporter();
		Keraaja testikeraaja = new Keraaja();
		
		test.printTimetable(testikeraaja);
		
	}
}