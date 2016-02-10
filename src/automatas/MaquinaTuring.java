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
public class MaquinaTuring extends Automata{
    List<String> cinta;
    int posicionActualCinta;
    
    public MaquinaTuring(){
        alfabeto=new ArrayList<>();
        estadoInicial=new Estado();
        estados=new ArrayList<>();
        estadosFinales=new ArrayList<>();
        transiciones=new ArrayList<>(); 
        posicionActualCinta =5;
        cinta=new ArrayList<>();
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
        finales = terminarDeEvaluarCadena(finales);
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

    private List<Estado> terminarDeEvaluarCadena(List<Estado> finales) {
        List <Estado> nuevosFinales;
        nuevosFinales = new ArrayList<>();
        for(Transicion transicion:transiciones){
            String t[]=transicion.simbolo.split(",");
            for(Estado estado:finales)
                if(transicion.origen.nombreEstado.equals(estado.nombreEstado) 
                    && t[0].equals(cinta.get(posicionActualCinta))){
                    cinta.set(posicionActualCinta, t[1]);
                    if(t[2].equals("R"))
                        posicionActualCinta+=1;
                    else
                        posicionActualCinta-=1;
                    nuevosFinales.add(transicion.destino);
                    break;
                }
            if(!nuevosFinales.isEmpty())
                break;
        }
        if(nuevosFinales.isEmpty())
            return finales;
        return terminarDeEvaluarCadena(nuevosFinales);
        
    }
    
}
