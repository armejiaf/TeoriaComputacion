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
class NewEstadoPDA {

    NewEstadoPDA(String name) {
        JFrameGraphPDA.getGraph().getModel().beginUpdate();
        Object parent = JFrameGraphPDA.getGraph().getDefaultParent();
       
        Object v1 = JFrameGraphPDA.getGraph().insertVertex(parent, null, "I"+name, 50,50, 50, 50,
        "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
        JFrameGraphPDA.pda.AddEstado("I"+name,v1);
        JFrameGraphPDA.getGraph().getModel().endUpdate();
    }
    
}
