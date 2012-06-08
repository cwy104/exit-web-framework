package org.vcs.project.test.manager.foundation;

import static org.junit.Assert.*;

import java.util.List;

import org.exitsoft.project.vcsadmin.entity.foundation.DictionaryCategory;
import org.exitsoft.project.vcsadmin.service.foundation.SystemDictionaryManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.vcs.project.test.manager.ManagerTestCaseSuper;

/**
 * 测试字典类别管理所有方法
 * 
 * @author vincent
 *
 */
public class TestDictionaryCategoryManager extends ManagerTestCaseSuper {

	@Autowired
	private SystemDictionaryManager systemDictionaryManager;
	
	@Test
	public void testSaveDictionaryCategory() {
		DictionaryCategory category = new DictionaryCategory();
		category.setCode("test");
		category.setName("测试");
		category.setRemark("*");
		
		int beforeRow = countRowsInTable("TB_DICTIONARY_CATEGORY");
		systemDictionaryManager.saveDictionaryCategory(category);
		sessionFactory.getCurrentSession().flush();
		int afterRow = countRowsInTable("TB_DICTIONARY_CATEGORY");
		
		assertEquals(afterRow, beforeRow + 1);
	}

	@Test
	public void testDeleteDictionaryCategory() {
		
		int beforeRow = countRowsInTable("TB_DICTIONARY_CATEGORY");
		systemDictionaryManager.deleteDictionaryCategory("SJDK3849CKMS3849DJCK2039ZMSK0015");
		sessionFactory.getCurrentSession().flush();
		int afterRow = countRowsInTable("TB_DICTIONARY_CATEGORY");
		
		assertEquals(beforeRow, afterRow + 1);
	}

	@Test
	public void testGetAllParentDictionaryCategories() {
		List<DictionaryCategory> result = systemDictionaryManager.getAllParentDictionaryCategories();
		assertEquals(3, result.size());
	}

	@Test
	public void testGetAllDictionaryCategories() {
		List<DictionaryCategory> result = systemDictionaryManager.getAllDictionaryCategories();
		assertEquals(4, result.size());
	}

}