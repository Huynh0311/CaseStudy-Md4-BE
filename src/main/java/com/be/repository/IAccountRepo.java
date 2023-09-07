package com.be.repository;

import com.ecommerce.model.Account;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IAccountRepo extends PagingAndSortingRepository<Account, Integer> {
}
