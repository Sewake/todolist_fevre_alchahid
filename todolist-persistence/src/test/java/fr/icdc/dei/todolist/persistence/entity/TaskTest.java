package fr.icdc.dei.todolist.persistence.entity;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import fr.icdc.dei.todolist.persistence.entity.Task;

public class TaskTest {

	private static final int ENDING_AND_BEGINNING_MONTH_DATE = 0;
	private static final int ENDING_AND_BEGINNING_YEAR_DATE = 2017;
	private static final String EMPTY_STRING = "";
	private static final String TASK_LABEL = "label";
	private static Calendar calendar = GregorianCalendar.getInstance();
	
	private static final Task task = new Task();
	
	@BeforeClass
	public static void setUp() {
		task.setLabel(TASK_LABEL);
	}

	@Test
	public void testTaskHasLabel() {
		assertNotNull(task.getLabel());
	}
	
	@Test
	public void testTaskIsEmpty() {
		task.setLabel(EMPTY_STRING);
		assertTrue(EMPTY_STRING.equals(task.getLabel()));
	}
	
	@Test
	public void testTaskIsNotEmpty() {
		assertFalse(EMPTY_STRING.equals(task.getLabel()));
	}
	
	@Test
	public void testTaskHasBeginningDate() {
		task.setBeginningDate(new Date());
		assertNotNull(task.getBeginninDate());
	}
	
	@Test
	public void testTaskHasEndingDate(){
		task.setEndingDate(new Date());
		assertNotNull(task.getEndingDate());
	}
	
	@Test
	public void testTaskHasValidDuration(){
		calendar.set(ENDING_AND_BEGINNING_YEAR_DATE, ENDING_AND_BEGINNING_MONTH_DATE, 1);
		task.setBeginningDate(calendar.getTime());
		calendar.set(ENDING_AND_BEGINNING_YEAR_DATE, ENDING_AND_BEGINNING_MONTH_DATE,5);
		task.setEndingDate(calendar.getTime());
		assertTrue(task.getEndingDate().compareTo(task.getBeginninDate()) > 0);
	}
	
	//Cr�ation test
	@Test
	public void testTaskIsOver(){
		task.setOver();
		assertTrue(task.isOver());
	}
	
//	@Test
//	public void testTaskEndingDateInInterval(){
//		Date debut = parseDate("2014-01-01");
//		Date fin = parseDate("2014-01-30");
//		Date test = parseDate("2014-01-15");
//		task.setEndingDate(test);
//		assertTrue(task.endingDateInInterval(debut,fin));
//	}
//	
	
//	@Test
//	public void testTaskNoEndingDate(){
//		assertTrue(task.noEndingDate());
//	}
	
//
//	private Date parseDate(String date) {
//		try {
//	         return new SimpleDateFormat("yyyy-MM-dd").parse(date);
//	     } catch (ParseException e) {
//	         return null;
//	     }
//	}

}
