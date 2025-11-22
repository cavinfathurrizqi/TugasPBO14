/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan12;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "datasiswa")
@NamedQueries({
    @NamedQuery(name = "Datasiswa.findAll", query = "SELECT d FROM Datasiswa d"),
    @NamedQuery(name = "Datasiswa.findByAbsen", query = "SELECT d FROM Datasiswa d WHERE d.absen = :absen"),
    @NamedQuery(name = "Datasiswa.findByNama", query = "SELECT d FROM Datasiswa d WHERE d.nama = :nama"),
    @NamedQuery(name = "Datasiswa.findByWaliKelas", query = "SELECT d FROM Datasiswa d WHERE d.waliKelas = :waliKelas"),
    @NamedQuery(name = "Datasiswa.findByWaliMurid", query = "SELECT d FROM Datasiswa d WHERE d.waliMurid = :waliMurid")})
public class Datasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "absen")
    private String absen;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "wali_kelas")
    private String waliKelas;
    @Basic(optional = false)
    @Column(name = "wali_murid")
    private String waliMurid;
    @JoinColumn(name = "id_kelas", referencedColumnName = "id_kelas")
    @ManyToOne(optional = false)
    private Kelas idKelas;

    public Datasiswa() {
    }

    public Datasiswa(String absen) {
        this.absen = absen;
    }

    public Datasiswa(String absen, String nama, String waliKelas, String waliMurid) {
        this.absen = absen;
        this.nama = nama;
        this.waliKelas = waliKelas;
        this.waliMurid = waliMurid;
    }

    public String getAbsen() {
        return absen;
    }

    public void setAbsen(String absen) {
        this.absen = absen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaliKelas() {
        return waliKelas;
    }

    public void setWaliKelas(String waliKelas) {
        this.waliKelas = waliKelas;
    }

    public String getWaliMurid() {
        return waliMurid;
    }

    public void setWaliMurid(String waliMurid) {
        this.waliMurid = waliMurid;
    }

    public Kelas getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(Kelas idKelas) {
        this.idKelas = idKelas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (absen != null ? absen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datasiswa)) {
            return false;
        }
        Datasiswa other = (Datasiswa) object;
        if ((this.absen == null && other.absen != null) || (this.absen != null && !this.absen.equals(other.absen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuan12.Datasiswa[ absen=" + absen + " ]";
    }
    
}
