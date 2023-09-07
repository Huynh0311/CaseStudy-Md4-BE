package com.be.repository;

import com.ecommerce.model.Shop;
import org.springframework.data.repository.CrudRepository;

public interface IShopRepo extends CrudRepository<Shop, Integer> {
}
