/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabricacuscuz.dominio;

import java.util.Date;

/**
 *
 * @author Beatriz
 */
public class Compra {
    private int id;
    private Date dataCompra;
    private int diasPrazoEntrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getDiasPrazoEntrega() {
        return diasPrazoEntrega;
    }

    public void setDiasPrazoEntrega(int diasPrazoEntrega) {
        this.diasPrazoEntrega = diasPrazoEntrega;
    }
    
    
}

