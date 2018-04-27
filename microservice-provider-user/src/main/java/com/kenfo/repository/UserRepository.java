package com.kenfo.repository;

import com.kenfo.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kenfo
 * @version V1.0
 * @Package com.kenfo
 * @Description: TODO
 * @date 2018/4/26 下午9:55
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
