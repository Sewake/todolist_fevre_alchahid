package fr.icdc.dei.todolist.persistence.dao;

import static org.junit.Assert.*;
import java.sql.Date;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import fr.icdc.dei.todolist.persistence.entity.Task;

public class TaskDaoTest extends AbstractDaoTest {

	private static final long FOURTH_CATEGORY_DB = 4L;
	private static final long FIRST_USER_DB = 1L;
	private static final String TEST_FINDABLE_LABEL_DB = "testFindableLabelDB";

	@Autowired
	private TaskDao taskDao;
	taskDao.setBeginningDate(start);
	taskDao.setEndingDate(end);
	private final static Task task = new Task();
	private static final Date start = new Date(2017,01,01);
	private static final Date end = new Date(2017,01,30);

	@Test
	public void testCreateTask() {
		task.setLabel("");
		assertNotNull(taskDao.save(task));
	}
	
	@Test
	public void testTaskIsFindableByLabel() {
		assertNotNull(taskDao.findByLabel(TEST_FINDABLE_LABEL_DB));
	}
	
	@Test
	public void testListTasksForGivenUserAndCategory() {
		assertTrue(CollectionUtils.isNotEmpty(taskDao.findAllByUserIdAndCategoryId(FIRST_USER_DB, FOURTH_CATEGORY_DB)));
	}
	
	//////////////////////////////////////////////////////////////////////
	
	@Test
	public void testListTasksEndingDateBetweenInterval(){
		assertTrue(CollectionUtils.isNotEmpty(taskDao.findAllByEndingDateBetweenInterval(start, end)));
	}
	
//	@Test
//	public void testListTasksIsOver() {
//		
//	}
	
	
	
}
