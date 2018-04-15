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
@Table(name = "tbl_khachhang")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblKhachhang.findAll", query = "SELECT t FROM TblKhachhang t")
    , @NamedQuery(name = "TblKhachhang.findByKhachhangId", query = "SELECT t FROM TblKhachhang t WHERE t.khachhangId = :khachhangId")
    , @NamedQuery(name = "TblKhachhang.findByHoten", query = "SELECT t FROM TblKhachhang t WHERE t.hoten = :hoten")
    , @NamedQuery(name = "TblKhachhang.findByDiachi", query = "SELECT t FROM TblKhachhang t WHERE t.diachi = :diachi")
    , @NamedQuery(name = "TblKhachhang.findByCmnd", query = "SELECT t FROM TblKhachhang t WHERE t.cmnd = :cmnd")
    , @NamedQuery(name = "TblKhachhang.findByNgaysinh", query = "SELECT t FROM TblKhachhang t WHERE t.ngaysinh = :ngaysinh")
    , @NamedQuery(name = "TblKhachhang.findByGioitinh", query = "SELECT t FROM TblKhachhang t WHERE t.gioitinh = :gioitinh")
    , @NamedQuery(name = "TblKhachhang.findByEmail", query = "SELECT t FROM TblKhachhang t WHERE t.email = :email")
    , @NamedQuery(name = "TblKhachhang.findBySodienthoai", query = "SELECT t FROM TblKhachhang t WHERE t.sodienthoai = :sodienthoai")
    , @NamedQuery(name = "TblKhachhang.findByIsvip", query = "SELECT t FROM TblKhachhang t WHERE t.isvip = :isvip")})
public class TblKhachhang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KHACHHANG_ID")
    private Integer khachhangId;
    @Size(max = 50)
    @Column(name = "HOTEN")
    private String hoten;
    @Size(max = 100)
    @Column(name = "DIACHI")
    private String diachi;
    @Size(max = 50)
    @Column(name = "CMND")
    private String cmnd;
    @Column(name = "NGAYSINH")
    @Temporal(TemporalType.DATE)
    private Date ngaysinh;
    @Column(name = "GIOITINH")
    private Integer gioitinh;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 50)
    @Column(name = "SODIENTHOAI")
    private String sodienthoai;
    @Column(name = "ISVIP")
    private Integer isvip;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachhangId")
    private Collection<TblDonhang> tblDonhangCollection;
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
    @ManyToOne(optional = false)
    private TblAccount accountId;

    public TblKhachhang() {
    }

    public TblKhachhang(Integer khachhangId) {
        this.khachhangId = khachhangId;
    }

    public Integer getKhachhangId() {
        return khachhangId;
    }

    public void setKhachhangId(Integer khachhangId) {
        this.khachhangId = khachhangId;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Integer getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(Integer gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public Integer getIsvip() {
        return isvip;
    }

    public void setIsvip(Integer isvip) {
        this.isvip = isvip;
    }

    @XmlTransient
    public Collection<TblDonhang> getTblDonhangCollection() {
        return tblDonhangCollection;
    }

    public void setTblDonhangCollection(Collection<TblDonhang> tblDonhangCollection) {
        this.tblDonhangCollection = tblDonhangCollection;
    }

    public TblAccount getAccountId() {
        return accountId;
    }

    public void setAccountId(TblAccount accountId) {
        this.accountId = accountId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (khachhangId != null ? khachhangId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblKhachhang)) {
            return false;
        }
        TblKhachhang other = (TblKhachhang) object;
        if ((this.khachhangId == null && other.khachhangId != null) || (this.khachhangId != null && !this.khachhangId.equals(other.khachhangId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblKhachhang[ khachhangId=" + khachhangId + " ]";
    }
    
}
