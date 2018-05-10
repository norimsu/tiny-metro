/*
 * COPYRIGHT (c) Nextree Consulting 2014
 * This software is the proprietary of Nextree Consulting.
 */

package io.naraplatform.share.domain;

import java.util.ArrayList;
import java.util.List;

import io.naraplatform.share.util.json.JsonSerializable;
import io.naraplatform.share.util.json.JsonUtil;

public class NameValueList implements JsonSerializable {
	//
	private List<NameValue> nameValues;

	public NameValueList() {
		//
		this.nameValues = new ArrayList<>();
	}

	public NameValueList(NameValue nameValue) {
		//
		this();
		this.nameValues.add(nameValue);
	}

	public NameValueList(String name, String value) {
		//
		this();
		this.nameValues.add(new NameValue(name, value));
	}

	public static NameValueList newInstance(String name, String value) {
	    //
        return new NameValueList(name, value);
    }

	@Override
	public String toString() {
		//
		return toJson();
	}

	public static NameValueList getSample() {
		//
		return new NameValueList(new NameValue("name", "Cheolsoo Kim"));
	}

	public static NameValueList fromJson(String json) {
		//
		return JsonUtil.fromJson(json, NameValueList.class);
	}

	public NameValueList add(NameValue nameValue) {
		//
		this.nameValues.add(nameValue);
		return this;
	}

	public NameValueList add(String name, String value) {
		//
		this.nameValues.add(new NameValue(name, value));
		return this;
	}

	public String getValueOf(String name) {
		//
		return getNameValue(name).getValue();
	}

	public NameValue getNameValue(String name) {
		//
		return this.nameValues
				.stream()
				.filter(nameValue -> name.equals(nameValue.getName()))
				.findFirst()
				.orElse(null);
	}

	public void addAll(List<NameValue> nameValues) {
		//
		this.nameValues.addAll(nameValues);
	}

	public List<NameValue> list() {
		//
		return nameValues;
	}

	public void setNameValues(List<NameValue> nameValues) {
		this.nameValues = nameValues;
	}

	public boolean containsName(String name) {
		//
        return nameValues
            .stream()
            .anyMatch(nv -> nv.getName().equals(name));
	}

	public int size() {
		return nameValues.size();
	}

	public static void main(String[] args) {
		//
		System.out.println(getSample());
	}
}
