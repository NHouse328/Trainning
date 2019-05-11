package com.trainning.consultacep;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CEPService {

    @GET("ws/{cep}/json/")
    Call<Endereco> buscarCEP(@Path("cep") String cep);
}
