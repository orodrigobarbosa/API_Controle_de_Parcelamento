package com.AppControleParcelamento.AppControleParcelamentoapi.assembler;

import com.AppControleParcelamento.AppControleParcelamentoapi.model.Parcelamento;
import com.AppControleParcelamento.AppControleParcelamentoapi.representationmodel.ParcelamentoModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component

public class ParcelamentoAssembler {

    private final ModelMapper modelMapper;

    public ParcelamentoModel toModel(Parcelamento parcelamento) {
        return modelMapper.map(parcelamento, ParcelamentoModel.class);
    }


    //metodo para transformar a lista de entidade parcelamento em lista de parcelamento model

    public List<ParcelamentoModel> toCollectionModel(List<Parcelamento> parcelamentos) {
        return parcelamentos.stream().map(this::toModel).toList();
    }


}
