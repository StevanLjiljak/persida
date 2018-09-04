package com.example.persida.repository;

import com.example.persida.model.ChrPos;
import com.example.persida.model.ChrPosId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChrPosRepository extends JpaRepository<ChrPos, ChrPosId> {

    public ChrPos findByChrPosId(ChrPosId chrPosId);

    public List<ChrPos> findByChrPosIdChr(String chr);

    @Query("from chrpos where chrPosId.pos between :pos1 and :pos2")
    public List<ChrPos> getBetweenPos(@Param("pos1") Long pos1, @Param("pos2") Long pos2);

    /*
        SELECT *
        FROM persida.chrpos cp1
        WHERE cp1.ref IN (
		    SELECT cp2.ref
		    FROM persida.chrpos cp2
		    GROUP BY cp2.ref
		    HAVING COUNT(cp2.ref) > 1
        ) GROUP BY cp1.alt
        HAVING COUNT(cp1.alt) = 1;
    */

    @Query("from chrpos cp1 " +
            "where cp1.ref IN ( " +
            "select cp2.ref from chrpos cp2 " +
            "group by cp2.ref " +
            "having count(cp2.ref) > 1 " +
            ") group by cp1.alt " +
            " having count(cp1.alt) = 1")
    public List<ChrPos> getDeletion();

}
