/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroCliet;

import controller.ProdutoJpaController;
import controller.UsuarioJpaController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import model.Produto;

/**
 *
 * @author muangala Jr
 */
public class CadastroCliente {
      public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 4321);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            // Enviar login e senha
            output.writeObject("op1");
            output.writeObject("op1");

            // Enviar comando 'L' para obter a lista de produtos
            output.writeObject("L");
            output.flush();

            // Receber lista de produtos
            List<Produto> produtos = (List<Produto>) input.readObject();

            // Exibir os produtos recebidos
            for (Produto produto : produtos) {
                System.out.println(produto.getNome());
            }

            // Fechar conexão
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
