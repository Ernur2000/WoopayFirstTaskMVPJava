package com.bolatovyernur.woopayfirsttaskmvpjava.model.model;

import java.util.List;

public class TranslatedText {
    private String lang;
    private List<String> text;
    private String code;

    public TranslatedText(String lang, List<String> text, String code) {
        this.lang = lang;
        this.text = text;
        this.code = code;
    }
    public List<String> getText() { return text; }

    public void setText(List<String> text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
