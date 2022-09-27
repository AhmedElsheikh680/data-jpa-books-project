package com.book.repo;

import com.book.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@NoRepositoryBean
public interface BaseRepo<T extends BaseEntity<ID>, ID extends Number> extends JpaRepository<T, ID> {

    @Transactional
    @Modifying
    @Query("update #{#entityName} t SET t.statusCode= :statusCode where t.id= :id")
    void updateEntity(@Param("id")ID id, @Param("statusCode") String statusCode);
}
