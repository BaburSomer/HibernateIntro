package com.bilgeadam.boost.course02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@ToString
@NoArgsConstructor
public class UserEntity implements BilgeAdamAble {
	@Id // primary key olarak tanımladık
	@GeneratedValue(strategy = GenerationType.IDENTITY) // oid'nin yaratılma stratejisini belirledik
	@Column(name = "id", insertable = true, updatable = false)
	private long oid;

	@Column(name = "first_name", length = 50)
	private String firstName;

	@Column(name = "last_name", length = 50)
	private String lastName;

	@Setter
	@Column(name = "email", unique = true, nullable = false) // unique yaparak bir alternate key yarattık
																// nullable=false fiyerek boş değer girilmesini
																// engelledik
	private String email;

	public UserEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName  = lastName;
	}
}
