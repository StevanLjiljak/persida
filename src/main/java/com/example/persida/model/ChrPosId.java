package com.example.persida.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChrPosId implements Serializable{

    private String chr;

    private Long pos;

    public ChrPosId(){
    }

    public ChrPosId(String chr, Long pos){
        this.chr = chr;
        this.pos = pos;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Long getPos() {
        return pos;
    }

    public void setPos(Long pos) {
        this.pos = pos;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(!(obj instanceof ChrPosId)) return false;
        ChrPosId chrPosId = (ChrPosId) obj;

        return Objects.equals(getChr(), chrPosId.getChr()) &&
               Objects.equals(getPos(), chrPosId.getPos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChr(), getPos());
    }
}
