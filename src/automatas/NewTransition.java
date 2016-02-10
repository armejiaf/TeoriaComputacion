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
public class NewTransition {
    NewTransition(Estado v1, Estado v2, char name) {
        Object parent = JFrameGraph.getGraph().getDefaultParent();
        String nombre = String.valueOf(name);
        Object v3=JFrameGraph.getGraph().insertEdge(parent, null, nombre, v1.vertex, v2.vertex,"edgeStyle=segmentEdgeStyle");
        JFrameGraph.dfa.AddTransition(v1,v2,nombre,v3);
    }

    NewTransition(DFA nfaConvertido) {
        for(Transicion transicion:nfaConvertido.transiciones){
            Object parent = JFrameGraph.getGraph().getDefaultParent();
            Object v3=JFrameGraph.getGraph().insertEdge(
                    parent, null, String.valueOf(transicion.simbolo), transicion.origen.vertex, 
                    transicion.destino.vertex,"edgeStyle=segmentEdgeStyle");
            transicion.edge=v3;
        }
    }
}
