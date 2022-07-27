package com.tool.smarthrbackend.repository.jpa.metadata;


import com.tool.smarthrbackend.model.metadata.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findById(Long id);

    @Override
    List<Role> findAll();
}