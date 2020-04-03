package com.example.demo.repo;

import com.example.demo.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StorageRepo extends JpaRepository<Storage, Serializable> {
}
