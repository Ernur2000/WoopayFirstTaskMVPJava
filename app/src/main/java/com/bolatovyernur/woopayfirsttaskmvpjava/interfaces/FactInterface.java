package com.bolatovyernur.woopayfirsttaskmvpjava.interfaces;

public interface FactInterface {
    interface FactModel{
        void getFact(FactPresenter presenter);
        void getTranslatedText(FactPresenter presenter);
    }
    interface FactPresenter{
        void networkCall();
        void translateCall();
        void uiAutoUpdate(String text);
        void updateUiTranslatedText(String text);
    }
    interface FactView{
        void updateViewData(String text);
        void updateViewTranslatedText(String text);
    }
}
