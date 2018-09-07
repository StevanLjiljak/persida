package com.example.persida.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "gen")
@Table(name = "gen")
public class Gen {

    @EmbeddedId
    public GenId genId;

    public Long end;
    public String gene;

    public Gen(){

    }
    public Gen(GenId genId, Long end, String gene){

        this.genId=genId;
        this.end=end;
        this.gene=gene;
    }

    public GenId getGenId() {
        return genId;
    }

    public void setGenId(GenId genId) {
        this.genId = genId;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }
}
