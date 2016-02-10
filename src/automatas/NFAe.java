/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import java.util.ArrayList;
import java.util.List;
import org.unitec.regularexpresion.RegularExpressionParser;
import org.unitec.regularexpresion.tree.ANDNode;
import org.unitec.regularexpresion.tree.CharNode;
import org.unitec.regularexpresion.tree.Node;
import org.unitec.regularexpresion.tree.ORNode;
import org.unitec.regularexpresion.tree.RepeatNode;

/**
 *
 * @author Allan Mejia
 */
class NFAe extends Automata {
    static int estadoNum =0;
    public NFAe(){
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
    private List <Estado> terminarDeEvaluarCadena(List<Estado> finales, char[] evaluar, int pos) {
        List <Estado> nuevoFinales;
        nuevoFinales = new ArrayList<>();
        finales = Clausura(finales);
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

    private List<Estado> Clausura(List<Estado> finales) {
        List <Estado> nuevoFinales,temporal;
        nuevoFinales = new ArrayList<>();
        temporal = new ArrayList<>();
        for(Transicion transicion:transiciones){
            for(Estado estado:finales)
                if(transicion.origen.nombreEstado.equals(estado.nombreEstado)&&
                    transicion.simbolo.equals("ε")){
                    nuevoFinales.add(transicion.destino);
                    break;
                }
        }
        if(!nuevoFinales.isEmpty())
            temporal = Clausura(nuevoFinales);
        if(!temporal.isEmpty()){
            for(Estado estado:temporal){
                finales.add(estado);
            }
        }
        return finales;
    }

    NFA conversionANFA() {
       NFA nfa = new NFA();
       List<Estado> actuales = new ArrayList<>();
       actuales.add(estadoInicial);
       actuales = Clausura(actuales);
       Estado nuevoEstado = new Estado();
            nuevoEstado.nombreEstado=actuales.stream().map((estado) -> estado.nombreEstado).reduce(
            nuevoEstado.nombreEstado, String::concat);
       nfa.estadoInicial = nuevoEstado;
       nfa.estados.add(nuevoEstado);
       actuales.clear();
       actuales.add(estadoInicial);
       obtenerEstadosTransicionesNFA(nfa,actuales,0);
       return nfa;
    }

    private void obtenerEstadosTransicionesNFA(NFA nfa, List<Estado> actuales, int pos) {
        List <Estado> nuevosActuales;
        List<Estado> nuevosActualesClausura = new ArrayList<>();
        List<Estado> actualesClausura = new ArrayList<>();
        for(Estado estado:actuales)
            actualesClausura.add(estado);
        actualesClausura=Clausura(actualesClausura);
        if(pos == alfabeto.size())
            return;
        nuevosActuales=obtenerEstados(actualesClausura, pos);
        
        if(!nuevosActuales.isEmpty()){
            for(Estado estado:nuevosActuales)
                nuevosActualesClausura.add(estado);
            nuevosActualesClausura=Clausura(nuevosActualesClausura);
           if(!siEsIgualAlgunEstadoNFA(nuevosActualesClausura, nfa))
           {
               Estado nuevoEstado = new Estado();
               nuevoEstado.nombreEstado=nuevosActualesClausura.stream().map((estado) -> estado.nombreEstado).reduce(
               nuevoEstado.nombreEstado, String::concat);
               nfa.estados.add(nuevoEstado);
               agregarEstadosFinalesNFA(nuevosActualesClausura,nfa);
               obtenerEstadosTransicionesNFA(nfa, nuevosActuales ,0);
           }
           if(siEsIgualAlgunEstadoNFA(actualesClausura, nfa)){
               agregarEstadosFinalesNFA(actualesClausura,nfa);
               crearTransicionNFA(nuevosActualesClausura, nfa, actualesClausura, pos);
               obtenerEstadosTransicionesNFA(nfa, actuales, pos+1);
           }   
        }
        
    }

    private List<Estado> obtenerEstados(List<Estado> actuales, int pos) {
        List <Estado> nuevosActuales;
        nuevosActuales = new ArrayList<>();
        for(Transicion transicion:transiciones){
            for(Estado estado:actuales)
                if(transicion.origen.nombreEstado.equals(estado.nombreEstado)&&
                        transicion.simbolo.equals(String.valueOf(alfabeto.get(pos)))){
                    nuevosActuales.add(transicion.destino);
                    break;
                }
        }
        return nuevosActuales;
    }

    private boolean siEsIgualAlgunEstadoNFA(List<Estado> actuales, NFA nfa) {
    String nombre = "";
        nombre = actuales.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        for (Estado estado : nfa.estados) {
            if (estado.nombreEstado.equals(nombre)) {
                return true;
            }
        }
        return false;
    }

    private void crearTransicionNFA(List<Estado> actualesDestino, NFA nfa, List<Estado> actuales, int pos) {
        Transicion nuevaTransicion = new Transicion();
        String nombre="";
        nombre=actualesDestino.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        nuevaTransicion.destino=obtenerEstado(nombre,nfa);
        nombre="";
        nombre=actuales.stream().map((estado) -> estado.nombreEstado).reduce(
                nombre, String::concat);
        nuevaTransicion.origen=obtenerEstado(nombre,nfa);
        nuevaTransicion.simbolo=String.valueOf(alfabeto.get(pos));
        nfa.transiciones.add(nuevaTransicion);
    }

    private void agregarEstadosFinalesNFA(List<Estado> actuales, NFA nfa) {
        for(Estado estadofin:estadosFinales)
            for(Estado estado:actuales){
                if(estadofin.nombreEstado.equals(estado.nombreEstado)){
                    String nombre="";
                    nombre=actuales.stream().map((estadotemp) -> estadotemp.nombreEstado).reduce(
                    nombre, String::concat);
                    Estado v1 = obtenerEstado(nombre, nfa);
                    nfa.estadosFinales.add(v1);
                }
            }
    }

    private Estado obtenerEstado(String nombre, NFA nfa) {
    for(Estado estado:nfa.estados)
        {
            if(estado.nombreEstado.equals(nombre))
            {
                return estado;
               
            }
        }
        return null;
    }

    NFAe conversionDeExpresionRegular(String expresionRegular, NFAe expresionRegularConvertida) {
        try{
            Node rootNode = new RegularExpressionParser().Parse(expresionRegular);
            obtainAutomata(rootNode,expresionRegularConvertida);
        }catch(Exception e){
            return null;
        }
        return expresionRegularConvertida;
    }
    private static void obtainAutomata(Node rootNode, NFAe nfaeList) {
        if(rootNode instanceof CharNode){
            Estado e1 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Estado e2 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Transicion t= new Transicion(e1, e2,((CharNode)rootNode).getValue(), null);
            nfaeList.estadoInicial = e1;
            nfaeList.estadosFinales.add(e2);
            nfaeList.estados.add(e1);
            nfaeList.estados.add(e2);
            nfaeList.transiciones.add(t);
            
        }
        else if (rootNode instanceof ORNode)
        {
            ORNode orNode = (ORNode)rootNode;
            Estado e1 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            nfaeList.estadoInicial = e1;
            nfaeList.estadosFinales.add(e1);
            nfaeList.estados.add(e1);
            obtainAutomata(orNode.getLeftNode(),nfaeList);
            obtainAutomata(orNode.getRightNode(),nfaeList);
            e1 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
           
            nfaeList.estadoInicial = e1;
            nfaeList.estadosFinales.add(e1);
            nfaeList.estados.add(e1);
        }
        else if (rootNode instanceof ANDNode)
        {
            ANDNode andNode = (ANDNode)rootNode;
            obtainAutomata(andNode.getRightNode(),nfaeList);
            obtainAutomata(andNode.getLeftNode(),nfaeList);
        }
        else
        {
            Estado e1 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Estado e2 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Transicion t= new Transicion(e1, e2,"ε", null);
           
            nfaeList.estadoInicial = e1;
            nfaeList.estados.add(e1);
            nfaeList.estados.add(e2);
            nfaeList.transiciones.add(t);
           
            obtainAutomata(((RepeatNode)rootNode).getNode(),nfaeList);
            Estado e3 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Estado e4 = new Estado(String.valueOf(estadoNum),null);
            estadoNum+=1;
            Transicion t1= new Transicion(e3, e4,"ε", null);
            Transicion t2= new Transicion(e3, e2,"ε", null);
            Transicion t3= new Transicion(e1, e4,"ε", null);
            nfaeList = new NFAe();
            nfaeList.estadoInicial = e3;
            nfaeList.estadosFinales.add(e4);
            nfaeList.estados.add(e3);
            nfaeList.estados.add(e4);
            nfaeList.transiciones.add(t1);
            nfaeList.transiciones.add(t2);
            nfaeList.transiciones.add(t3);           
        }

    }
}
