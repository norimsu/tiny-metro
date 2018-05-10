package io.naraplatform.share.domain.granule;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import io.naraplatform.share.domain.ValueObject;
import io.naraplatform.share.util.json.JsonUtil;

public class Name implements ValueObject {
	//
	private String defaultLangCode;
    private Map<String,LocaledName> localedNameMap;

	public Name() {
		//
        this.localedNameMap = new HashMap<>();
	}

	public Name(Locale langLocale, String firstName, String familyName) {
		//
        this();
        this.defaultLangCode = langLocale.getLanguage();
        LocaledName localedName = new LocaledName(langLocale, familyName, firstName);
        this.localedNameMap.put(defaultLangCode, localedName);
	}

	@Override
	public String toString() {
		//
		return toJson();
	}

	public static Name getSample() {
		//
		Locale langLocale = Locale.US;
		String firstName = "Steve";
		String familyName = "Jobs";

		Name sample = new Name(langLocale, firstName, familyName);

		return sample;
	}

	public static Name getSecondSample() {
		//
		Locale langLocale = Locale.US;
		String firstName = "Dan";
		String familyName = "Brown";

		Name sample = new Name(langLocale, firstName, familyName);

		return sample;
	}

	public static Name fromJson(String json) {
		//
		return JsonUtil.fromJson(json, Name.class);
	}

	public LocaledName getName() {
	    //
        return this.localedNameMap.get(defaultLangCode);
    }

	public LocaledName getNameOf(String langCode) {
	    //
        return this.localedNameMap.get(langCode);
    }

    public void addLocaledName(LocaledName name) {
	    //
        this.localedNameMap.put(name.getLangCode(), name);
    }

    public String getDefaultLangCode() {
        return defaultLangCode;
    }

    public void setDefaultLangCode(String defaultLangCode) {
        this.defaultLangCode = defaultLangCode;
    }

    public Map<String, LocaledName> getLocaledNameMap() {
        return localedNameMap;
    }

    public void setLocaledNameMap(Map<String, LocaledName> localedNameMap) {
        this.localedNameMap = localedNameMap;
    }

    public String getFirstName() {
		return this.localedNameMap.get(defaultLangCode).getGivenName();
	}

	public String getMiddleName() {
		return this.localedNameMap.get(defaultLangCode).getMiddleName();
	}

	public String getFamilyName() {
		return this.localedNameMap.get(defaultLangCode).getFamilyName();
	}

	public String getDisplayName() {
		return this.localedNameMap.get(defaultLangCode).getDisplayName();
	}

	public static void main(String[] args) {
		//
		System.out.println(getSample().toJson());
		System.out.println(getSecondSample().toJson());
	}
}
