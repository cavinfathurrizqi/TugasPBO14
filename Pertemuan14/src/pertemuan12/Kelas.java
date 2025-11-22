/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuan12;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author LENOVO
 */
@Entity
@Table(name = "kelas")
@NamedQueries({
    @NamedQuery(name = "Kelas.findAll", query = "SELECT k FROM Kelas k"),
    @NamedQuery(name = "Kelas.findByIdKelas", query = "SELECT k FROM Kelas k WHERE k.idKelas = :idKelas"),
    @NamedQuery(name = "Kelas.findByNamaKelas", query = "SELECT k FROM Kelas k WHERE k.namaKelas = :namaKelas"),
    @NamedQuery(name = "Kelas.findByJurusan", query = "SELECT k FROM Kelas k WHERE k.jurusan = :jurusan")})
public class Kelas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kelas")
    private String idKelas;
    @Basic(optional = false)
    @Column(name = "nama_kelas")
    private String namaKelas;
    @Basic(optional = false)
    @Column(name = "jurusan")
    private String jurusan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKelas")
    private Collection<Datasiswa> datasiswaCollection;

    public Kelas() {
    }

    public Kelas(String idKelas) {
        this.idKelas = idKelas;
    }

    public Kelas(String idKelas, String namaKelas, String jurusan) {
        this.idKelas = idKelas;
        this.namaKelas = namaKelas;
        this.jurusan = jurusan;
    }

    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public Collection<Datasiswa> getDatasiswaCollection() {
        return datasiswaCollection;
    }

    public void setDatasiswaCollection(Collection<Datasiswa> datasiswaCollection) {
        this.datasiswaCollection = datasiswaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKelas != null ? idKelas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kelas)) {
            return false;
        }
        Kelas other = (Kelas) object;
        if ((this.idKelas == null && other.idKelas != null) || (this.idKelas != null && !this.idKelas.equals(other.idKelas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pertemuan12.Kelas[ idKelas=" + idKelas + " ]";
    }
    
}
