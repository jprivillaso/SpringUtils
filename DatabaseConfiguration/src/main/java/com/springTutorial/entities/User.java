package com.springTutorial.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

@Entity
public class User {

	@Id
	private long id;

	@Column
	private String name;

	@Column
	private String lastname;

	@Column
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Specification<User> isNameLike(final String name) {

		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get(User_.name), "%" + name + "%");

			}
		};
	}
	
	public static Specification<User> isLastnameLike(final String lastname) {

		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get(User_.lastname), "%" + lastname + "%");

			}
		};
	}
	
	public static Specification<User> isEmailLike(final String email) {

		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {

				return cb.like(root.get(User_.email), "%" + email + "%");

			}
		};
	}
}

