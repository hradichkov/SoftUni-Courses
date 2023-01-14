package com.example.jsonexercise.services;

import com.example.jsonexercise.domain.dtos.categories.CategoryProductSummaryDto;
import com.example.jsonexercise.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.jsonexercise.constants.Paths.CATEGORIES_BY_PRODUCTS_JSON_PATH;
import static com.example.jsonexercise.constants.Utils.writeJsonIntoFile;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryProductSummaryDto> getCategorySummary() throws IOException {
        List<CategoryProductSummaryDto> categoryProductSummaryDtos = this.categoryRepository.getCategorySummary()
                .orElseThrow(NoSuchElementException::new);

        writeJsonIntoFile(categoryProductSummaryDtos, CATEGORIES_BY_PRODUCTS_JSON_PATH);

        return categoryProductSummaryDtos;
    }
}
