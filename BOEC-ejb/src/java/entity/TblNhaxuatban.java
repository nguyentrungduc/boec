/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_nhaxuatban")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNhaxuatban.findAll", query = "SELECT t FROM TblNhaxuatban t")
    , @NamedQuery(name = "TblNhaxuatban.findByNhaxuatbanId", query = "SELECT t FROM TblNhaxuatban t WHERE t.nhaxuatbanId = :nhaxuatbanId")
    , @NamedQuery(name = "TblNhaxuatban.findByTennhaxuatban", query = "SELECT t FROM TblNhaxuatban t WHERE t.tennhaxuatban = :tennhaxuatban")
    , @NamedQuery(name = "TblNhaxuatban.findByDiachi", query = "SELECT t FROM TblNhaxuatban t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblNhaxuatban.findByMota", query = "SELECT t FROM TblNhaxuatban t WHERE t.mota = :mota")})
public class TblNhaxuatban implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NHAXUATBAN_ID")
    private Integer nhaxuatbanId;
    @Size(max = 100)
    @Column(name = "TENNHAXUATBAN")
    private String tennhaxuatban;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 100)
    @Column(name = "MOTA")
    private String mota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nhaxuatbanId")
    private Collection<TblSach> tblSachCollection;

    public TblNhaxuatban() {
    }

    public TblNhaxuatban(Integer nhaxuatbanId) {
        this.nhaxuatbanId = nhaxuatbanId;
    }

    public Integer getNhaxuatbanId() {
        return nhaxuatbanId;
    }

    public void setNhaxuatbanId(Integer nhaxuatbanId) {
        this.nhaxuatbanId = nhaxuatbanId;
    }

    public String getTennhaxuatban() {
        return tennhaxuatban;
    }

    public void setTennhaxuatban(String tennhaxuatban) {
        this.tennhaxuatban = tennhaxuatban;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Collection<TblSach> getTblSachCollection() {
        return tblSachCollection;
    }

    public void setTblSachCollection(Collection<TblSach> tblSachCollection) {
        this.tblSachCollection = tblSachCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nhaxuatbanId != null ? nhaxuatbanId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNhaxuatban)) {
            return false;
        }
        TblNhaxuatban other = (TblNhaxuatban) object;
        if ((this.nhaxuatbanId == null && other.nhaxuatbanId != null) || (this.nhaxuatbanId != null && !this.nhaxuatbanId.equals(other.nhaxuatbanId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblNhaxuatban[ nhaxuatbanId=" + nhaxuatbanId + " ]";
    }
    
}
