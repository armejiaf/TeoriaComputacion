/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

/**
 *
 * @author Allan Mejia
 */
class Estado {
    String nombreEstado;
    Object vertex;

    Estado(String name, Object vertex) {
        nombreEstado=name;
        this.vertex=vertex;//To change body of generated methods, choose Tools | Templates.
    }

    Estado() {
        nombreEstado="";
        vertex=null;
    }
}
