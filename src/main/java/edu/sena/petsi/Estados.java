/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.petsi;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "tbl_estados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estados.findAll", query = "SELECT e FROM Estados e")
    , @NamedQuery(name = "Estados.findByEstId", query = "SELECT e FROM Estados e WHERE e.estId = :estId")
    , @NamedQuery(name = "Estados.findByEstDescripcion", query = "SELECT e FROM Estados e WHERE e.estDescripcion = :estDescripcion")
    , @NamedQuery(name = "Estados.findByEstAceptada", query = "SELECT e FROM Estados e WHERE e.estAceptada = :estAceptada")
    , @NamedQuery(name = "Estados.findByEstEliminada", query = "SELECT e FROM Estados e WHERE e.estEliminada = :estEliminada")
    , @NamedQuery(name = "Estados.findByEstRechazada", query = "SELECT e FROM Estados e WHERE e.estRechazada = :estRechazada")
    , @NamedQuery(name = "Estados.findByEstFinalizada", query = "SELECT e FROM Estados e WHERE e.estFinalizada = :estFinalizada")})
public class Estados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Size(max = 45)
    @Column(name = "est_descripcion")
    private String estDescripcion;
    @Size(max = 45)
    @Column(name = "est_aceptada")
    private String estAceptada;
    @Size(max = 45)
    @Column(name = "est_eliminada")
    private String estEliminada;
    @Size(max = 45)
    @Column(name = "est_rechazada")
    private String estRechazada;
    @Size(max = 45)
    @Column(name = "est_finalizada")
    private String estFinalizada;
    @ManyToMany(mappedBy = "estadosCollection", fetch = FetchType.LAZY)
    private Collection<Citas> citasCollection;

    public Estados() {
    }

    public Estados(Integer estId) {
        this.estId = estId;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstDescripcion() {
        return estDescripcion;
    }

    public void setEstDescripcion(String estDescripcion) {
        this.estDescripcion = estDescripcion;
    }

    public String getEstAceptada() {
        return estAceptada;
    }

    public void setEstAceptada(String estAceptada) {
        this.estAceptada = estAceptada;
    }

    public String getEstEliminada() {
        return estEliminada;
    }

    public void setEstEliminada(String estEliminada) {
        this.estEliminada = estEliminada;
    }

    public String getEstRechazada() {
        return estRechazada;
    }

    public void setEstRechazada(String estRechazada) {
        this.estRechazada = estRechazada;
    }

    public String getEstFinalizada() {
        return estFinalizada;
    }

    public void setEstFinalizada(String estFinalizada) {
        this.estFinalizada = estFinalizada;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estados)) {
            return false;
        }
        Estados other = (Estados) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.adsi2025316.Estados[ estId=" + estId + " ]";
    }
    
}
