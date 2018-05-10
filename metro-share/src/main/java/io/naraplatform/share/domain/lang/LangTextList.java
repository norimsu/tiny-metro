/*
 * COPYRIGHT (c) Nextree Consulting 2014
 * This software is the proprietary of Nextree Consulting.
 */

package io.naraplatform.share.domain.lang;

import java.util.ArrayList;
import java.util.List;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class LangTextList implements JsonSerializable {
	//
	private List<LangText> langTexts;

	public LangTextList() {
		//
		this.langTexts = new ArrayList<>();
	}

	public LangTextList(LangText langText) {
		//
		this();
		this.langTexts.add(langText);
	}

	public LangTextList(String langCode, String text) {
		//
		this();
		this.langTexts.add(new LangText(langCode, text));
	}

	public LangTextList(List<LangText> langTexts) {
		//
		this.langTexts = langTexts;
	}

	@Override
	public String toString() {
		//
		return toJson();
	}

	public static LangTextList fromJson(String json) {
		//
		return JsonUtil.fromJson(json, LangTextList.class);
	}

	public static LangTextList getSample() {
	    //
        return new LangTextList(LangText.getSample());
    }

	public LangTextList add(LangText langText) {
		//
		this.langTexts.add(langText);
		return this;
	}

	public void add(String langCode, String text) {
		//
		this.langTexts.add(new LangText(langCode, text));
	}

	public void addAll(List<LangText> langTexts) {
		//
		this.langTexts.addAll(langTexts);
	}

	public LangText get(int index) {
	    //
        if (langTexts.size() <= (index+1)) {
            return langTexts.get(index);
        }

        return null;
    }

	public List<LangText> getList() {
		//
		return langTexts;
	}

	public void setList(List<LangText> langTexts) {
	    //
        this.langTexts = langTexts;
    }

	public boolean containsText(String text) {
		//
        return langTexts
            .stream()
            .anyMatch(lt -> lt.getText().equals(text));
	}

	public int size() {
		return langTexts.size();
	}
}
