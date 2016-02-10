/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatas;

import com.mxgraph.model.mxCell;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.view.mxGraph;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Allan Mejia
 */
public class JFrameGraphPDA extends javax.swing.JFrame {
    private javax.swing.JButton jButtonProbarAutomata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuFile;
    private javax.swing.JMenuItem jMenuItemClose;
    private javax.swing.JMenuItem jMenuItemNewState;
    private javax.swing.JMenuItem jMenuItemNewTransition;
    private javax.swing.JMenuItem jMenuItemDeleteState;
    private javax.swing.JMenuItem jMenuItemCreateInitialState;
    private javax.swing.JMenuItem jMenuItemCreateAcceptanceState;
    private javax.swing.JMenuItem jMenuItemChangeInitialState;
    private javax.swing.JMenuItem jMenuItemDeleteTransition;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem jMenuItemOpen;
    private javax.swing.JMenuItem jMenuItemSaveAs;
    private javax.swing.JMenuItem jMenuItemAddEstado;
    private javax.swing.JMenuItem jMenuItemCrearEstadoInicial;
    private javax.swing.JMenuItem jMenuItemCrearEstadoAceptacion;
    private javax.swing.JMenuItem jMenuItemCambiarEstadoInicial;
    private javax.swing.JMenuItem jMenuItemAddTransition;
    private javax.swing.JMenuItem jMenuItemDeleteEstado;
    private javax.swing.JMenuItem jMenuItemDeleteTransicion;
    private javax.swing.JMenu jMenuOptions;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldAlfabeto;
    private javax.swing.JTextField jTextFieldCadena;
    private javax.swing.JTextField jTextFieldSimboloDePila;
    private javax.swing.JTextField jTextFieldSimboloEspecial;
    private javax.swing.JPopupMenu jPopupMenuForm;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    protected static mxGraph graph = new mxGraph();
    private mxGraphComponent graphComponent;
    protected int valor = 0;
    protected static PDA pda;
    
    public JFrameGraphPDA() {
        initComponents();
        pda=new PDA();
    }
    
    public static mxGraph getGraph() {
		return graph;
    }
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldAlfabeto = new javax.swing.JTextField();
        jTextFieldCadena = new javax.swing.JTextField();
        jTextFieldSimboloDePila = new javax.swing.JTextField();
        jTextFieldSimboloEspecial = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonProbarAutomata = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuFile = new javax.swing.JMenu();
        jMenuItemOpen = new javax.swing.JMenuItem();
        jMenuItemSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemClose = new javax.swing.JMenuItem();
        jMenuOptions = new javax.swing.JMenu();
        jMenuItemNewState = new javax.swing.JMenuItem();
        jMenuItemNewTransition = new javax.swing.JMenuItem();
        jMenuItemDeleteState = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jPopupMenuForm = new javax.swing.JPopupMenu();
        jMenuItemAddEstado = new javax.swing.JMenuItem();
        jMenuItemAddTransition = new javax.swing.JMenuItem();
        jMenuItemDeleteEstado = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCrearEstadoInicial = new javax.swing.JMenuItem();
        jMenuItemCrearEstadoAceptacion = new javax.swing.JMenuItem();
        jMenuItemCreateInitialState = new javax.swing.JMenuItem();
        jMenuItemCreateAcceptanceState = new javax.swing.JMenuItem();
        jMenuItemChangeInitialState = new javax.swing.JMenuItem();
        jMenuItemCambiarEstadoInicial = new javax.swing.JMenuItem();
        jMenuItemDeleteTransicion = new javax.swing.JMenuItem();
        jMenuItemDeleteTransition = new javax.swing.JMenuItem();
        
        
        jMenuItemAddEstado.setText("Agregar Estado");
        jMenuItemAddEstado.addActionListener((ActionEvent e) -> {
            agregarEstado(e);
        });
        jPopupMenuForm.add(jMenuItemAddEstado);
        jPopupMenuForm.add(jSeparator4);
        
