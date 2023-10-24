package sn.isepdiamniadio.edu.sn.crud_etudiant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.isepdiamniadio.edu.sn.crud_etudiant.controller.Etudiant;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findById(java.lang.Long aLong);
}
