package com.be.repository;

import com.ecommerce.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Role, Integer> {
}
