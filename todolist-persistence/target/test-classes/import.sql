-- CategoryDaoTest
-- testFindCategory
-- ID = 1L
INSERT INTO category(name) VALUES('testFindCategoryNameDB');
-- testUpdateCategoryHasNameChanged
-- ID = 2L
INSERT INTO category(name) VALUES('testUpdateCategoryChangedNameDB');
-- testUpdateCategoryHasRightName
-- ID = 3L
INSERT INTO category(name) VALUES('testUpdateCategoryRightNameDB');

-- TaskDaoTest
-- testFindableByLabel
-- ID_TASK = 1L
INSERT INTO task(label) VALUES('testFindableLabelDB');
-- testListTasksForGivenUserAndCategory
-- ID_USER = 1L
INSERT INTO users(name, USER_TYPE) VALUES('testUserDB', 'USER_FREE');
-- ID_CATEGORY = 4L
INSERT INTO category(name) VALUES('testCategoryDB');
-- ID_TASK = 2L
INSERT INTO task(label, id_user, id_category) VALUES('testListByUserAndCategoryDB', 1, 4);

INSERT INTO task(label, begining_date, ending_date) VALUES('task1', '2017,01,12', '2017,01,22');

INSERT INTO task(label, begining_date, ending_date) VALUES('task2', '2017,01,12', '2017,01,25');