package com.bolatovyernur.woopayfirsttaskmvpjava.model.api;

import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.Fact;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobServices {
    @GET("fact/")
    Call<Fact> getFact();
}
