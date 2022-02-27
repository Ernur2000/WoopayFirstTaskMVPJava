package com.bolatovyernur.woopayfirsttaskmvpjava.presenter;

import com.bolatovyernur.woopayfirsttaskmvpjava.interfaces.FactInterface;
import com.bolatovyernur.woopayfirsttaskmvpjava.model.repos.FactRepos;

public class FactPresenter implements FactInterface.FactPresenter {
    private final FactInterface.FactModel model = new FactRepos();
    FactInterface.FactView view;
    public FactPresenter(FactInterface.FactView view) {
        this.view = view;
    }

    @Override
    public void networkCall() {
        model.getFact(this);
    }

    @Override
    public void translateCall() {
        model.getTranslatedText(this);
    }

    @Override
    public void uiAutoUpdate(String text) {
        view.updateViewData(text);
    }

    @Override
    public void updateUiTranslatedText(String text) {
        view.updateViewTranslatedText(text);
    }
}
