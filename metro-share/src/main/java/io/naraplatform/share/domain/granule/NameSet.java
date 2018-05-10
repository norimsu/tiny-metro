package io.naraplatform.share.domain.granule;

import java.util.HashMap;
import java.util.Map;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;

public class NameSet implements ValueObject {
    //
    private String defaultLangCode;
    private String displayName;
    private Map<String,LocaledName> nameMap;

    public NameSet() {
        //
        this.nameMap = new HashMap<>();
    }

    public NameSet(LocaledName name) {
        //
        this.defaultLangCode = name.getLangCode();
        this.displayName = name.getDisplayName();
        this.nameMap = new HashMap<>();
        addName(name);
    }

    @Override
    public String toString() {
        //
        return toJson();
    }

    public static NameSet getSample() {
        //
        LocaledName name = LocaledName.getSample();
        NameSet sample = new NameSet(name);
        sample.addName(LocaledName.getEnglishSample());

        return sample;
    }

    public static NameSet fromJson(String json) {
        //
        return JsonUtil.fromJson(json, NameSet.class);
    }

    public void addName(LocaledName name) {
        //
        this.nameMap.put(name.getLangCode(), name);
    }

    public void removeName(String langCode) {
        //
        this.nameMap.remove(langCode);
    }

    public LocaledName getLocaedName(String langCode) {
        //
        LocaledName resultName = nameMap.get(langCode);
        if (resultName == null) {
            resultName = getDefault();
        }

        return resultName;
    }

    public LocaledName getDefault() {
        //
        return nameMap.get(defaultLangCode);
    }

    public String getDefaultLangCode() {
        return defaultLangCode;
    }

    public void setDefaultLangCode(String defaultLangCode) {
        this.defaultLangCode = defaultLangCode;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Map<String, LocaledName> getNameMap() {
        return nameMap;
    }

    public void setNameMap(Map<String, LocaledName> nameMap) {
        this.nameMap = nameMap;
    }

    public static void main(String[] args) {
        //
        System.out.println(getSample());
    }
}
