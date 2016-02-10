/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.ArrayList;

/**
 *
 * @author Allan Mejia
 */
public class DFA extends Automata {
    
    public DFA(){
        alfabeto=new ArrayList<>();
        estadoInicial=new Estado();
        estados=new ArrayList<>();
        estadosFinales=new ArrayList<>();
        transiciones=new ArrayList<>();
    }
    @Override
    public void AddTransition(Estado v1, Estado v2, String name,Object v3) {
        this.transiciones.add(new Transicion(v1,v2,name,v3));
    }

    @Override
    public void AddEstado(String name,Object vertex) {
        this.estados.add(new Estado(name,vertex));
    }

    @Override
    public boolean EvaluarCadena(String cadena) {
        if(cadena.isEmpty()){
            return estadoInicialEsDeAceptacion();
        }
        char[] evaluar = cadena.toCharArray();
        if(!verificarCadena(evaluar))
            return false;
        
        Estado fin=estadoInicial;
        boolean stay = true;
       
        for(int i=0;i<evaluar.length;i++){
            for(Transicion transicion:transiciones){
                if(transicion.origen.nombreEstado.equals(fin.nombreEstado)&&
                        transicion.simbolo.equals(String.valueOf(evaluar[i]))){
                    fin=transicion.destino;
                    stay = true;
                    break;
                }
                else{
                    stay = false;
                }
            }
        }
        if(!stay){
            return false;
        }
        for(Estado estado:estadosFinales){
            if(estado.nombreEstado.equals(fin.nombreEstado))
                return true;
        }
        return false;
    }
 
    public boolean CheckTransition(Estado v1, char name) {
        return transiciones.stream().noneMatch((transicion) -> (
        transicion.origen.nombreEstado.equals(v1.nombreEstado) &&
        transicion.simbolo.equals(String.valueOf(name))));
    }
    
    public void minimize() {
     
    }
    
    private boolean verificarCadena(char[] evaluar) {
        boolean stay=true;
        for(int i=0;i<evaluar.length;i++){
            for(Character c:alfabeto){
                if(c.equals(evaluar[i])){
                    stay=true;
                    break;
                }else{
                    stay= false;
                }
            }
        }
        return stay;
    }    

    private boolean estadoInicialEsDeAceptacion() {
        return estadosFinales.stream().anyMatch((estado) -> 
                (estado.nombreEstado.equals(estadoInicial.nombreEstado)));
    }
}
