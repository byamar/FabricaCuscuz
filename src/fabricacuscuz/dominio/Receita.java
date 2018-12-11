/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz.dominio;

/**
 *
 * @author Beatriz
 */
public class Receita {
    private String nome;
    private String ingredientes;
    private String modopreparo;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getModopreparo() {
        return modopreparo;
    }

    public void setModopreparo(String modopreparo) {
        this.modopreparo = modopreparo;
    }
    
    
}
