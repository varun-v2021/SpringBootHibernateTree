package com.tree.structure;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringHibernateTreeApplicationTests {

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	void contextLoads() {

		String[] electronicsCategoryNames = { "Electronics", "Home Audio", "Karaoke", "TV" };
		String[] gamingCategoryNames = { "Gaming", "Console", "Sony", "LG" };

		Category karaoke = createCategories(electronicsCategoryNames);
		Category sony = createCategories(gamingCategoryNames);
	}

	Category createCategories(String[] categoryNames) {
		Category parent = null;

		for (String categoryName : categoryNames) {
			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setParent(parent);
			//save will return id of the saved entity
			parent = categoryRepository.save(category);
		}

		Assert.assertNotNull("category.id", parent.getId());
		return parent;
	}

}
