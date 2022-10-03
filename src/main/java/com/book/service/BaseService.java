package com.book.service;

import com.book.entity.BaseEntity;
import com.book.error.RecordNotFoundException;
import com.book.repo.BaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends Number> {

    @Autowired
    private BaseRepo<T, ID> baseRepo;

    @Autowired
    private MessageSource messageSource;

    public T findById(ID id) {

        Optional<T> entity =   baseRepo.findById(id);
        if (entity.isPresent()) {
           return entity.get();
        } else {
            String[] msgParam = {id.toString()};
            String message = messageSource.getMessage("validation.recordNotFound.message", msgParam, LocaleContextHolder.getLocale());
            throw new RecordNotFoundException(message);
        }
    }

    public T getById(ID id) {

        return baseRepo.getReferenceById(id);
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
