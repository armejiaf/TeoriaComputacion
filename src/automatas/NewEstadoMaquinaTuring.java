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
class NewEstadoMaquinaTuring {

    NewEstadoMaquinaTuring(String name) {
        JFrameGraphMaquinaTuring.getGraph().getModel().beginUpdate();
        Object parent = JFrameGraphMaquinaTuring.getGraph().getDefaultParent();
       
        Object v1 = JFrameGraphMaquinaTuring.getGraph().insertVertex(parent, null, "I"+name, 50,50, 50, 50,
        "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
        JFrameGraphMaquinaTuring.mdt.AddEstado("I"+name,v1);
        JFrameGraphMaquinaTuring.getGraph().getModel().endUpdate();
    }
    
}
