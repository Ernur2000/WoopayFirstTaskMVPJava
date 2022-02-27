package com.bolatovyernur.woopayfirsttaskmvpjava.model.api;

import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.Fact;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.TranslatedText;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;

public interface JobServices {
    @GET("fact/")
    Call<Fact> getFact();

    @GET
    Call<TranslatedText> getText(@Url String url,
                                 @Header("x-rapidapi-key") String key,
                                 @Header("x-rapidapi-host") String host);
}
