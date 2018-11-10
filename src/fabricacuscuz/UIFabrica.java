/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Beatriz
 */
public class UIFabrica  {
  private ArrayList<Produto> produtos = new ArrayList();
    Fabrica fabrica = new Fabrica();
    private Scanner scanner = new Scanner(System.in);
    
    public void realizarPedido() {
        Produto produto = new Produto();
        System.out.println("Nome do produto: ");
        String nome = scanner.nextLine();
        produto.setNome(nome);
        System.out.println("quantidade: ");
        String quantidade = scanner.nextLine();
        produto.setQuantidade(quantidade);
        
     
            }
    
    public void exibirEstoque() {
        fabrica.exibirEstoque();
    }
    
    public void removerProduto(Produto produto) {
        fabrica.removerProduto(produto);
        
    }
    
    public void cadastrarProduto() {
        Produto produto = new Produto();
        
        String nome = JOptionPane.showInputDialog("Nome: ");
        produto.setNome(nome);
        
        String descricao = JOptionPane.showInputDialog("Descrição: ");
        produto.setDescricao(descricao);
        String preco = JOptionPane.showInputDialog("Preço: ");
        produto.setPreco(preco);
      
        String quantidade = JOptionPane.showInputDialog("Quantidade: ");
        produto.setQuantidade(quantidade);
        fabrica.adicionarProduto(produto);
        
    }
    
    public String listarProduto() {
        return fabrica.listarProdutos();
        
    }
    
    public void atualizarProdutos() {
        
    }
    
}
