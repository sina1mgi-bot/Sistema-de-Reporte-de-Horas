public abstract class Usuario {
    protected String nombre;
    protected String psww;

    public Usuario(String nombre, String psww){
        this.nombre = nombre;
        this.psww = psww;
    }

    public boolean IniciarSesion(String user, String pass){
        return this.nombre.equals(user) && this.psww.equals(pass);
    }

}

