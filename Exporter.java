import java.io.File;
import java.io.PrintWriter;

/**
 * Class contains six functions. import-, exportCourses(), import- and exportTimetable() are private, internal functions. The import- functions (are supposed to) fetch the required data from other classes/objects that contain the corresponding user input. The export- functions create html files based on previously (above) imported data. printCourses() and -Timetable() are the ones that should be called by other classes.
 * Created files' filenames are defined by static variables coursesfn and timetablefn. Timetable attributes 'weekday names' and 'scale of timetable', are also defined statically.
 */
public class Exporter {

	private static File file;
	private static PrintWriter out;

	private static String coursesfn = "kurssit.html";	// fn for filename
	private static String timetablefn = "lukkari.html";	// fn for filename

	private static int nCourses;	// number of courses (for creating courses efficiently)

	// below: a number of timetable attributes
	private static String[] weekdays = {"Ma", "Ti", "Ke", "To", "Pe", "La", "Su"};	// weekday names (abbreviations) for timetable exporting
	private static int nDays = 5;	// number of days to print in timetable (defaults to 5, but changing this value will allow implementation of mon-d timetables, where d is mon, tue, ..., or sun)
	private static int firsthr = 8;	// 1st hour to print in timetable
	private static int lasthr = 18;	// last hour to print in timetable

	// multi-function int variable
	private static int i;

	/**
	 *	Fetches courses (names and credits) from external class
	 */
	private static String[][] importCourses() {
		// for-each course get names and credits from external class ...

		nCourses = 3;	// number of courses, obtained from external class ...
		String[][] courses = new String[nCourses][2];	// courses[number of courses][0 course name, 1 credits] to print

		// below: sample course data for testing purposes
		courses[0][0] = "Ohjelmointitekniikka (Scala)";
		courses[0][1] = "4";
		courses[1][0] = "Ohjelmistotuotanto";
		courses[1][1] = "4";
		courses[2][0] = "Laskennan mallit";
		courses[2][1] = "6";

		return courses;
	}

	/**
	 *	Prints String[][] courses as html file (file name defined by String coursesfn)
	 */
	private static boolean exportCourses(String[][] courses) {
		try {
			file = new File(coursesfn);
			out = new PrintWriter(file);
		}
		catch (Exception e) {
			return false;
		}

		if (file != null && out != null) {

			// print head
			out.write("<HTML>\n<HEAD>\n<TITLE>Suoritetut kurssit</TITLE>\n</HEAD>\n\n<BODY>\n\n");

			// begin table
			out.write("\n<TABLE BORDER=0 CELLSPACING=20>\n");

			// print table headers
			out.write("<TR><TD><H2>Suoritetut kurssit</H2></TD><TD></TD></TR>\n");
			out.write("<TR><TD><B>Kurssin nimi</B></TD><TD><B>op</B></TD></TR>\n");

			// print courses
			i = 0;
			while (i < nCourses) {
				out.write("<TR><TD>" + courses[i][0] + "</TD><TD>" + courses[i][1] + "</TD></TR>\n");
				i++;
			}

			// end table
			out.write("</TABLE>\n\n");

			// print tail
			out.write("\n</BODY>\n</HTML>");
		}

		// don't forget to close PrintStream!
		out.flush();
		out.close();

		// everything went well
		return true;
	}

	/**
	 *	Fetches timetable data from some external class.
	 */
	private static String[][] importTimetable() {
		String[][] timetable = new String[24][5]; // timetable[hours][days]
		// get events from external class ...

		// below: sample timetable for testing purposes
		timetable[0][0] = "Eka";
		timetable[10][2] = "Moi";
		timetable[11][4] = "Hei";

		return timetable;
	}

	/**
	 *	Prints String[][] timetable as html file (file name defined by String timetablefn)
	 */
	private static boolean exportTimetable(String[][] timetable) {
		try {
			file = new File(timetablefn);
			out = new PrintWriter(file);
		}
		catch (Exception e) {
			return false;
		}

		if (file != null && out != null) {

			// print head
			out.write("<HTML>\n<HEAD>\n<TITLE>Suoritetut kurssit</TITLE>\n</HEAD>\n\n<BODY>\n\n");

			// begin table
			out.write("\n<TABLE BORDER=0 CELLSPACING=10>\n\n");

			// print weekdays (titles)
			out.write("<TR>\n<TD></TD>\n");
			i = 0;
			while (i < nDays) {
				out.write("<TD><B>" + weekdays[i] + "</B></TD>\n");
				i++;
			}
			out.write("</TR>\n\n");

			// print hours and events
			int j = firsthr-1;
			while (j < lasthr) {
				// print hour
				out.write("<TR>\n<TD><B>" + (j+1) + "</B></TD>\n");

				// print events
				i = 0;
				while (i < nDays) {
					if (timetable[j][i] != null) {	// don't print "null"!
						out.write("<TD>" + timetable[j][i] + "</TD>\n");
					}
					else {
						out.write("<TD></TD>\n");
					}
					i++;
				}

				// end row, move on to next hour
				out.write("</TR>\n\n");
				j++;
			}

			// end table
			out.write("</TABLE>\n\n");

			// print tail
			out.write("\n</BODY>\n</HTML>");
		}

		// don't forget to close PrintStream!
		out.flush();
		out.close();

		// everything went well
		return true;
	}

	/**
	 *	Function imports and prints courses. Call this.
	 */
	public static void printCourses() {
		if (exportCourses(importCourses())) {
			System.out.println("Luotiin " + coursesfn);
		}
	}

	/**
	 *	Function imports and prints timetable. Call this.
	 */
	public static void printTimetable() {
		if (exportTimetable(importTimetable())) {
			System.out.println("Luotiin " + timetablefn);
		}
	}

}
