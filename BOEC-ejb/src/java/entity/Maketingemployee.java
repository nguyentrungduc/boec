/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "maketingemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maketingemployee.findAll", query = "SELECT m FROM Maketingemployee m")
    , @NamedQuery(name = "Maketingemployee.findByPossionMaketing", query = "SELECT m FROM Maketingemployee m WHERE m.possionMaketing = :possionMaketing")
    , @NamedQuery(name = "Maketingemployee.findByPersonID", query = "SELECT m FROM Maketingemployee m WHERE m.personID = :personID")})
public class Maketingemployee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "PossionMaketing")
    private String possionMaketing;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PersonID")
    private String personID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Maketingemployee() {
    }

    public Maketingemployee(String personID) {
        this.personID = personID;
    }

    public String getPossionMaketing() {
        return possionMaketing;
    }

    public void setPossionMaketing(String possionMaketing) {
        this.possionMaketing = possionMaketing;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personID != null ? personID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maketingemployee)) {
            return false;
        }
        Maketingemployee other = (Maketingemployee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Maketingemployee[ personID=" + personID + " ]";
    }
    
}
