package com.bolatovyernur.woopayfirsttaskmvpjava.interfaces;

public interface FactInterface {
    interface FactModel{
        void getFact(FactPresenter presenter);
        String getFacts();
    }
    interface FactPresenter{
        void networkCall();
        String showFact();
        void uiAutoUpdate();
    }
    interface FactView{
        void updateViewData();
    }
}
