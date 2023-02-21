package com.PGS.User.repository;

import com.PGS.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<User,Long> {

    User findByUserId(Long userId);
}
