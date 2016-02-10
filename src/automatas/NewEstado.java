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
public class NewEstado{
    NewEstado(String name) {
        JFrameGraph.getGraph().getModel().beginUpdate();
        Object parent = JFrameGraph.getGraph().getDefaultParent();
       
        Object v1 = JFrameGraph.getGraph().insertVertex(parent, null, "I"+name, 50,50, 50, 50,
        "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
        JFrameGraph.dfa.AddEstado("I"+name,v1);
        JFrameGraph.getGraph().getModel().endUpdate();
    }

    NewEstado(DFA nfaConvertido) {
        int x=50,y=50;
        for(Estado estado:nfaConvertido.estados){
            JFrameGraph.getGraph().getModel().beginUpdate();
            Object parent = JFrameGraph.getGraph().getDefaultParent();
       
            Object v1 = JFrameGraph.getGraph().insertVertex(parent, null, estado.nombreEstado, x,y, 50, 50,
           "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                   +"fillColor=lightblue");
           JFrameGraph.getGraph().getModel().endUpdate();
           for(Estado e:nfaConvertido.estadosFinales){
               if(e.nombreEstado.equals(estado.nombreEstado))
                   e.vertex=v1;
           }
           if(nfaConvertido.estadoInicial.nombreEstado.equals(estado.nombreEstado))
               nfaConvertido.estadoInicial.vertex=v1;
           estado.vertex=v1;
           x+=50;
           y+=50;
        }
    }
}
