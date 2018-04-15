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
@Table(name = "tbl_sach")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSach.findAll", query = "SELECT t FROM TblSach t")
    , @NamedQuery(name = "TblSach.findBySachId", query = "SELECT t FROM TblSach t WHERE t.sachId = :sachId")
    , @NamedQuery(name = "TblSach.findByMasach", query = "SELECT t FROM TblSach t WHERE t.masach = :masach")
    , @NamedQuery(name = "TblSach.findByTensach", query = "SELECT t FROM TblSach t WHERE t.tensach = :tensach")
    , @NamedQuery(name = "TblSach.findByGiaban", query = "SELECT t FROM TblSach t WHERE t.giaban = :giaban")
    , @NamedQuery(name = "TblSach.findByNamxuatban", query = "SELECT t FROM TblSach t WHERE t.namxuatban = :namxuatban")
    , @NamedQuery(name = "TblSach.findBySotrang", query = "SELECT t FROM TblSach t WHERE t.sotrang = :sotrang")
    , @NamedQuery(name = "TblSach.findBySizebook", query = "SELECT t FROM TblSach t WHERE t.sizebook = :sizebook")
    , @NamedQuery(name = "TblSach.findByTheloai", query = "SELECT t FROM TblSach t WHERE t.theloai = :theloai")
    , @NamedQuery(name = "TblSach.findByMota", query = "SELECT t FROM TblSach t WHERE t.mota = :mota")})
public class TblSach implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SACH_ID")
    private Integer sachId;
    @Size(max = 50)
    @Column(name = "MASACH")
    private String masach;
    @Size(max = 50)
    @Column(name = "TENSACH")
    private String tensach;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GIABAN")
    private Float giaban;
    @Column(name = "NAMXUATBAN")
    @Temporal(TemporalType.DATE)
    private Date namxuatban;
    @Column(name = "SOTRANG")
    private Integer sotrang;
    @Size(max = 50)
    @Column(name = "SIZEBOOK")
    private String sizebook;
    @Size(max = 100)
    @Column(name = "THELOAI")
    private String theloai;
    @Size(max = 100)
    @Column(name = "MOTA")
    private String mota;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sachId")
    private Collection<TblGiohangSach> tblGiohangSachCollection;
    @JoinColumn(name = "TACGIA_ID", referencedColumnName = "TACGIA_ID")
    @ManyToOne(optional = false)
    private TblTacgia tacgiaId;
    @JoinColumn(name = "NHAXUATBAN_ID", referencedColumnName = "NHAXUATBAN_ID")
    @ManyToOne(optional = false)
    private TblNhaxuatban nhaxuatbanId;
    @JoinColumn(name = "DANHMUC_ID", referencedColumnName = "DANHMUC_ID")
    @ManyToOne(optional = false)
    private TblDanhmuc danhmucId;

    public TblSach() {
    }

    public TblSach(Integer sachId) {
        this.sachId = sachId;
    }

    public Integer getSachId() {
        return sachId;
    }

    public void setSachId(Integer sachId) {
        this.sachId = sachId;
    }

    public String getMasach() {
        return masach;
    }

    public void setMasach(String masach) {
        this.masach = masach;
    }

    public String getTensach() {
        return tensach;
    }

    public void setTensach(String tensach) {
        this.tensach = tensach;
    }

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public Date getNamxuatban() {
        return namxuatban;
    }

    public void setNamxuatban(Date namxuatban) {
        this.namxuatban = namxuatban;
    }

    public Integer getSotrang() {
        return sotrang;
    }

    public void setSotrang(Integer sotrang) {
        this.sotrang = sotrang;
    }

    public String getSizebook() {
        return sizebook;
    }

    public void setSizebook(String sizebook) {
        this.sizebook = sizebook;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    @XmlTransient
    public Collection<TblGiohangSach> getTblGiohangSachCollection() {
        return tblGiohangSachCollection;
    }

    public void setTblGiohangSachCollection(Collection<TblGiohangSach> tblGiohangSachCollection) {
        this.tblGiohangSachCollection = tblGiohangSachCollection;
    }

    public TblTacgia getTacgiaId() {
        return tacgiaId;
    }

    public void setTacgiaId(TblTacgia tacgiaId) {
        this.tacgiaId = tacgiaId;
    }

    public TblNhaxuatban getNhaxuatbanId() {
        return nhaxuatbanId;
    }

    public void setNhaxuatbanId(TblNhaxuatban nhaxuatbanId) {
        this.nhaxuatbanId = nhaxuatbanId;
    }

    public TblDanhmuc getDanhmucId() {
        return danhmucId;
    }

    public void setDanhmucId(TblDanhmuc danhmucId) {
        this.danhmucId = danhmucId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sachId != null ? sachId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSach)) {
            return false;
        }
        TblSach other = (TblSach) object;
        if ((this.sachId == null && other.sachId != null) || (this.sachId != null && !this.sachId.equals(other.sachId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.TblSach[ sachId=" + sachId + " ]";
    }
    
}
