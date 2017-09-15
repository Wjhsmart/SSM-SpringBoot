package com.cykj.service.impl;

import com.cykj.repository.BaseRepository;
import com.cykj.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Wjhsmart on 2017/9/14.
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    @Autowired
    protected BaseRepository<T, ID> baseRepository;
    protected  Class<T> entityClass;

    public BaseServiceImpl() {
        Class clazz = getClass();
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
    }

    @Override
    @Transactional
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    @Transactional
    public T saveAndFlush(T t) {
        return baseRepository.save(t);
    }

    @Override
    @Transactional
    public List<T> save(Iterable<T> entities) {
        return baseRepository.save(entities);
    }

    @Override
    @Transactional
    public void delete(T t) {
        baseRepository.delete(t);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        baseRepository.delete(id);
    }

    @Override
    @Transactional
    public void deleteAll() {
        baseRepository.deleteAll();
    }

    @Override
    @Transactional
    public void deleteAllInBatch() {
        baseRepository.deleteAllInBatch();
    }

    @Override
    @Transactional
    public void delete(Iterable<T> entities) {
        baseRepository.delete(entities);
    }

    @Override
    @Transactional
    public void deleteInBatch(Iterable<T> entities) {
        baseRepository.deleteInBatch(entities);
    }

    @Override
    public T findOne(ID id) {
        return baseRepository.findOne(id);
    }

    @Override
    public T findOne(Specification<T> spec) {
        return baseRepository.findOne(spec);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public List<T> findAll(Iterable<ID> ids) {
        return baseRepository.findAll(ids);
    }

    @Override
    public List<T> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public Page<T> findAll(Specification<T> spec, Pageable pageable) {
        return baseRepository.findAll(spec, pageable);
    }

    @Override
    public List<T> findAll(Specification<T> spec) {
        return baseRepository.findAll(spec);
    }

    @Override
    public List<T> findAll(Specification<T> spec, Sort sort) {
        return baseRepository.findAll(spec, sort);
    }

    @Override
    public Long count() {
        return baseRepository.count();
    }

    @Override
    public Long count(Specification<T> spec) {
        return baseRepository.count(spec);
    }

    @Override
    public boolean exists(ID id) {
        return baseRepository.exists(id);
    }
}
