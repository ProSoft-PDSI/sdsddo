package util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilDate {

	public static final int DOMINGO = 1;
	public static final int LUNES = 2;
	public static final int MARTES = 3;
	public static final int MIERCOLES = 4;
	public static final int JUEVES = 5;
	public static final int VIERNES = 6;
	public static final int SABADO = 7;
	private static final String days[] = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
	private static final String months[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"};

	// Retorna la fecha actual
	public static Date now() {
		return new Date();
	}

	
	public static Date toDate(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		return cal.getTime();
	}

	public static int dayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayWeek;
	}

	public static int dayOfWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
		return dayWeek;
	}

	public static String codDayOfWeek(Date date) {
		int dayWeek = dayOfWeek(date);
		String name = days[dayWeek - 1];
		return name.substring(0, 2);
	}

	public static String codDayOfWeek(int year, int month, int day) {
		int dayWeek = dayOfWeek(year, month, day);
		String name = days[dayWeek - 1];
		return name.substring(0, 2);
	}

	public static String nameDayOfWeek(Date date) {
		int dayWeek = dayOfWeek(date);
		String name = days[dayWeek - 1];
		return name;
	}

	public static String nameDayOfWeek(int year, int month, int day) {
		int dayWeek = dayOfWeek(year, month, day);
		String name = days[dayWeek - 1];
		return name;
	}

	public static int year(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		return year;
	}

	public static int month(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return month + 1;
	}

	public static String nameOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int month = cal.get(Calendar.MONTH);
		return months[month];
	}

	public static String nameOfMonth(int month) {
		String name = "";
		if (month >= 1 && month <= 12) {
			name = months[month - 1];
		}
		return name;
	}

	public static java.sql.Date javaToSQL(Date date) {
		java.sql.Date newDate = new java.sql.Date(date.getTime());
		return newDate;
	}

	public static Date sqlToJava(java.sql.Date date) {
		Date newDate = new Date(date.getTime());
		return newDate;
	}

	public static int daysOfMonth(int year, int month) {
		int days = 0;
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				days = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				days = 30;
				break;
			case 2:
				if (year % 4 == 0) {
					days = 29;
				} else {
					days = 28;
				}
		}
		return days;
	}

	public static Date addDays(Date date, int days) {
		Calendar cal = new GregorianCalendar();
		Date fecha = date;
		cal.setTimeInMillis(fecha.getTime());
		cal.add(Calendar.DATE, days);
		Date newDate = new Date(cal.getTimeInMillis());
		return newDate;
	}

	/**
	 *
	 * @param time: LA hora en formato HH:mm o HH:mm:ss
	 * @return Retorna un dato de tipo Date
	 */
	public static Date timeToDate(String time) {
		Date fecha = null;
		try {
			SimpleDateFormat sdf;
			if (time.length() == 5) {
				sdf = new SimpleDateFormat("HH:mm");
			} else if (time.length() == 8) {
				sdf = new SimpleDateFormat("HH:mm:ss");
			} else {
				throw new RuntimeException("Formato de tiempo incorrecto.");
			}
			fecha = sdf.parse(time);
		} catch (Exception e) {
		}
		return fecha;
	}

	public static String toTime(Date fecha) {
		String time = "00:00";
		if (fecha != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			time = sdf.format(fecha);
		}
		return time;
	}

	public static Long toMinutes(Date fecha) {
		String sFecha = toTime(fecha);
		long horas = Long.parseLong(sFecha.substring(0, 2));
		long minutos = Long.parseLong(sFecha.substring(3));
		minutos = horas * 60 + minutos;
		return minutos;
	}

	public static Date toDate(long segundos) {
		long horas = segundos / 3600;
		segundos = segundos % 3600;
		long minutos = segundos / 60;
		segundos = segundos % 60;
		DecimalFormat df = new DecimalFormat("00");
		String sfecha = df.format(horas) + ":" + df.format(minutos) + ":" + df.format(segundos);
		Date fecha = timeToDate(sfecha);
		return fecha;
	}

	public static Date timeDiff(Date salida, Date llegada) {
		long m1 = toMinutes(salida);
		long m2 = toMinutes(llegada);
		long dif = Math.abs(m2 - m1);
		Date fecha = toDate(dif * 60);
		return fecha;
	}
}
