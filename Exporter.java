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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;


public class Exporter {

	private static File file;
	private static PrintWriter out;

	// file names of exportable courses and timetable html files
	private static String coursesfn = "kurssit.html";
	private static String timetablefn = "lukkari.html";

	// total credits for printing courses ...
	private static int totalcr = 0;


	// below: a number of timetable variables -->

	// weekday names' abbreviations
	private static String[] weekdays = {"Ma", "Ti", "Ke", "To", "Pe", "La", "Su"};

	// number of days to print in timetable (defaults to 5, but changing this value will allow implementation of mon-d timetables, where d is mon, tue, ..., or sun)
	private static int nDays = 5;

	// 1st and last hour to print in timetable (minimum). importCourses changes these if events are later or before
	private static int firsthr = 12;
	private static int lasthr = 15;

	// --> end timetable variables

	// multi-function int variable
	private static int i;

	/**
	 *	Fetches names and credits of courses from parameter tiedot (Keraaja
	 *	object), parses its kurssit field into a String[][], and returns it
	 *
	 *	Note: This functions functionality might as well be in exportCourses()
	 *	(and then exportCourses could be renamed to printCourses())!
	 */
	private static String[][] importCourses(Keraaja tiedot) {

		ArrayList<Kurssi> coursesArray = tiedot.getKurssit();
		int nCourses = coursesArray.size();

		// courses[number of courses][0 course name, 1 credits]
		String[][] courses = new String[nCourses][2];
		totalcr = 0;

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
	 *	Imports events from Keraaja object 'tiedot' (given as parameter)
	 *	
	 *	@return timetable
	 */
	private static String[][] importTimetable(Keraaja tiedot) {
		String[][] timetable = new String[24][7]; // timetable[hours][days] (maximum values)
		ArrayList<Tapahtuma> eventsArray = tiedot.getTapahtumat();

		for (Tapahtuma event : eventsArray) {
			if (event.getToistuva()) {	// only weekly events

				// for getting int values (hours and day) from Date objects in Tapahtuma object
				GregorianCalendar time = new GregorianCalendar();

				// convert Date to Calendar (intuitively pointless, but Java API orders to do so)
				time.setTime(event.getAlku());
				int start = time.get(Calendar.HOUR_OF_DAY);
				if (start < firsthr) { firsthr = start; }

				// again, convert Date to Calendar
				time.setTime(event.getLoppu());
				int end = time.get(Calendar.HOUR_OF_DAY);
				if (end > lasthr) { lasthr = end; }

				// assuming that event starts and ends on same day
				int day = time.get(Calendar.DAY_OF_WEEK);

				// a trick to move Monday to 0
				day -= 4;
				if (day < 0) { day += 7; }

				// loop through hours and alter values of timetable
				for (i = start-1; i < end-1; i++) {
					timetable[i][day] = event.getKuuluuKurssiinNimelta() + " (" + event.getNimi() + ") " + event.getSijainti();
				}
			}
		}

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
			out.write("<HTML>\n<HEAD>\n<TITLE>Lukujärjestys</TITLE>\n</HEAD>\n\n<BODY>\n\n");

			// begin table
			out.write("\n<TABLE BORDER=0 CELLSPACING=10>\n\n");

			// print weekdays (titles)
			out.write("<TR>\n<TD></TD>\n");
			i = 0;
			while (i < nDays) {
				out.write("<TD WIDTH=200><B>" + weekdays[i] + "</B></TD>\n");
				i++;
			}
			out.write("</TR>\n\n");

			// print hours and events
			int j = firsthr-1;
			while (j < lasthr-1) {
				// print hour
				out.write("<TR>\n<TD ALIGN=RIGHT HEIGHT=50><B>" + (j+1) + "</B></TD>\n");

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
	 *	
	 *	@param tiedot
	 */
	public static void printCourses(Keraaja tiedot) {
		if (exportCourses(importCourses(tiedot))) {
			System.out.println("Luotiin " + coursesfn);
		}
	}

	/**
	 *	Function imports and prints timetable. Call this.
	 *
	 *	@param tiedot
	 */
	public static void printTimetable(Keraaja tiedot) {
		if (exportTimetable(importTimetable(tiedot))) {
			System.out.println("Luotiin " + timetablefn);
		}
	}



	/**
	 * main and all values in it are for testing purposes only!
	 *
	 * @param args
	 */
/*
	public static void main(String[] args) {
		Keraaja test = new Keraaja();

		Tapahtuma a = new Tapahtuma("Hei");
		Tapahtuma b = new Tapahtuma("Harjoitukset");
		Tapahtuma c = new Tapahtuma("Luento");

		a.setToistuva(true); b.setToistuva(true); c.setToistuva(true);

		a.setKuuluuKurssiinNimelta("Sulkistreenit");
		b.setKuuluuKurssiinNimelta("Moi-kurssi");
		c.setKuuluuKurssiinNimelta("Programming in Foo");

		a.setAlku(new Date((new GregorianCalendar(2010, 4, 12, 12, 0)).getTimeInMillis()));	// Monday
		a.setLoppu(new Date((new GregorianCalendar(2010, 4, 12, 14, 0)).getTimeInMillis()));

		b.setAlku(new Date((new GregorianCalendar(2010, 4, 13, 14, 0)).getTimeInMillis()));	// Tuesday
		b.setLoppu(new Date((new GregorianCalendar(2010, 4, 13, 16, 0)).getTimeInMillis()));

		c.setAlku(new Date((new GregorianCalendar(2010, 4, 16, 10, 0)).getTimeInMillis()));	// Friday
		c.setLoppu(new Date((new GregorianCalendar(2010, 4, 16, 12, 0)).getTimeInMillis()));

		a.setSijainti("Palloiluhalli p");
		b.setSijainti("A111");
		c.setSijainti("B123");

		test.addTapahtuma(a);
		test.addTapahtuma(b);
		test.addTapahtuma(c);

		printTimetable(test);
	}
*/

}
