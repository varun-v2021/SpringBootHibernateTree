/**
 * @author Varun
 *
 */
package com.tree.structure;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Varun
 *
 */
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
}
