package com.springTutorial.entities;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public class User_ {

	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> lastname;
	public static volatile SingularAttribute<User, String> email;
	
}
