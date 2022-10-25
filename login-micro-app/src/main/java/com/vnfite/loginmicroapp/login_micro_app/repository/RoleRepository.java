package com.vnfite.loginmicroapp.login_micro_app.repository;

import com.vnfite.loginmicroapp.login_micro_app.models.ERole;
import com.vnfite.loginmicroapp.login_micro_app.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
