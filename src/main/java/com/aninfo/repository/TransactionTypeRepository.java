package com.aninfo.repository;

import com.aninfo.model.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer> {
    @Override
    List<TransactionType> findAll();

}