        jMenuItemAddTransition.setText("Agregar Transicion");
        jMenuItemAddTransition.addActionListener((ActionEvent e) -> {
                agregarTrasicion(e);
        });
        jPopupMenuForm.add(jMenuItemAddTransition);
        jPopupMenuForm.add(jSeparator2);

        jMenuItemDeleteEstado.setText("Eliminar Estado");
        jMenuItemDeleteEstado.addActionListener((ActionEvent e) -> {
                eliminarEstado(e);
        });
        jPopupMenuForm.add(jMenuItemDeleteEstado);
        jPopupMenuForm.add(jSeparator5);
        
        jMenuItemDeleteTransicion.setText("Eliminar Transicion");
        jMenuItemDeleteTransicion.addActionListener((ActionEvent e) -> {
                eliminarTransicion(e);
        });
        jPopupMenuForm.add(jMenuItemDeleteTransicion);
        jPopupMenuForm.add(jSeparator9);
        
        jMenuItemCrearEstadoInicial.setText("Crear Estado Inicial");
        jMenuItemCrearEstadoInicial.addActionListener((ActionEvent e) -> {
                crearEstadoInicial(e);
        });
        jPopupMenuForm.add(jMenuItemCrearEstadoInicial);
        jPopupMenuForm.add(jSeparator7);
        
        jMenuItemCrearEstadoAceptacion.setText("Crear Estado de Aceptacion");
        jMenuItemCrearEstadoAceptacion.addActionListener((ActionEvent e) -> {
                agregarEstadoDeAceptacion(e);
        });
        jPopupMenuForm.add(jMenuItemCrearEstadoAceptacion);
       
        jSeparator8.setVisible(false);
        jPopupMenuForm.add(jSeparator8);
       
        jMenuItemCambiarEstadoInicial.setText("Cambiar Estado Inicial");
        jMenuItemCambiarEstadoInicial.addActionListener((ActionEvent e) -> {
                cambiarEstadoInicial(e);
        });
        jMenuItemCambiarEstadoInicial.setVisible(false);
        jPopupMenuForm.add(jMenuItemCambiarEstadoInicial);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PDA");
        getContentPane().setBackground(Color.WHITE);
        
