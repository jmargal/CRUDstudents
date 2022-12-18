package com.jacaranda.primerSpring.model;

import java.util.Objects;

public class Student {

	private String name;
	private String apellido;
	private int age;
	
	
	
	public Student() {
		super();
	}
	public Student(String name, String apellido, int age) {
		super();
		this.name = name;
		this.apellido = apellido;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, apellido, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(apellido, other.apellido) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", apellido=" + apellido + ", age=" + age + "]";
	}
	
	
	
}