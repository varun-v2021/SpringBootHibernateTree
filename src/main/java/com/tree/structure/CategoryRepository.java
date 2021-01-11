/**
 * @author Varun
 *
 */
package com.tree.structure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Varun
 *
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
