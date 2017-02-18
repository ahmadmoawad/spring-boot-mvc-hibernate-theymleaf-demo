package com.moawad.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.moawad.model.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long>{

}
