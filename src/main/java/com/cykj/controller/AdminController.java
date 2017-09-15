package com.cykj.controller;

import com.cykj.bean.Admin;
import com.cykj.enums.AdminStatusEnum;
import com.cykj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Wjhsmart on 2017/9/14.
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("save")
    public Admin save() {
        Admin admin = new Admin();
        admin.setName("admin");
        admin.setPassword("admin");
        admin.setCreateTime(new Date());
        admin.setUpdateTime(new Date());
        admin.setStatus(AdminStatusEnum.NORMAL.getCode());
        admin = adminService.save(admin);
        return admin;
    }

    @RequestMapping("findOne/{id}")
    public Admin findOne(@PathVariable("id") Integer id) {
        Admin admin = adminService.findOne(id);
        return admin;
    }

    @RequestMapping("all")
    public List<Admin> findAll() {
        List<Admin> adminList = adminService.findAll();
        return adminList;
    }

    @RequestMapping("update/{id}")
    public Admin updateById(@PathVariable("id") Integer id) {
        Admin admin = adminService.findOne(id);
        admin.setStatus(AdminStatusEnum.DISABLE.getCode());
        admin.setName("危锦辉");
        admin.setUpdateTime(new Date());
        admin = adminService.save(admin);
        return admin;
    }

    @RequestMapping("delete/{id}")
    public String deleteById(@PathVariable("id") Integer id) {
        adminService.delete(id);
        return "删除成功";
    }

    @RequestMapping("sort/{direction}")
    public List<Admin> sort(@PathVariable("direction") String direction) {
        Sort sort = null;
        if (direction.equals("asc")) {
            sort = new Sort(Sort.Direction.DESC, "updateTime");
        } else if (direction.equals("desc")) {
            sort = new Sort(Sort.Direction.ASC, "updateTime");
        }
        if (sort == null) {
            return null;
        }
        List<Admin> adminList = adminService.findAll(sort);
        return adminList;
    }

    @RequestMapping("page")
    public Page<Admin> page(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNumber-1, pageSize);
        Page<Admin> page = adminService.findAll(pageable);
        return page;
    }

    @RequestMapping("pageCondition")
    public Page<Admin> pageCondition(Integer pageNumber, Integer pageSize) {
        Pageable pageable = new PageRequest(pageNumber-1, pageSize);
        Page<Admin> page = adminService.findAll(new Specification<Admin>() {
            @Override
            public Predicate toPredicate(Root<Admin> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<String> namePath = root.get("name");
                Path<String> passwordPath = root.get("password");
                query.where(cb.like(namePath, "%危%"), cb.like(passwordPath, "%123%"));
                return cb.conjunction();
            }
        }, pageable);
        return page;
    }
}
