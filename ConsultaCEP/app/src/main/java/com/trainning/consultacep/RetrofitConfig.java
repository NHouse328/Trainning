package com.trainning.consultacep;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://viacep.com.br/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public CEPService getCEP() {
        return this.retrofit.create(CEPService.class);
    }

}
