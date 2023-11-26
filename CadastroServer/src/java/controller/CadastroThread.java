/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import model.Usuario;

/**
 *
 * @author muangala Jr
 */
public class CadastroThread {
    private ProdutoJpaController ctrl;
    private UsuarioJpaController ctrlUsu;
    private Socket s1;

    public CadastroThread(ProdutoJpaController ctrl, UsuarioJpaController ctrlUsu, Socket s1) {
        this.ctrl = ctrl;
        this.ctrlUsu = ctrlUsu;
        this.s1 = s1;
    }

    public void run() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(s1.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(s1.getInputStream());

            // Obtendo login e senha
            String login = (String) input.readObject();
            String senha = (String) input.readObject();

            // Verificar login
            Usuario usuario = ctrlUsu.findUsuario(login, senha);
            if (usuario == null) {
                // Terminar a conexão se o usuário for inválido
                s1.close();
                return;
            }

            // Loop de resposta
            while (true) {
                // Obter o comando do cliente
                String comando = (String) input.readObject();

                if (comando.equals("L")) {
                    // Enviar conjunto de produtos para o cliente
                    output.writeObject(ctrl.findProdutoEntities());
                    output.flush();
                } else {
                    // Outros comandos podem ser implementados aqui, se necessário
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                s1.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
}
