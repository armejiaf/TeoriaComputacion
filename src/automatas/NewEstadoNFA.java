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
public class NewEstadoNFA {
     NewEstadoNFA(String name) {
        JFrameGraphNFA.getGraph().getModel().beginUpdate();
        Object parent = JFrameGraphNFA.getGraph().getDefaultParent();
       
        Object v1 = JFrameGraphNFA.getGraph().insertVertex(parent, null, "I"+name, 50,50, 50, 50,
        "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;fillColor=lightblue");
        JFrameGraphNFA.nfa.AddEstado("I"+name,v1);
        JFrameGraphNFA.getGraph().getModel().endUpdate();
    }

    NewEstadoNFA(NFA nfaeConvertido) {
        int x=50,y=50;
        for(Estado estado:nfaeConvertido.estados){
            JFrameGraphNFA.getGraph().getModel().beginUpdate();
            Object parent = JFrameGraphNFA.getGraph().getDefaultParent();
       
            Object v1 = JFrameGraphNFA.getGraph().insertVertex(parent, null, estado.nombreEstado, x,y, 50, 50,
           "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                   +"fillColor=lightblue");
           JFrameGraphNFA.getGraph().getModel().endUpdate();
           for(Estado e:nfaeConvertido.estadosFinales){
               if(e.nombreEstado.equals(estado.nombreEstado))
                   e.vertex=v1;
           }
           if(nfaeConvertido.estadoInicial.nombreEstado.equals(estado.nombreEstado))
               nfaeConvertido.estadoInicial.vertex=v1;
           estado.vertex=v1;
           x+=50;
           y+=50;
        }
    }
}
