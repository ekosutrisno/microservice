package com.microservice.authservice.repository;

import com.microservice.authservice.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Eko Sutrisno
 * @email ekosutrisno801@gmail.com
 * @github https://github.com/ekosutrisno
 * @gitlab https://gitlab.com/ekosutrisno1
 * @create 06/09/2020 17:48
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserEntity, Long> {

   Optional<UserEntity> findByUsername(String username);
}
