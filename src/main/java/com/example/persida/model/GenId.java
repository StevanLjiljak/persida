package com.example.persida.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GenId implements Serializable {

    private String chr;
    private Long beg;

    public GenId(){

    }
    public GenId(String chr, Long beg){
        this.chr=chr;
        this.beg=beg;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Long getBeg() {
        return beg;
    }

    public void setBeg(Long beg) {
        this.beg = beg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenId genId = (GenId) o;
        return Objects.equals(chr, genId.chr) &&
                Objects.equals(beg, genId.beg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chr, beg);
    }
}
