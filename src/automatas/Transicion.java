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
class Transicion {
    Estado origen;
    Estado destino;
    Object edge;
    String simbolo;

    Transicion(Estado v1, Estado v2, String name, Object v3) {
        origen=v1;
        destino=v2;
        edge=v3;
        simbolo=name;
    }

    Transicion() {
        origen=null;
        destino=null;
        edge=null;
        simbolo="";
    }
}
