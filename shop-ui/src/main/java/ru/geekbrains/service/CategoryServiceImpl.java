package ru.geekbrains.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.controllers.repr.CategoryRepr;
import ru.geekbrains.persist.model.Category;
import ru.geekbrains.persist.repo.CategoryRepository;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @Transactional
    public List<CategoryRepr> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryRepr::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CategoryRepr findById(Long id) {
        return new CategoryRepr(categoryRepository.getOne(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void save(CategoryRepr categoryRepr) throws IOException {
        Category category = new Category();
        category.setName(categoryRepr.getName());
        categoryRepr.getProductCount();
    }
}
