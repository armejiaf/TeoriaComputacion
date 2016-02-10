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
public class NewEstadoNFAe {
    NewEstadoNFAe(String name) {
        JFrameGraphNFAe.getGraph().getModel().beginUpdate();
        Object parent = JFrameGraphNFAe.getGraph().getDefaultParent();
       
        Object v1 = JFrameGraphNFAe.getGraph().insertVertex(parent, null, "I"+name, 50,50, 50, 50,
        "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;fillColor=lightblue");
        JFrameGraphNFAe.nfae.AddEstado("I"+name,v1);
        JFrameGraphNFAe.getGraph().getModel().endUpdate();
    }
}
