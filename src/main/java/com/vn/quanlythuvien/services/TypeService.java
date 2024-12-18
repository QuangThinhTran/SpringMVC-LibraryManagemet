package com.vn.quanlythuvien.services;

import com.vn.quanlythuvien.models.Type;
import com.vn.quanlythuvien.repositories.TypeRepository;
import com.vn.quanlythuvien.requests.type.TypeRequest;
import com.vn.quanlythuvien.services.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public void createType(TypeRequest request) {
        setUpType(new Type(), request.getName());
    }

    @Override
    public void updateType(int id, TypeRequest request) {
        Type type = typeRepository.findById(id).orElse(null);
        setUpType(type, request.getName());
    }

    @Override
    public void deleteType(int id) {
        Type type = typeRepository.findById(id);
        typeRepository.delete(type);
    }

    private void setUpType(Type type, String name) {
        type.setName(name);
        typeRepository.save(type);
    }
}
