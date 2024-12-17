package com.vn.quanlythuvien.services.interfaces;

import com.vn.quanlythuvien.models.Type;
import com.vn.quanlythuvien.requests.type.TypeRequest;

import java.util.List;

public interface ITypeService {
    List<Type> getAll();
    void createType(TypeRequest request);
    void updateType(int id, TypeRequest request);
    void deleteType(int id);
}
