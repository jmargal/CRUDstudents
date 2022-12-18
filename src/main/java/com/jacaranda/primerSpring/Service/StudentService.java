package com.jacaranda.primerSpring.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.primerSpring.model.Student;

@Service
public class StudentService {

	private List<Student> lista;

	public StudentService() {
		super();
		this.lista = new ArrayList<Student>();
		lista.add(new Student("Manolo", "Perez", 18));
		lista.add(new Student("Pepe", "Garcia", 19));
		lista.add(new Student("Lionel", "Messi", 33));
		lista.add(new Student("Karim", "Benzema", 34));

	}

	public boolean add(Student e) {
		return lista.add(e);
	}

	public void update(Student e) {
		for(Student s:lista) {
			if(s.getName().equals(e.getName())&&s.getApellido().equals(e.getApellido())) {
				int pos=lista.indexOf(s);
				lista.set(pos, e);
			}
		}

	}

	public boolean remove(Object o) {
		return lista.remove(o);
	}

	public List<Student> getLista() {
		return lista;
	}

	public Student get(String name, String apellido) {
		boolean encontrado = false;
		Student resul = null;
		Iterator<Student> iterator = this.lista.iterator();
		while (iterator.hasNext() && !encontrado) {
			resul = iterator.next();
			if (resul.getName().equals(name) && resul.getApellido().equals(apellido)) {
				encontrado = true;
			}
		}
		return resul;
	}

}
