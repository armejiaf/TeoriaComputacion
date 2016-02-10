/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.List;

/**
 *
 * @author Allan Mejia
 */
public abstract class Automata {
    List <Character> alfabeto;
    List <Estado> estados;
    List <Estado> estadosFinales;
    Estado estadoInicial;
    List <Transicion> transiciones;
    public abstract void AddTransition(Estado v1, Estado v2, String name,Object v3);
    public abstract void AddEstado(String name,Object vertex);
    public abstract boolean EvaluarCadena(String cadena);
}
