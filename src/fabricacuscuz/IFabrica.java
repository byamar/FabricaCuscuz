/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz;

/**
 *
 * @author Beatriz
 */
public interface IFabrica {
    public abstract void realizarPedido(String nome);
    public abstract void exibirEstoque();
    public abstract void removerProduto(Produto produto);
    
    
    public void atualizarProdutos();
    
    
    
}
