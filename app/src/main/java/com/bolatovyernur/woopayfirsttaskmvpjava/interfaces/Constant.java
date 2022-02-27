package com.bolatovyernur.woopayfirsttaskmvpjava.interfaces;

import com.bolatovyernur.woopayfirsttaskmvpjava.model.api.JobAPI;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.api.JobServices;

public interface Constant {
    String BASE_URL  = "https://catfact.ninja/";
    JobServices jobServices = JobAPI.getRetrofit(BASE_URL).create(JobServices.class);
}
