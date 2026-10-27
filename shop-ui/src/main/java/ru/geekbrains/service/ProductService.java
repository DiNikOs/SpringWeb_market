package ru.geekbrains.service;

import ru.geekbrains.controllers.repr.ProductRepr;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductRepr> findAll();

//    ProductRepr findById(Long id);

    Optional<ProductRepr> findById(Long id);

    void deleteById(Long id);

    List<List<ProductRepr>> findAllAndSplitProductsBy(int groupSize);

    void save(ProductRepr product) throws IOException;
}
