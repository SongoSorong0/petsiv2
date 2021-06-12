/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.petsi;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MIGUEL
 */
@Entity
@Table(name = "tbl_mascotas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascotas.findAll", query = "SELECT m FROM Mascotas m")
    , @NamedQuery(name = "Mascotas.findByMctId", query = "SELECT m FROM Mascotas m WHERE m.mctId = :mctId")
    , @NamedQuery(name = "Mascotas.findByMctNombre", query = "SELECT m FROM Mascotas m WHERE m.mctNombre = :mctNombre")
    , @NamedQuery(name = "Mascotas.findByMctTipomascota", query = "SELECT m FROM Mascotas m WHERE m.mctTipomascota = :mctTipomascota")
    , @NamedQuery(name = "Mascotas.findByMctTipomctOtro", query = "SELECT m FROM Mascotas m WHERE m.mctTipomctOtro = :mctTipomctOtro")
    , @NamedQuery(name = "Mascotas.findByMctRaza", query = "SELECT m FROM Mascotas m WHERE m.mctRaza = :mctRaza")
    , @NamedQuery(name = "Mascotas.findByMctRazaOtro", query = "SELECT m FROM Mascotas m WHERE m.mctRazaOtro = :mctRazaOtro")
    , @NamedQuery(name = "Mascotas.findByMctDescripcion", query = "SELECT m FROM Mascotas m WHERE m.mctDescripcion = :mctDescripcion")
    , @NamedQuery(name = "Mascotas.findByMctFechanacimiento", query = "SELECT m FROM Mascotas m WHERE m.mctFechanacimiento = :mctFechanacimiento")
    , @NamedQuery(name = "Mascotas.findByMctSexo", query = "SELECT m FROM Mascotas m WHERE m.mctSexo = :mctSexo")})
public class Mascotas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mct_id")
    private Integer mctId;
    @Size(max = 45)
    @Column(name = "mct_nombre")
    private String mctNombre;
    @Size(max = 45)
    @Column(name = "mct_tipomascota")
    private String mctTipomascota;
    @Size(max = 45)
    @Column(name = "mct_tipomct_otro")
    private String mctTipomctOtro;
    @Size(max = 45)
    @Column(name = "mct_raza")
    private String mctRaza;
    @Size(max = 45)
    @Column(name = "mct_raza_otro")
    private String mctRazaOtro;
    @Size(max = 45)
    @Column(name = "mct_descripcion")
    private String mctDescripcion;
    @Column(name = "mct_fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date mctFechanacimiento;
    @Size(max = 45)
    @Column(name = "mct_sexo")
    private String mctSexo;
    @ManyToMany(mappedBy = "mascotasCollection", fetch = FetchType.LAZY)
    private Collection<Usuario> usuarioCollection;
    @JoinTable(name = "tbl_mascotas_has_tbl_citas", joinColumns = {
        @JoinColumn(name = "tbl_mascotas_mct_id", referencedColumnName = "mct_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbl_citas_cit_id", referencedColumnName = "cit_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Citas> citasCollection;
    @JoinTable(name = "tbl_historiaclinica_has_tbl_mascotas", joinColumns = {
        @JoinColumn(name = "tbl_historiaclinica_hc_id", referencedColumnName = "mct_id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbl_mascotas_mct_id", referencedColumnName = "hc_id")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Historiaclinica> historiaclinicaCollection;

    public Mascotas() {
    }

    public Mascotas(Integer mctId) {
        this.mctId = mctId;
    }

    public Integer getMctId() {
        return mctId;
    }

    public void setMctId(Integer mctId) {
        this.mctId = mctId;
    }

    public String getMctNombre() {
        return mctNombre;
    }

    public void setMctNombre(String mctNombre) {
        this.mctNombre = mctNombre;
    }

    public String getMctTipomascota() {
        return mctTipomascota;
    }

    public void setMctTipomascota(String mctTipomascota) {
        this.mctTipomascota = mctTipomascota;
    }

    public String getMctTipomctOtro() {
        return mctTipomctOtro;
    }

    public void setMctTipomctOtro(String mctTipomctOtro) {
        this.mctTipomctOtro = mctTipomctOtro;
    }

    public String getMctRaza() {
        return mctRaza;
    }

    public void setMctRaza(String mctRaza) {
        this.mctRaza = mctRaza;
    }

    public String getMctRazaOtro() {
        return mctRazaOtro;
    }

    public void setMctRazaOtro(String mctRazaOtro) {
        this.mctRazaOtro = mctRazaOtro;
    }

    public String getMctDescripcion() {
        return mctDescripcion;
    }

    public void setMctDescripcion(String mctDescripcion) {
        this.mctDescripcion = mctDescripcion;
    }

    public Date getMctFechanacimiento() {
        return mctFechanacimiento;
    }

    public void setMctFechanacimiento(Date mctFechanacimiento) {
        this.mctFechanacimiento = mctFechanacimiento;
    }

    public String getMctSexo() {
        return mctSexo;
    }

    public void setMctSexo(String mctSexo) {
        this.mctSexo = mctSexo;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @XmlTransient
    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @XmlTransient
    public Collection<Historiaclinica> getHistoriaclinicaCollection() {
        return historiaclinicaCollection;
    }

    public void setHistoriaclinicaCollection(Collection<Historiaclinica> historiaclinicaCollection) {
        this.historiaclinicaCollection = historiaclinicaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mctId != null ? mctId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascotas)) {
            return false;
        }
        Mascotas other = (Mascotas) object;
        if ((this.mctId == null && other.mctId != null) || (this.mctId != null && !this.mctId.equals(other.mctId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.adsi2025316.Mascotas[ mctId=" + mctId + " ]";
    }
    
}
