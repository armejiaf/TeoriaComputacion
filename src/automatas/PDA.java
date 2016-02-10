/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Allan Mejia
 */
class PDA extends Automata{
    String simboloInicial;
    String simboloActualDePila;
    Stack <String> stack;
    public PDA(){
        alfabeto=new ArrayList<>();
        estadoInicial=new Estado();
        estados=new ArrayList<>();
        estadosFinales=new ArrayList<>();
        transiciones=new ArrayList<>();
        simboloActualDePila =  "";
        stack = new Stack<>();
    }
    @Override
    public void AddTransition(Estado v1, Estado v2, String name, Object v3) {
        this.transiciones.add(new Transicion(v1,v2,name,v3));
    }

    @Override
    public void AddEstado(String name, Object vertex) {
       this.estados.add(new Estado(name,vertex));
    }

    @Override
    public boolean EvaluarCadena(String cadena) {
        char[] evaluar = cadena.toCharArray();
        if(!cadena.isEmpty()){
            if(!verificarCadena(evaluar))
                return false;
        }
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

    private List<Estado> terminarDeEvaluarCadena(List<Estado> finales, char[] evaluar, int pos) {
        List <Estado> nuevoFinales;
        nuevoFinales = new ArrayList<>();
        finales = ClausuraPDA(finales);
        if(pos == evaluar.length)
            return finales; 
        for(Transicion transicion:transiciones){
            for(Estado estado:finales){
                String [] t = transicion.simbolo.split(",");
                if(t[0].equals(String.valueOf(evaluar[pos])) && t[1].equals(simboloActualDePila) 
                        && transicion.origen.nombreEstado.equals(estado.nombreEstado)){
                    stack.pop();
                    if(t[2].contains(simboloInicial)){
                        String sub = t[2].replace(simboloInicial, "");
                        stack.push(simboloInicial);
                        if(!sub.isEmpty())
                            for(int j = sub.length()-1 ; j >= 0 ; j-- ){
                                stack.push(String.valueOf(sub.charAt(j)));
                            }                        
                        nuevoFinales.add(transicion.destino);
                    }else{
                        if(!t[2].equals("ε")){
                            for(int j = t[2].length()-1 ; j >= 0 ; j-- ){
                                stack.push(String.valueOf(t[2].charAt(j)));
                            }
                        }   
                        nuevoFinales.add(transicion.destino);
                    }
                }
            }
            simboloActualDePila = stack.pop();
            stack.push(simboloActualDePila);
        }
        return terminarDeEvaluarCadena(nuevoFinales, evaluar, pos+1);
    }

    private List<Estado> ClausuraPDA(List<Estado> finales) {
    List <Estado> nuevoFinales,temporal;
        nuevoFinales = new ArrayList<>();
        temporal = new ArrayList<>();
        for(Transicion transicion:transiciones){
            for(Estado estado:finales){
                String [] t = transicion.simbolo.split(",");
                if(t[0].equals("ε") && t[1].equals(simboloActualDePila)
                   && transicion.origen.nombreEstado.equals(estado.nombreEstado)){
                    stack.pop();
                    if(t[2].contains(simboloInicial)){
                        String sub = t[2].replace(simboloInicial, "");
                        stack.push(simboloInicial);
                        if(!sub.isEmpty()){
                            for(int j = sub.length()-1 ; j >= 0 ; j-- ){
                                stack.push(String.valueOf(sub.charAt(j)));
                            }
                            simboloActualDePila=String.valueOf(sub.charAt(0));
                        }else{
                            simboloActualDePila=stack.pop();
                            stack.push(simboloActualDePila);
                        }
                        nuevoFinales.add(transicion.destino);
                    }else{
                        if(!t[2].equals("ε")){
                            for(int j = t[2].length()-1 ; j >= 0 ; j-- ){
                                stack.push(String.valueOf(t[2].charAt(j)));
                            }
                            simboloActualDePila=String.valueOf(t[2].charAt(0));
                        }else{
                            simboloActualDePila=stack.pop();
                            stack.push(simboloActualDePila);
                        }   
                        nuevoFinales.add(transicion.destino);
                    }
                }
            }
        }
        if(!nuevoFinales.isEmpty())
            temporal = ClausuraPDA(nuevoFinales);
        if(!temporal.isEmpty()){
            for(Estado estado:temporal){
                finales.add(estado);
            }
        }
        return finales;
    }
}
