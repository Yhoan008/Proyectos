package main;

public class Empleado {
    String cedula;String nombre;String apellido;String celular;String Departamento;String Genero;String direccion;String telefono;String email;String salarioBase;String hora;String diurno;String noche;String hed  ;String hen  ;String subsidio;String salario;String trabaja;

        



    public Empleado(String cedula, String nombre, String apellido, String celular, String departamento,
            String genero, String direccion, String telefono, String email, String salarioBase, String hora,
            String diurno, String noche, String hed, String hen, String subsidio, String salario, String trabaja) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.Departamento = departamento;
        this.Genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.salarioBase = salarioBase;
        this.hora = hora;
        this.diurno = diurno;
        this.noche = noche;
        this.hed = hed;
        this.hen = hen;
        this.subsidio = subsidio;
        this.salario = salario;
        this.trabaja = trabaja;
    }
    @Override
    public String toString() {
        return "Empleado [Departamento=" + Departamento + ", Genero=" + Genero + ", apellido=" + apellido
                + ", cedula=" + cedula + ", celular=" + celular + ", direccion=" + direccion + ", diurno=" + diurno
                + ", email=" + email + ", hed=" + hed + ", hen=" + hen + ", hora=" + hora + ", noche=" + noche
                + ", nombre=" + nombre + ", salario=" + salario + ", salarioBase=" + salarioBase + ", subsidio="
                + subsidio + ", telefono=" + telefono + ", trabaja=" + trabaja + "]";
    }
    
    
    public String getTrabaja() {
        return trabaja;
    }
    public void setTrabaja(String trabaja) {
        this.trabaja = trabaja;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCelular() {
        return celular;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getDepartamento() {
        return Departamento;
    }
    public void setDepartamento(String departamento) {
        this.Departamento = departamento;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        this.Genero = genero;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(String salarioBase) {
        this.salarioBase = salarioBase;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDiurno() {
        return diurno;
    }
    public void setDiurno(String diurno) {
        this.diurno = diurno;
    }
    public String getNoche() {
        return noche;
    }
    public void setNoche(String noche) {
        this.noche = noche;
    }
    public String getHed() {
        return hed;
    }
    public void setHed(String hed) {
        this.hed = hed;
    }
    public String getHen() {
        return hen;
    }
    public void setHen(String hen) {
        this.hen = hen;
    }
    public String getSubsidio() {
        return subsidio;
    }
    public void setSubsidio(String subsidio) {
        this.subsidio = subsidio;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
}
