/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "tbl_donhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDonhang.findAll", query = "SELECT t FROM TblDonhang t")
    , @NamedQuery(name = "TblDonhang.findByDonhangId", query = "SELECT t FROM TblDonhang t WHERE t.donhangId = :donhangId")
    , @NamedQuery(name = "TblDonhang.findByDiachi", query = "SELECT t FROM TblDonhang t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblDonhang.findByThoigiandat", query = "SELECT t FROM TblDonhang t WHERE t.thoigiandat = :thoigiandat")
    , @NamedQuery(name = "TblDonhang.findByTrangthai", query = "SELECT t FROM TblDonhang t WHERE t.trangthai = :trangthai")
    , @NamedQuery(name = "TblDonhang.findByKieuthanhtoan", query = "SELECT t FROM TblDonhang t WHERE t.kieuthanhtoan = :kieuthanhtoan")})
public class TblDonhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DONHANG_ID")
    private Integer donhangId;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Column(name = "THOIGIANDAT")
    @Temporal(TemporalType.DATE)
    private Date thoigiandat;
    @Column(name = "TRANGTHAI")
    private Integer trangthai;
    @Column(name = "KIEUTHANHTOAN")
    private Integer kieuthanhtoan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "donhangId")
    private Collection<TblHoadon> tblHoadonCollection;
    @JoinColumn(name = "GIOHANG_ID", referencedColumnName = "GIOHANG_ID")
    @ManyToOne(optional = false)
    private TblGiohang giohangId;
    @JoinColumn(name = "NGUOICAPNHAT_ID", referencedColumnName = "NHANVIEN_ID")
    @ManyToOne(optional = false)
    private TblNhanvien nguoicapnhatId;
    @JoinColumn(name = "KHACHHANG_ID", referencedColumnName = "KHACHHANG_ID")
    @ManyToOne(optional = false)
    private TblKhachhang khachhangId;

    public TblDonhang() {
    }

    public TblDonhang(Integer donhangId) {
        this.donhangId = donhangId;
    }

    public Integer getDonhangId() {
        return donhangId;
    }

    public void setDonhangId(Integer donhangId) {
        this.donhangId = donhangId;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Date getThoigiandat() {
        return thoigiandat;
    }

    public void setThoigiandat(Date thoigiandat) {
        this.thoigiandat = thoigiandat;
    }

    public Integer getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(Integer trangthai) {
        this.trangthai = trangthai;
    }

    public Integer getKieuthanhtoan() {
        return kieuthanhtoan;
    }

    public void setKieuthanhtoan(Integer kieuthanhtoan) {
        this.kieuthanhtoan = kieuthanhtoan;
    }

    @XmlTransient
    public Collection<TblHoadon> getTblHoadonCollection() {
        return tblHoadonCollection;
    }

    public void setTblHoadonCollection(Collection<TblHoadon> tblHoadonCollection) {
        this.tblHoadonCollection = tblHoadonCollection;
    }

    public TblGiohang getGiohangId() {
        return giohangId;
    }

    public void setGiohangId(TblGiohang giohangId) {
        this.giohangId = giohangId;
    }

    public TblNhanvien getNguoicapnhatId() {
        return nguoicapnhatId;
    }

    public void setNguoicapnhatId(TblNhanvien nguoicapnhatId) {
        this.nguoicapnhatId = nguoicapnhatId;
    }

    public TblKhachhang getKhachhangId() {
        return khachhangId;
    }

    public void setKhachhangId(TblKhachhang khachhangId) {
        this.khachhangId = khachhangId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (donhangId != null ? donhangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDonhang)) {
            return false;
        }
        TblDonhang other = (TblDonhang) object;
        if ((this.donhangId == null && other.donhangId != null) || (this.donhangId != null && !this.donhangId.equals(other.donhangId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblDonhang[ donhangId=" + donhangId + " ]";
    }
    
}
