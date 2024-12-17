package com.vn.quanlythuvien.repositories;

import com.vn.quanlythuvien.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
    Type getTypeById(int id);
    Type getTypeByName(String name);
    List<Type> findAll();
}
