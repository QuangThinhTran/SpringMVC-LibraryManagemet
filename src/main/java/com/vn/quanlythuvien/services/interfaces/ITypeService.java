package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getAll();
    void createType(TypeRequest request);
    void updateType(int id, TypeRequest request);
    Type deleteType(int id);
}
