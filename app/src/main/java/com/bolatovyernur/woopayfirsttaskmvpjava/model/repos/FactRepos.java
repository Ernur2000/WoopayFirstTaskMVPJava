package com.bolatovyernur.woopayfirsttaskmvpjava.model.repos;
import android.util.Log;
import com.bolatovyernur.woopayfirsttaskmvpjava.interfaces.FactInterface;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.api.JobAPI;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.Fact;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactRepos implements FactInterface.FactModel {
    private String fact;
    @Override
    public void getFact(FactInterface.FactPresenter presenter) {
        Call<Fact> factCall = JobAPI.getApi().getFact();
        factCall.enqueue(new Callback<Fact>() {
            @Override
            public void onResponse(Call<Fact> call, Response<Fact> response) {
            if (response.isSuccessful()){
                assert response.body() != null;
                String result = response.body().getFact();
                fact = result;
                presenter.uiAutoUpdate();
            }
            }

            @Override
            public void onFailure(Call<Fact> call, Throwable t) {
                Log.d("error",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public String getFacts() {
        return fact;
    }
}
