package org.bk.trade.types;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@Entity
@Table(name="trades")
public class Trade implements Serializable{
    
    public Trade(){
        //
    }
    
    public Trade(String isdaId, String side, String size, String risk){
        this.isdaId = isdaId;
        this.side = side;
        this.size = size;
        this.risk = risk;
    }
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    
    
    private String isdaId;
    private String side;
    private String size;
    private String risk;


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRisk() {
        return risk;
    }
    public void setRisk(String risk) {
        this.risk = risk;
    }
    public String getIsdaId() {
        return isdaId;
    }
    public void setIsdaId(String isdaId) {
        this.isdaId = isdaId;
    }
    public String getSide() {
        return side;
    }
    public void setSide(String side) {
        this.side = side;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String toString() {
        return "Trade [id=" + id + ", risk=" + risk + ", isdaId=" + isdaId + ", side=" + side
                + ", size=" + size + "]";
    }
    
}
