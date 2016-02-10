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
class NewTransitionMaquinaTuring {

    NewTransitionMaquinaTuring(Estado v1, Estado v2, String name) {
        Object parent = JFrameGraphMaquinaTuring.getGraph().getDefaultParent();
        Object v3=JFrameGraphMaquinaTuring.getGraph().insertEdge(parent, null, name, v1.vertex, v2.vertex,"edgeStyle=segmentEdgeStyle");
        JFrameGraphMaquinaTuring.mdt.AddTransition(v1,v2,name,v3);
    }
    
}
