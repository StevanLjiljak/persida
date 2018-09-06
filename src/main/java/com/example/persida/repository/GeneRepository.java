package com.example.persida.repository;

import com.example.persida.model.Gen;
import com.example.persida.model.GenId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneRepository extends JpaRepository<Gen, GenId> {

}
