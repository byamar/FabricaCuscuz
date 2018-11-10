/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz;

import java.util.ArrayList;

/**
 *
 * @author Beatriz
 */
public class Fabrica {
   private ArrayList<Produto> produtos = new ArrayList();

    public Fabrica() {
    }
   
   

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
  
  
   
   public String listarProdutos(){
       String lista = "";
       for( Produto produto : produtos){
          
               lista+= produto.getNome();
           
       }
       return lista;
       
       
   }
   
   public void atualizarProdutos(){
       
       
   }
   public int exibirEstoque(){
       int estoque = 0;
       for(Produto produto : produtos){
           estoque = produtos.size();
       }
       return estoque;
   }
   public void adicionarProduto(Produto produto){
       produtos.add(produto);
   }
   public void removerProduto(Produto produto){
     produtos.remove(produto);
           
       }
}
           
       
      
   
   
    

