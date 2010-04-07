/**
 * Class contains six functions. import-, exportCourses(), import- and exportTimetable()
 * are private, internal functions. The import- functions (are supposed to) fetch the 
 * required data from other classes/objects that contain the corresponding user input.
 * The export- functions create html files based on previously (above) imported data.
 * printCourses() and -Timetable() are the ones that should be called by other classes.
 * 
 * Created files' filenames are defined by static variables coursesfn and timetablefn.
 * Timetable attributes 'weekday names' and 'scale of timetable', are also defined statically.
 * 
 * @author ryhmä?
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Exporter {

	private static File file;
	private static PrintWriter out;

	private static String coursesfn = "kurssit.html";	// fn for filename
	private static String timetablefn = "lukkari.html";	// fn for filename

	// total credits for printing courses ...
	private static int totalcr = 0;

	// below: a number of timetable variables
	private static String[] weekdays = {"Ma", "Ti", "Ke", "To", "Pe", "La", "Su"};	// weekday names (abbreviations) for timetable exporting
	private static int nDays = 5;	// number of days to print in timetable (defaults to 5, but changing this value will allow implementation of mon-d timetables, where d is mon, tue, ..., or sun)
	private static int firsthr = 8;	// 1st hour to print in timetable
	private static int lasthr = 18;	// last hour to print in timetable
	// end timetable variables

	// multi-function int variable
	private static int i;

	/**
	 *	Fetches names and credits of courses from external Keraaja object,
	 *	parses its kurssit field into a String[][], and returns it. 
	 *
	 *	TODO: This functions functionality might as well be in exportCourses()
	 *	(and then exportCourses could be renamed to printCourses())!
	 */
	private static String[][] importCourses() {

		Keraaja k = new Keraaja();	// new Keraaja() for testing, this should read getKeraaja()

		// for testing -- REMOVE THIS
		Kurssi a = new Kurssi("Tietorakenteet", 8);
		Kurssi c = new Kurssi("Laskennan mallit", 6);
		Kurssi b = new Kurssi("Ohjelmistotuotanto", 4);

		k.addKurssi(a);
		k.addKurssi(b);
		k.addKurssi(c);
		// end 'for testing'

		ArrayList<Kurssi> coursesArray = k.getKurssit();
		int nCourses = coursesArray.size();

		// courses[number of courses][0 course name, 1 credits]
		String[][] courses = new String[nCourses][2];

		// for-each course in Keraaja object field kurssit (now in coursesArray), get name and credits to internal array courses (String[][])
		for (i = 0; i < nCourses; i++) {
			if ((coursesArray.get(i)).getSuoritettu()) {
				courses[i][0] = (coursesArray.get(i)).getNimi();
				int cr = (coursesArray.get(i).getLaajuus());	// cr == credits. Used twice (in following lines)
				courses[i][1] = Integer.toString(cr);	// int has to be converted to String at some point! (can't print otherwise)
				totalcr += cr;	// add credits to total credits (static variable)
			}
		}

		return courses;
	}

	/**
	 *	Prints String[][] courses as html file (file name defined by String coursesfn)
	 *	
	 *	@param courses
	 *	@return true on success, else false
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
			while (i < courses.length) {
				out.write("<TR><TD>" + courses[i][0] + "</TD><TD>" + courses[i][1] + "</TD></TR>\n");
				i++;
			}

			// print total credits
			out.write("<TR><TD></TD><TD>yht. " + totalcr + "</TD></TR>");

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
	 *	
	 *	@return timetable
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
	 *
	 *	@param timetable
	 *	@return boolean
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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		printCourses();
	}

}
