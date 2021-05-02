package com.vdab.services;

import com.vdab.repositories.DeletingFromDBRepository;

public class DeletingFromDBService {


        private DeletingFromDBRepository deletingFromDBRepository = new DeletingFromDBRepository();

        public void deleteProductById(int id) {
            deletingFromDBRepository.deleteProductById(id);
        }
    }

