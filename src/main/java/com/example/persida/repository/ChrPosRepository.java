package com.example.persida.repository;

import com.example.persida.model.ChrPos;
import com.example.persida.model.ChrPosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChrPosRepository extends JpaRepository<ChrPos,ChrPosId> {

}
