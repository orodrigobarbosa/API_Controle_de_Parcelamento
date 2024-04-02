package com.AppControleParcelamento.AppControleParcelamentoapi.exceptionhandler;


import com.AppControleParcelamento.AppControleParcelamentoapi.exception.NegocioException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;
import java.util.stream.Collectors;

@RestControllerAdvice
//classe responsável por tratar todas as exceçoes da aplicação concentradas aqui
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler { //Essa classe estendida tem por padrão diversas excessoes, economizando a digitacao código

    //método da classe EntityExceptionHadler, extendida que trata a exceçao
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException excecao, HttpHeaders headers, HttpStatusCode status, WebRequest request) {


            //instanciar o problem detail
            ProblemDetail problemDetail = ProblemDetail.forStatus(status);
            problemDetail.setTitle("Um ou mais campos estão inválidos");
            problemDetail.setType((URI.create("https://geralmente-vai-o-domínio-da-empresa")));



           var field = excecao.getBindingResult().getAllErrors().stream()
                    .collect(Collectors.toMap(error -> ((FieldError)error).getField(),
                    DefaultMessageSourceResolvable::getDefaultMessage));

           problemDetail.setProperty("fields", field );


            return super.handleExceptionInternal(excecao, problemDetail, headers, status, request);
        }


    @ExceptionHandler(NegocioException.class) //ExcaptionHandler captura as exceçoes lancadas dentro de um controlador
    public ResponseEntity<String> capturar(NegocioException e){
        return ResponseEntity.badRequest().body(e.getMessage());

    }

}
