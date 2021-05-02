package com.vdab.services;

import com.vdab.domain.Category;
import com.vdab.domain.Products;
import com.vdab.repositories.AddingTODBRepository;

public class AddingToDBService {
    private AddingTODBRepository addingToDatabaseRepository = new AddingTODBRepository();


    public Category getCategoryById(int id) {
        return addingToDatabaseRepository.getCategoryById(id);
    }

    public void addProductToDB(Products product) {
        addingToDatabaseRepository.addProductToDB(product);
    }
}

