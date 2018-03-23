/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavha.ams.app.logica;

import com.mavha.ams.app.modelo.Pedido;
import com.mavha.ams.app.modelo.PedidoDetalle;
import com.mavha.ams.app.modelo.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marti
 */
@Stateless
public class InicializarEJB {
    @PersistenceContext(unitName = "VENTAS_PU")
    private EntityManager em;
    
    public void init(){
        List<Producto> productos = new ArrayList<>();
        Random r = new Random();
        for(int i=0;i<100;i++){
            Producto prd = new Producto();
            prd.setNombre(" Producto "+ i+1001);
            prd.setPrecio(r.nextDouble()*1000);
            em.persist(prd);
            productos.add(prd);
        }
        
        for(int j=0;j<=500;j++){
            Pedido ped = new Pedido();
            ped.setFecha(new Date());
            em.persist(ped);
            Integer items = 1+r.nextInt(5);
            for(int k=0;k<=items;k++){
                PedidoDetalle pd = new PedidoDetalle();
                Integer cantidad = r.nextInt(4);
                pd.setCantidad(cantidad);
                Producto p = productos.get(r.nextInt(productos.size()));
                pd.setPrecioFinal(p.getPrecio()*cantidad);
                pd.setPedido(ped);
                pd.setProducto(p);
                em.persist(pd);
            }
        }
    }

}
