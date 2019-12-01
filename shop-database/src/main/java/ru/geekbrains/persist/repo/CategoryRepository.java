package ru.geekbrains.persist.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persist.model.Category;

//import ru.geekbrains.controllers.repr.CategoryRepr;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query("select new ru.geekbrains.controllers.repr.CategoryRepr(c.id, c.name, count(p.id)) " +
//            "from Category c " +
//            "left join c.products p " +
//            "group by c.id, c.name")
////    List<CategoryRepr> getAllCategoryRepr();

}
