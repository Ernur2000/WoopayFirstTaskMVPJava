package com.bolatovyernur.woopayfirsttaskmvpjava.model.repos;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bolatovyernur.woopayfirsttaskmvpjava.interfaces.Constant;
import com.bolatovyernur.woopayfirsttaskmvpjava.interfaces.FactInterface;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.api.JobServices;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.Fact;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.model.TranslatedText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FactRepos implements FactInterface.FactModel {
    JobServices jobServices;
    String fact;
    @Override
    public void getFact(FactInterface.FactPresenter presenter) {
        jobServices = Constant.jobServices;
        Call<Fact> factCall = jobServices.getFact();
        factCall.enqueue(new Callback<Fact>() {
            @Override
            public void onResponse(@NonNull Call<Fact> call, @NonNull Response<Fact> response) {
            if (response.isSuccessful()){
                assert response.body() != null;
                String result = response.body().getFact();
                fact = result;
                presenter.uiAutoUpdate(result);
                }
            }

            @Override
            public void onFailure(@NonNull Call<Fact> call, @NonNull Throwable t) {
                Log.d("error",t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void getTranslatedText(FactInterface.FactPresenter presenter) {
        jobServices = Constant.jobServices;
        Call<TranslatedText> call = jobServices.getText("https://just-translated.p.rapidapi.com/?lang=ru&text=" + fact,"a5e68975c7mshb36f57ca47ccf9bp1da4c3jsnbcdd60f9246b","just-translated.p.rapidapi.com");
        call.enqueue(new Callback<TranslatedText>() {
            @Override
            public void onResponse(@NonNull Call<TranslatedText> call, @NonNull Response<TranslatedText> response) {
                if (response.isSuccessful()){
                    assert response.body() != null;
                    String result = response.body().getText().get(0);
                    presenter.updateUiTranslatedText(result);
                }
            }

            @Override
            public void onFailure(@NonNull Call<TranslatedText> call, @NonNull Throwable t) {
                Log.d("error",t.getLocalizedMessage());
            }
        });
    }
}
