package com.example.persida.repository;

import com.example.persida.model.ChrPos;
import com.example.persida.model.ChrPosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChrPosRepository extends JpaRepository<ChrPos,ChrPosId> {

    public ChrPos findByChrPosId(ChrPosId chrPosId);

    public List<ChrPos> findByChrPosIdChr(String chr);

    @Query("from chrpos where chrPosId.pos between :pos1 and :pos2")
    public List<ChrPos> getBetweenPos(@Param("pos1") Long pos1, @Param("pos2") Long pos2);

    @Query("from chrpos")
    public List<ChrPos> getDeletion();

}
