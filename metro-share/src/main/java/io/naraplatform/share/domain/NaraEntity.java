package io.naraplatform.share.domain;

import io.naraplatform.share.util.json.JsonSerializable;
import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public abstract class NaraEntity implements JsonSerializable {
	//
	private final String id;
	private Long version;

	protected NaraEntity() {
		this.id = UUID.randomUUID().toString();
	}

	protected NaraEntity(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object target) {
		//
		if (this == target) {
			return true;
		}

		if (target == null || getClass() != target.getClass()) {
			return false;
		}

		NaraEntity entity = (NaraEntity) target;

		return Objects.equals(id, entity.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
	    //
		return JsonSerializable.super.toJson();
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public static void main(String[] args) {
	    //
        System.out.println(UUID.randomUUID().toString());
        System.out.println(UUID.randomUUID().toString());
    }
}
