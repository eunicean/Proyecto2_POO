 
    /*
    Universidad del Valle de Guatemala
    Programación orientada a objetos
    Anggelie Velásquez 221181
    for(Usuario user:users){

         if(!user.getNickname().equals(null) && !user.getPassword().equals(null)){

        try{        */
            
public static void Iniciarsesion(String nickname,String password){

          boolean flag = false;
 
         flag = verificarsesion(nickname,password);
            if(flag == true){
                 UsuarioMenuDeEntrada um = new UsuarioMenuDeEntrada();
                 UsuarioMain umain = new UsuarioMain();
                 umain.setLocationRelativeTo(null);
                 um.setLocationRelativeTo(null);
                 um.setVisible(true);
                 umain.setVisible(false);
 
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(null, "la verificacion de inicio de sesion no es autentica.");
            }
 
        }
 
 
    public static boolean verificarSesion(String nickname,String password){
 
        boolean esCierto = false;
 
        String nombre = null, mail = null, telefono = null;
 
        Date fechaDeNacimiento = null;
 
        List<Usuario> users = registrarse(nombre,nickname,password,mail,telefono,fechaDeNacimiento);
 
        for(Usuario user:users){
 
            if(user.getNickname().equals(nickname) && user.getPassword().equals(password)){
                esCierto = true;
                break;
            }
 
        }
 
        return esCierto;
 
    }
 
 
    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {
 
        String u = jTextFieldUser.getText();
 
        String p = jTextFieldPassword.getText();
 
        /* 
        Usuario user = new Usuario();

        user.setNickname(u);
        user.setPassword(p);
        */
 
 
        jTextFieldUser.setText("");
        jTextFieldPassword.setText("");
 
 
        Controlador.iniciarSesion(u, p);
        this.setVisible(false);
    }
 
    public void cargarDatos(Usuario usuario){
        this.jTextFieldUser.setText(usuario.getNickname());
        this.jTextFieldPassword.setText(usuario.getPassword());
    }