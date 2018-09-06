package com.example.persida.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class GenId implements Serializable{

    public String chr;

    public Long beg;

    public GenId(){
    }

    public GenId(String chr, Long beg) {
        this.chr = chr;
        this.beg = beg;
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
        if (!(o instanceof GenId)) return false;

        GenId genId = (GenId) o;

        if (!getChr().equals(genId.getChr())) return false;
        return getBeg().equals(genId.getBeg());
    }

    @Override
    public int hashCode() {
        int result = getChr().hashCode();
        result = 31 * result + getBeg().hashCode();
        return result;
    }
}
