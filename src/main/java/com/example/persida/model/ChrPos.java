package com.example.persida.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "chrpos")
@Table(name = "chrpos")
public class ChrPos implements Serializable{

    @EmbeddedId
    public ChrPosId chrPosId;

    public String id;

    public String ref;

    public String alt;

    public ChrPos(){
    }

    public ChrPos( ChrPosId chrPosId, String id, String ref, String alt){
        this.chrPosId = chrPosId;
        this.id = id;
        this.ref = ref;
        this.alt = alt;
    }

    public ChrPosId getChrPosId() {
        return chrPosId;
    }

    public void setChrPosId(ChrPosId chrPosId) {
        this.chrPosId = chrPosId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
