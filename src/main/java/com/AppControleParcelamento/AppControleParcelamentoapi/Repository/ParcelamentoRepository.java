package com.AppControleParcelamento.AppControleParcelamentoapi.Repository;


import com.AppControleParcelamento.AppControleParcelamentoapi.model.Parcelamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelamentoRepository extends JpaRepository<Parcelamento, Long> {
}
