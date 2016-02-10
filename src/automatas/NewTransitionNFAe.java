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
public class NewTransitionNFAe {
    NewTransitionNFAe(Estado v1, Estado v2, char name) {
        Object parent = JFrameGraphNFAe.getGraph().getDefaultParent();
        String nombre = String.valueOf(name);
        Object v3=JFrameGraphNFAe.getGraph().insertEdge(parent, null, nombre, v1.vertex, v2.vertex,"edgeStyle=segmentEdgeStyle");
        JFrameGraphNFAe.nfae.AddTransition(v1,v2,nombre,v3);
    }
}
