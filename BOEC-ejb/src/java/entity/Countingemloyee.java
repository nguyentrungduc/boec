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
@Table(name = "countingemloyee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Countingemloyee.findAll", query = "SELECT c FROM Countingemloyee c")
    , @NamedQuery(name = "Countingemloyee.findByPossionCounting", query = "SELECT c FROM Countingemloyee c WHERE c.possionCounting = :possionCounting")
    , @NamedQuery(name = "Countingemloyee.findByPersonID", query = "SELECT c FROM Countingemloyee c WHERE c.personID = :personID")})
public class Countingemloyee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "PossionCounting")
    private String possionCounting;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "PersonID")
    private String personID;
    @JoinColumn(name = "PersonID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Countingemloyee() {
    }

    public Countingemloyee(String personID) {
        this.personID = personID;
    }

    public String getPossionCounting() {
        return possionCounting;
    }

    public void setPossionCounting(String possionCounting) {
        this.possionCounting = possionCounting;
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
        if (!(object instanceof Countingemloyee)) {
            return false;
        }
        Countingemloyee other = (Countingemloyee) object;
        if ((this.personID == null && other.personID != null) || (this.personID != null && !this.personID.equals(other.personID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Countingemloyee[ personID=" + personID + " ]";
    }
    
}
