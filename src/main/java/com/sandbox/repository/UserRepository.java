package com.sandbox.repository;

import com.sandbox.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mike on 2017/2/21.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

}
