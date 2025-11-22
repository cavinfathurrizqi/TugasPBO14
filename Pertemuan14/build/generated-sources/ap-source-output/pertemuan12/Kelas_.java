package pertemuan12;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pertemuan12.Datasiswa;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-11-21T15:08:19", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Kelas.class)
public class Kelas_ { 

    public static volatile CollectionAttribute<Kelas, Datasiswa> datasiswaCollection;
    public static volatile SingularAttribute<Kelas, String> idKelas;
    public static volatile SingularAttribute<Kelas, String> namaKelas;
    public static volatile SingularAttribute<Kelas, String> jurusan;

}