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
class NewTransitionPDA {

    NewTransitionPDA(Estado v1, Estado v2, String name) {
        Object parent = JFrameGraphPDA.getGraph().getDefaultParent();
        Object v3=JFrameGraphPDA.getGraph().insertEdge(parent, null, name, v1.vertex, v2.vertex,"edgeStyle=segmentEdgeStyle");
        JFrameGraphPDA.pda.AddTransition(v1,v2,name,v3);
    }
    
}
