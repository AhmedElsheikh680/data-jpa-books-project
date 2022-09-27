package com.book.service;

import com.book.entity.BaseEntity;
import com.book.entity.Book;
import com.book.repo.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends Number> {

    @Autowired
    private BaseRepo<T, ID> baseRepo;

    public T findById(ID id) {
        return baseRepo.findById(id).orElseThrow();
    }

    public List<T> findAll() {
        return baseRepo.findAll();
    }

    public T save(T t) {
        if (t.getId() != null) {
            throw  new RuntimeException();
        }
        return baseRepo.save(t);

    }

    public List<T> saveAll(List<T> t) {
        return baseRepo.saveAll(t);
    }

    public T update(T t) {

        return baseRepo.save(t);
    }

    public void delete(ID id) {
        baseRepo.deleteById(id);
    }

//    public int deleteByAuthorId(ID id) {
//        return baseRepo.deletebyAuthorId(id);
//    }


}
