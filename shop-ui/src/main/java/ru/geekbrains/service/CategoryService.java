package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.CategoryRepr;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<CategoryRepr> findAll();

    CategoryRepr findById(Long id);

    void deleteById(Long id);

    void save(CategoryRepr category) throws IOException;
}

