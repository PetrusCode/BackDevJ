package Entidades;

public class Usuario {

int id;
int edad;
String nombre;
String apellidos;

public Usuario(int id, int edad, String nombre, String apellidos) {
	this.id=id;
	this.edad=edad;
	this.nombre=nombre;
	this.apellidos=apellidos;
	
}
public Usuario (int edad, String nombre, String apellidos) {
	this.edad=edad;
	this.nombre=nombre;
	this.apellidos=apellidos;
	
}

public Usuario(String nombre) {
	this.nombre=nombre;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getEdad() {
	return edad;
}
public void setEdad(int edad) {
	this.edad = edad;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}
@Override
public String toString() {
	return "Usuario [id=" + id + ", edad=" + edad + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
}

}
