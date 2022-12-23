package com.tool.smarthrbackend.repository.jpa.domain;


import com.tool.smarthrbackend.model.domain.Domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainRepository extends CrudRepository<Domain, Long> {
    Optional<Domain> findById(Long id);

    @Override
    List<Domain> findAll();

    @Query("select d FROM Domain d WHERE d.parentId = (select p.id from Domain p where p.domainName = ?1) order by d.id desc")
    List<Domain> findChildDomainsByDomainName(String domainName);

    @Query("select d FROM Domain d WHERE d.parentId = (select p.id from Domain p where p.domainName = ?1) order by d.id desc")
    Page<Domain> findChildDomainsByDomainName(String domainName,Pageable pageable);

    Domain findByDomainName(String domainName);

}