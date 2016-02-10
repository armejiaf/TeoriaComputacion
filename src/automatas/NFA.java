/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Allan Mejia
 */
class NFA extends Automata {
    public NFA(){
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
        
        List<Estado> finales = new ArrayList<>();
        finales.add(estadoInicial);
        finales = terminarDeEvaluarCadena(finales,evaluar,0);
        if(finales.isEmpty()){
            return false;
        }
        for(Estado estado:estadosFinales){
            for(Estado estadoFinal:finales){
                if(estado.nombreEstado.equals(estadoFinal.nombreEstado))
                    return true;
            }
        }
        return false;
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
    
    DFA ConversionADFA() {
        DFA dfa = new DFA();
        dfa.estadoInicial = this.estadoInicial;
        List<Estado> actuales = new ArrayList<>();
        actuales.add(estadoInicial);
        for(Estado estado:estadosFinales){
            if(estado.nombreEstado.equals(estadoInicial.nombreEstado)){
                dfa.estadosFinales.add(estado);
            }
        }
        dfa.estados.add(estadoInicial);
        obtenerEstadosTransicionesDFA(dfa,actuales,0);
        return dfa;
    }

    private List <Estado> terminarDeEvaluarCadena(List<Estado> finales, char[] evaluar, int pos) {
        List <Estado> nuevoFinales;
        nuevoFinales = new ArrayList<>();
        if(pos == evaluar.length)
            return finales; 
        for(Transicion transicion:transiciones){
            for(Estado estado:finales)
                if(transicion.origen.nombreEstado.equals(estado.nombreEstado)&&
                    transicion.simbolo.equals(String.valueOf(evaluar[pos]))){
                    nuevoFinales.add(transicion.destino);
                    break;
                }
        }
        if(nuevoFinales.isEmpty()){
            return nuevoFinales;
        }
        return terminarDeEvaluarCadena(nuevoFinales, evaluar, pos+1);
    }

    private void obtenerEstadosTransicionesDFA(DFA dfa,List<Estado> actuales,int pos) {
        List <Estado> nuevosActuales;
        nuevosActuales = new ArrayList<>();
        if(pos == alfabeto.size())
            return;
        for(Transicion transicion:transiciones){
            for(Estado estado:actuales)
                if(transicion.origen.nombreEstado.equals(estado.nombreEstado)&&
                    transicion.simbolo.equals(String.valueOf(alfabeto.get(pos)))){
                    nuevosActuales.add(transicion.destino);
                    break;
                }
        }
        obtenerEstadosTransicionesDFA(dfa, actuales, pos+1);
        if(!nuevosActuales.isEmpty()){
            if(siEsIgualAlgunEstadoDFA(nuevosActuales, dfa)){
                crearTransicionDFA(nuevosActuales, dfa, actuales, pos);
                return;
            }
                
            Estado nuevoEstado = new Estado();
            nuevoEstado.nombreEstado=nuevosActuales.stream().map((estado) -> estado.nombreEstado).reduce(
                    nuevoEstado.nombreEstado, String::concat);
            dfa.estados.add(nuevoEstado);
            agregarEstadosFinalesDFA(nuevosActuales,dfa);
            crearTransicionDFA(nuevosActuales, dfa, actuales, pos);
            obtenerEstadosTransicionesDFA(dfa, nuevosActuales, 0);
        }
                      
    }

    private void crearTransicionDFA(List<Estado> nuevosActuales, DFA dfa, List<Estado> actuales, int pos) {
        Transicion nuevaTransicion = new Transicion();
        String nombre="";
        nombre=nuevosActuales.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        nuevaTransicion.destino=obtenerEstado(nombre,dfa);
        nombre="";
        nombre=actuales.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        nuevaTransicion.origen=obtenerEstado(nombre,dfa);
        nuevaTransicion.simbolo=String.valueOf(alfabeto.get(pos));
        dfa.transiciones.add(nuevaTransicion);
    }

    private boolean siEsIgualAlgunEstadoDFA(List<Estado> nuevosActuales, DFA dfa) {
        String nombre = "";
        nombre = nuevosActuales.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        for (Estado estado : dfa.estados) {
            if (estado.nombreEstado.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    private Estado obtenerEstado(String nombre,DFA dfa) {
        for(Estado estado:dfa.estados)
        {
            if(estado.nombreEstado.equals(nombre))
            {
                return estado;
               
            }
        }
        return null;
    }

    private void agregarEstadosFinalesDFA(List<Estado> nuevosActuales, DFA dfa) {
        for(Estado estadofin:estadosFinales)
            for(Estado estado:nuevosActuales){
                if(estadofin.nombreEstado.equals(estado.nombreEstado)){
                    String nombre="";
                    nombre=nuevosActuales.stream().map((estadotemp) -> estadotemp.nombreEstado).reduce(
                    nombre, String::concat);
                    Estado v1 = obtenerEstado(nombre, dfa);
                    dfa.estadosFinales.add(v1);
                }
            }
    }
}