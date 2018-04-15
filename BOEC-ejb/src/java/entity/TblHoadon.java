/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblHoadon.findAll", query = "SELECT t FROM TblHoadon t")
    , @NamedQuery(name = "TblHoadon.findByHoadonId", query = "SELECT t FROM TblHoadon t WHERE t.hoadonId = :hoadonId")
    , @NamedQuery(name = "TblHoadon.findByThoigiangiao", query = "SELECT t FROM TblHoadon t WHERE t.thoigiangiao = :thoigiangiao")})
public class TblHoadon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "HOADON_ID")
    private Integer hoadonId;
    @Column(name = "THOIGIANGIAO")
    @Temporal(TemporalType.DATE)
    private Date thoigiangiao;
    @JoinColumn(name = "NHANVIENGIAOHANG_ID", referencedColumnName = "NHANVIEN_ID")
    @ManyToOne(optional = false)
    private TblNhanvien nhanviengiaohangId;
    @JoinColumn(name = "NHANVIENBANHANG_ID", referencedColumnName = "NHANVIEN_ID")
    @ManyToOne(optional = false)
    private TblNhanvien nhanvienbanhangId;
    @JoinColumn(name = "DONHANG_ID", referencedColumnName = "DONHANG_ID")
    @ManyToOne(optional = false)
    private TblDonhang donhangId;

    public TblHoadon() {
    }

    public TblHoadon(Integer hoadonId) {
        this.hoadonId = hoadonId;
    }

    public Integer getHoadonId() {
        return hoadonId;
    }

    public void setHoadonId(Integer hoadonId) {
        this.hoadonId = hoadonId;
    }

    public Date getThoigiangiao() {
        return thoigiangiao;
    }

    public void setThoigiangiao(Date thoigiangiao) {
        this.thoigiangiao = thoigiangiao;
    }

    public TblNhanvien getNhanviengiaohangId() {
        return nhanviengiaohangId;
    }

    public void setNhanviengiaohangId(TblNhanvien nhanviengiaohangId) {
        this.nhanviengiaohangId = nhanviengiaohangId;
    }

    public TblNhanvien getNhanvienbanhangId() {
        return nhanvienbanhangId;
    }

    public void setNhanvienbanhangId(TblNhanvien nhanvienbanhangId) {
        this.nhanvienbanhangId = nhanvienbanhangId;
    }

    public TblDonhang getDonhangId() {
        return donhangId;
    }

    public void setDonhangId(TblDonhang donhangId) {
        this.donhangId = donhangId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hoadonId != null ? hoadonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHoadon)) {
            return false;
        }
        TblHoadon other = (TblHoadon) object;
        if ((this.hoadonId == null && other.hoadonId != null) || (this.hoadonId != null && !this.hoadonId.equals(other.hoadonId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblHoadon[ hoadonId=" + hoadonId + " ]";
    }
    
}
