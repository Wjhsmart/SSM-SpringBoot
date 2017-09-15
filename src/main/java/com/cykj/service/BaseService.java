package com.cykj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Wjhsmart on 2017/9/14.
 */
public interface BaseService<T, ID extends Serializable> {

    public T save(T t);

    public T saveAndFlush(T t);

    public List<T> save(Iterable<T> entities);

    public void delete(T t);

    public void delete(ID id);

    public void deleteAll();

    public void deleteAllInBatch();

    public void delete(Iterable<T> entities);

    public void deleteInBatch(Iterable<T> entities);

    public T findOne(ID id);

    public T findOne(Specification<T> spec);

    public List<T> findAll();

    public List<T> findAll(Iterable<ID> ids);

    public List<T> findAll(Sort sort);

    public Page<T> findAll(Pageable pageable);

    public Page<T> findAll(Specification<T> spec, Pageable pageable);

    public List<T> findAll(Specification<T> spec);

    public List<T> findAll(Specification<T> spec, Sort sort);

    public Long count();

    public Long count(Specification<T> spec);

    public boolean exists(ID id);
}
