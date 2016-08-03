package com.acesse.vcashadmin.db.repository;

import com.acesse.vcashadmin.db.entity.DboaspnetUsers;
import org.springframework.data.repository.CrudRepository;


public interface UsersRepository extends CrudRepository<DboaspnetUsers, String> {
    DboaspnetUsers findByUserName(String userName);
}