        graph = new mxGraph();
        graph.setAllowLoops(true);
        graph.setDisconnectOnMove(false);
        graph.setConnectableEdges(false);
        graph.setEdgeLabelsMovable(false);
        graphComponent = new mxGraphComponent(graph);
        graphComponent.getViewport().setBackground(Color.WHITE);
        graphComponent.getConnectionHandler().addListener(mxEvent.CONNECT, (Object sender, mxEventObject evt) -> {
            mxCell edge =(mxCell)evt.getProperty("cell");
            mxCell origen = (mxCell) edge.getSource();
            mxCell destino = (mxCell) edge.getTarget();
            Estado v1 = obtenerEstado(origen);
            Estado v2 = obtenerEstado(destino);
            if(v2 == null){
                graph.getModel().remove(evt.getProperty("cell"));
                return;
            }
            String nombre = escogerTransicion();
            if(nombre.isEmpty()){
                graph.getModel().remove(evt.getProperty("cell"));
                return;
            }
            
         
            edge.setValue(nombre);
            pda.AddTransition(v1,v2,nombre,edge);
        });
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter(){
            @Override
             public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
                {
                    jPopupMenuForm.show(getContentPane(),e.getX(),e.getY());
                }
             }
            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                if(e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1){
                    long x = e.getX();
                    long y = e.getY();
                    graph.getModel().beginUpdate();    
                    try {
                        Object parent = graph.getDefaultParent();
                        String name = String.valueOf(valor++);
                        Object v1 = graph.insertVertex(parent, null, "I"+name,x, y, 50, 50,
                                "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
                        
                        pda.AddEstado("I"+name,v1);
                    } finally {
                        graph.getModel().endUpdate();
                    }
                }  
            }
        });
        
        
        jLabel1.setText("Alfabeto");

        jLabel2.setText("Cadena");
        
        jLabel4.setText("TIP: No olvidar agregar todo el alfabeto. Es posible que no acepte cadena!");
        jLabel3.setText("PROTIP: Doble-Click para agregar Estado!");
        jLabel6.setText("TIP: Si desea no agregar nada a la pila o consumir nada de la entrada utilize este simbolo:");

        jTextFieldSimboloEspecial.setEditable(false);
        jTextFieldSimboloEspecial.setText("ε");
      
        
        jLabel5.setText("Simbolo inicial de Pila");
        
        jButtonProbarAutomata.setText("Probar");
        jButtonProbarAutomata.addActionListener((ActionEvent e) -> {
                probarCadenaEnAutomata(e);
        });
        jButtonProbarAutomata.setBackground(Color.WHITE);
        jMenuFile.setText("Archivo");

        jMenuItemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemOpen.setText("Abrir");
        
        jMenuFile.add(jMenuItemOpen);

        jMenuItemSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSaveAs.setText("Guardar como..");
       
        jMenuFile.add(jMenuItemSaveAs);
        jMenuFile.add(jSeparator1);

        jMenuItemClose.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemClose.setText("Cerrar");
        jMenuItemClose.addActionListener((java.awt.event.ActionEvent evt) -> {
            cerrarVentana(evt);
        });
        jMenuFile.add(jMenuItemClose);

        jMenuBar.add(jMenuFile);

        jMenuOptions.setText("Opciones");

        jMenuItemNewState.setText("Agregar Estado");
        jMenuItemNewState.addActionListener((ActionEvent e) -> {
            agregarEstado(e);
        });
        jMenuOptions.add(jMenuItemNewState);

        jMenuItemNewTransition.setText("Agregar Transicion");
        jMenuItemNewTransition.addActionListener((ActionEvent e) -> {
                agregarTrasicion(e);
        });
        jMenuOptions.add(jMenuItemNewTransition);
        jMenuOptions.add(jSeparator3);
        
        jMenuItemDeleteState.setText("Eliminar Estado");
        jMenuItemDeleteState.addActionListener((ActionEvent e) -> {
                eliminarEstado(e);
        });
        jMenuOptions.add(jMenuItemDeleteState);
        
        jMenuItemDeleteTransition.setText("Eliminar Transicion");
        jMenuItemDeleteTransition.addActionListener((ActionEvent e) -> {
                eliminarTransicion(e);
        });
        jMenuOptions.add(jMenuItemDeleteTransition);
        jMenuOptions.add(jSeparator6);
        
        jMenuItemCreateInitialState.setText("Crear Estado Inicial");
        jMenuItemCreateInitialState.addActionListener((ActionEvent e) -> {
                crearEstadoInicial(e);
        });
        jMenuOptions.add(jMenuItemCreateInitialState);
        
        jMenuItemCreateAcceptanceState.setText("Crear Estado de Aceptacion");
        jMenuItemCreateAcceptanceState.addActionListener((ActionEvent e) -> {
                agregarEstadoDeAceptacion(e);
        });
        jMenuOptions.add(jMenuItemCreateAcceptanceState);
        
        jMenuItemChangeInitialState.setText("Cambiar Estado Inicial");
        jMenuItemChangeInitialState.addActionListener((ActionEvent e) -> {
                cambiarEstadoInicial(e);
        });
        jMenuItemChangeInitialState.setVisible(false);
        jMenuOptions.add(jMenuItemChangeInitialState);
        
        jMenuBar.add(jMenuOptions);       
        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldCadena, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldSimboloDePila, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)   
                .addComponent(jButtonProbarAutomata)
                .addContainerGap(26, Short.MAX_VALUE)).addComponent(jLabel4).
                    addComponent(jLabel6)
                    .addGap(18, 18, 18)
                    .addComponent(jTextFieldSimboloEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
            .addComponent(graphComponent, 500, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );  
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCadena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldSimboloDePila, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jButtonProbarAutomata))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldSimboloEspecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                .addComponent(graphComponent, 500, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );


    }
    
    private void cerrarVentana(java.awt.event.ActionEvent evt) {                                               
       new JFormToCallAutomata().setVisible(true);
       this.setVisible(false);
       this.dispose();
    }        
    private void agregarEstado(java.awt.event.ActionEvent evt) {                                                
       String name = String.valueOf(valor++);
       NewEstadoPDA add = new NewEstadoPDA(name);
    }
    private void crearEstadoInicial(ActionEvent e) {
        if(prologoEstado())
            return;
        String name =JOptionPane.showInputDialog("Digite nombre de Estado Inicial:");
        if(name==null || name.isEmpty()){
            showMessage("No se creo Estado Inicial!");
            return;
        }
        Estado v1 = obtenerEstado(name);
        if(v1==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        crearEstadoInicial(v1);
    }

    private void crearEstadoInicial(Estado v1) {
        graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                +"fillColor=lightgreen");
        pda.estadoInicial=v1;
        jMenuItemCrearEstadoInicial.setVisible(false);
        jMenuItemCreateInitialState.setVisible(false);
        jSeparator7.setVisible(false);
        jSeparator8.setVisible(true);
        jMenuItemCambiarEstadoInicial.setVisible(true);
        jMenuItemChangeInitialState.setVisible(true);
    }
    private void showMessage(String msg){
        JOptionPane.showMessageDialog(getContentPane(), msg, "Warning",
            JOptionPane.WARNING_MESSAGE);
    }
    private void agregarTrasicion(java.awt.event.ActionEvent evt) {                                                
        if(prologoEstado())
            return;
        String name =JOptionPane.showInputDialog("Digite nombre de Estado partida:");
        
        if(name==null || name.isEmpty()){
            showMessage("No se agrego nada!!");
            return;
        }
        Estado v1 = obtenerEstado(name);
        if(v1==null){
            showMessage("No existe etado con ese nombre!");
            return;
        }
        name =JOptionPane.showInputDialog("Digite nombre de Estado destino:");
        if(name==null || name.isEmpty()){
            showMessage("No se agrego nada!!");
            return;
        }
        Estado v2 = obtenerEstado(name);
        if(v2==null){
            showMessage("No existe etado con ese nombre!");
            return;
        }
        String nombre = escogerTransicion();
        if(nombre.isEmpty()){
            return;
        }
        NewTransitionPDA add= new NewTransitionPDA(v1,v2,nombre);
    }
     

    private void cambiarEstadoInicial(ActionEvent e) {
        String name =JOptionPane.showInputDialog("Digite nuevo nombre de Estado Inicial:");
        if(name==null || name.isEmpty()){
            showMessage("No se cambio Estado Inicial!");
            return;
        }
        Estado v1 = pda.estadoInicial;
        Estado v2=obtenerEstado(name);
        if(v2==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        if(revisarModeloDeAcuerdoAEstadosFinales(v1, v2)){
            return;
        }
        cambiarEstadoInicial(v1, v2);
    }

    private void cambiarEstadoInicial(Estado v1, Estado v2) {
        graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                +"fillColor=lightblue");
        graph.getModel().setStyle(v2.vertex, "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                +"fillColor=lightgreen");
        pda.estadoInicial=v2;
    }

    private boolean revisarModeloDeAcuerdoAEstadosFinales(Estado v1, Estado v2) {
        Estado final1=null,final2=null;
        
        for(Estado estado:pda.estadosFinales){
            if(estado.nombreEstado.equals(v1.nombreEstado)){
                final1=estado;
            }
            if(estado.nombreEstado.equals(v2.nombreEstado)){
                final2=estado;
            }
        }
        if(final1!=null && final2!=null){
            graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
            graph.getModel().setStyle(v2.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                                +"fillColor=lightgreen");
            pda.estadoInicial=v2;
            return true;
        }
        if(final1!=null && final2==null){
            graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
            graph.getModel().setStyle(v2.vertex, "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightgreen");
            pda.estadoInicial=v2;
            return true;
        }
        if(final1==null && final2!=null){
            graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=ellipse;whiteSpace=wrap;"
                                +"fillColor=lightblue");
            graph.getModel().setStyle(v2.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                                +"fillColor=lightgreen");
            pda.estadoInicial=v2;
            return true;
        }
        return false;
    }

    private void eliminarEstado(ActionEvent e) {
        if(prologoEstado())
            return;
        String name =JOptionPane.showInputDialog("Digite nombre de Estado a borrar:");
        if(name==null || name.isEmpty()){
            showMessage("No se borro nada!");
            return;
        }
        Estado v1 = estadoAEliminar(name);
        if(v1==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        eliminarSiEsEstadoFinal(v1);
        eliminarTransiciones(v1);        
        eliminarEstado(v1);
    }

    private void eliminarEstado(Estado v1) {
        if(pda.estadoInicial.nombreEstado.equals(v1.nombreEstado)){
            pda.estadoInicial=new Estado();
        }
        graph.getModel().remove(v1.vertex);
    }

    private Estado estadoAEliminar(String name) {
        for(Estado estado:pda.estados)
        {
            if(estado.nombreEstado.equals(name))
            {
                Estado v1 = estado;
                pda.estados.remove(estado);
                return v1;
            }
        }
        return null;
    }
    private void eliminarSiEsEstadoFinal(Estado v){
        for(Estado estado:pda.estadosFinales)
        {
            if(estado.nombreEstado.equals(v.nombreEstado))
            {
                pda.estadosFinales.remove(estado);
                break;
            }
        }
    }
    private void eliminarTransiciones(Estado v){
        Collection<Transicion> eliminarTransiciones=new ArrayList<>();
        pda.transiciones.stream().filter((transicion) -> (transicion.origen.nombreEstado.equals(v.nombreEstado) || 
                transicion.destino.nombreEstado.equals(v.nombreEstado))).forEach((transicion) -> {
            eliminarTransiciones.add(transicion);
        });
        pda.transiciones.removeAll(eliminarTransiciones);
    }

    private void agregarEstadoDeAceptacion(ActionEvent e) {
        if(prologoEstado())
            return;
        String name =JOptionPane.showInputDialog("Digite nombre de Estado de Aceptacion:");
        if(name==null || name.isEmpty()){
            showMessage("No se creo Estado de Aceptacion!");
            return;
        }
        if (verificarSiYaEsEstadoAceptacion(name)) {
            return;
        }
        Estado v1 = obtenerEstado(name);
        if(v1==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        if(siEsEstadoInicial(v1))
            return;
        convertirAEstadoFinal(v1);
    }

    private void convertirAEstadoFinal(Estado v1) {
        graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                +"fillColor=lightblue");
        pda.estadosFinales.add(v1);
    }

    private boolean siEsEstadoInicial(Estado v1) {
        if (v1.nombreEstado.equals(pda.estadoInicial.nombreEstado)) {
            graph.getModel().setStyle(v1.vertex, "resizable=0;editable=0;shape=doubleEllipse;whiteSpace=wrap;"
                    +"fillColor=lightgreen");
            pda.estadosFinales.add(v1);
            return true;
        }
        return false;
    }

    private boolean verificarSiYaEsEstadoAceptacion(String name) {
        for (Estado estado : pda.estadosFinales) {
            if (estado.nombreEstado.equals(name)) {
                showMessage("Ya es un estado de Aceptaciion!");
                return true;
            }
        }
        return false;
    }

    private boolean prologoEstado() {
        if (pda.estados.isEmpty()) {
            showMessage("No hay estados!");
            return true;
        }
        return false;
    }

    private void eliminarTransicion(ActionEvent e) {
        if(prologoTransicion())
            return;
        String name =JOptionPane.showInputDialog("Digite nombre de Estado de Origen de la Transicion:");
        if(name==null || name.isEmpty()){
            showMessage("No se borro nada!");
            return;
        }
        Estado v1 = obtenerEstado(name);
        if(v1==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        name =JOptionPane.showInputDialog("Digite nombre de Estado de Destino de la Transicion:");
        if(name==null || name.isEmpty()){
            showMessage("No se borro nada!");
            return;
        }
        Estado v2 = obtenerEstado(name);
        if(v2==null){
            showMessage("No hay estados con ese nombre!");
            return;
        }
        String nombre=escogerTransicion();
        if(nombre.isEmpty()){
            showMessage("No se borro nada!");
            return;
        }
        Transicion t1=obtenerTransicionAEliminar(v1, v2, nombre);
        eliminarTransicion(t1);
    }

    private void eliminarTransicion(Transicion t1) {
        if (t1==null) {
            showMessage("No se enontro Transicion con ese valor!");
            return;
        }
        graph.getModel().remove(t1.edge);
    }

    private Transicion obtenerTransicionAEliminar(Estado v1, Estado v2, String nombre) {
        for(Transicion transicion:pda.transiciones){
            if(transicion.origen.nombreEstado.equals(v1.nombreEstado)&&
                    transicion.destino.nombreEstado.equals(v2.nombreEstado)&&
                    transicion.simbolo.equals(nombre)){
                Transicion t1=transicion;
                pda.transiciones.remove(transicion);
                return t1;
            }
        }
        return null;
    }

    private String escogerTransicion(){
        String nombre = "";
        while(true){
            String name = JOptionPane.showInputDialog("Digite nombre de Transicion:");
            if(name==null || name.isEmpty()){
                showMessage("No se ingreso nada!!");
                break;
            }
            String[] na = name.split(",");
            if(na.length!=3){
                showMessage("Se debe ingresar caracter a consumir, pila a consumir, pila a agregar\nEjemplo: 0,z0,0z0");
            }else if(na.length==3){
                nombre=name;
                break;
            }
        }
        return nombre;
    }

    private boolean prologoTransicion() {
        if (pda.transiciones.isEmpty()) {
            showMessage("No hay transiciones!");
            return true;
        }
        return false;
    }
        
    private Estado obtenerEstado(String nombre){
        for(Estado estado:pda.estados)
        {
            if(estado.nombreEstado.equals(nombre))
            {
                return estado;
               
            }
        }
        return null;
    }

    private void probarCadenaEnAutomata(ActionEvent e) {
        if(prologoAntesDeProbar())
            return;
        if(!seCreaAlfabeto(jTextFieldAlfabeto.getText().toCharArray()))
            return;
        if(!pda.stack.isEmpty())
            pda.stack=new Stack<>();
        pda.simboloActualDePila = jTextFieldSimboloDePila.getText();
        pda.simboloInicial = jTextFieldSimboloDePila.getText();
        pda.stack.push(pda.simboloActualDePila);
        if(pda.EvaluarCadena(jTextFieldCadena.getText())){
            JOptionPane.showMessageDialog(getContentPane(),"EL AUTOMATA ACEPTA LA CADENA!", "Success",
            JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        showMessage("EL AUTOMATA NO ACEPTA LA CADENA");
    }
    
    
    private boolean prologoAntesDeProbar() {
        if (pda.estados.isEmpty()) {
            showMessage("No hay estado!");
            return true;
        }
        if (pda.estadoInicial.nombreEstado.isEmpty()) {
            showMessage("Debe existir un estado inicial!");
            return true;
        }
        if (jTextFieldAlfabeto.getText().isEmpty()) {
            showMessage("Porfavor ingrese alfabeto!");
            return true;
        }
        if(jTextFieldSimboloDePila.getText().isEmpty()){
            showMessage("Porfavor ingrese nombre de simbolo inicial de pila!");
            return true;
        }
        return false;
    }
    private boolean seCreaAlfabeto(char [] alfabeto){
        for(int i = 0; i < alfabeto.length; i++) {
            for(int j = i+1; j <alfabeto.length; j++) {
                if(alfabeto[j] == alfabeto[i]) {
                    showMessage("No es necesario agregar dos veces el mismo digito o letra al alfabeto!");
                    return false;
                } 
            }
        }
        
        if(!pda.alfabeto.isEmpty()){
            pda.alfabeto=new ArrayList<>();
        }
        for(int i = 0;i<alfabeto.length;i++){
            pda.alfabeto.add(alfabeto[i]);
        }
        return true;
    }
     private Estado obtenerEstado(mxCell vertex) {
    for(Estado estado:pda.estados)
        {
            if(estado.vertex.equals(vertex))
            {
                return estado;
               
            }
        }
        return null;
    }
}
