package io.naraplatform.share.domain.lang;

import io.naraplatform.share.domain.NameValue;
import io.naraplatform.share.domain.NameValueList;
import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;
import io.naraplatform.share.util.string.StringUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class LangText implements JsonSerializable {
    //
    private String defaultLangCode;
    private String text;
    private Map<String,String> textMap;

    public LangText() {
        //
        this.textMap = new HashMap<>();
    }

    public LangText(String langCode, String text) {
        //
        this.defaultLangCode = langCode;
        this.text = text;
        this.textMap = new HashMap<>();
        this.textMap.put(defaultLangCode, text);
    }

    public static LangText newText(String langCode, String text) {
        //
        return new LangText(langCode, text);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static LangText fromJson(String json) {
        //
        return JsonUtil.fromJson(json, LangText.class);
    }

    public static LangText getSample() {
        //
        String langCode = Locale.KOREA.getLanguage();
        LangText sample = new LangText(langCode, "넥스트리소프트");
        sample.addText(Locale.US, "NEXTREE SOFT");

        return sample;
    }

    public int size() {
        //
        return textMap.size();
    }

    public Iterator<String> langCodeIterator() {
        //
        return textMap.keySet().iterator();
    }

    public String getText() {
        //
        if (StringUtil.isEmpty(text)) {
            return textMap.get(defaultLangCode);
        }
        return text;
    }

    public String getText(String langCode) {
        //
        if(langCode.equals(defaultLangCode)) {
            return text;
        } else {

            String text = textMap.get(langCode);
            if (text == null) {
                text = textMap.get(defaultLangCode);
            }

            return text;
        }
    }


    public LangText addText(String langCode, String text) {
        //
        if(langCode == null || text == null) {
            return this;
        }

        if(langCode.equals(defaultLangCode)) {
            this.text = text;
            return this;
        }

        textMap.put(langCode, text);

        return this;
    }

    public void addText(Locale locale, String text) {
        //
        this.addText(locale.getLanguage(), text);
    }

    public String getDefaultLangCode() {
        return defaultLangCode;
    }

    public void setDefaultLangCode(String langCode) {
        //
        this.defaultLangCode = langCode;
    }

    public Map<String, String> getTextMap() {
        return textMap;
    }

    public NameValueList getNameValues() {
        //
        NameValueList nameValues = new NameValueList();
        if(text == null) {
            nameValues.add(new NameValue(defaultLangCode, "null"));
        } else {
            nameValues.add(new NameValue(defaultLangCode, text));
        }

        nameValues.add(defaultLangCode, text);
        Iterator<String> langCodeIter = this.langCodeIterator();
        while(langCodeIter.hasNext()) {
            String langCode = langCodeIter.next();
            nameValues.add(langCode, textMap.get(langCode));
        }

        return nameValues;
    }

    public void setTextMap(Map<String, String> textMap) {
        this.textMap = textMap;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
