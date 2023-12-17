package ToDoListApp;

import models.ToDo;
import Interfaces.DAOToDo;
import Interfaces.DAOToDoImplement;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ToDoListApp extends javax.swing.JFrame {
    
    DAOToDo dao = new DAOToDoImplement();
    
    public ToDoListApp(){
        initComponents();
        setLocationRelativeTo(null);
        read();
    }
// Crear una nueva tarea    
    public void create(){
        String description = txtDescription.getText();
        boolean status = boolStatus.isSelected();
        
        if(description.isEmpty()){
          JOptionPane.showMessageDialog(null, "Debes ingresar la descripción de la tarea");
        }else{
          ToDo todo = new ToDo(description, status);
          dao.create(todo);
        }
    }
// Leer la lista de tareas
    public void read(){
        try{
          List<ToDo> todos = dao.getTodoList();
          DefaultTableModel model = (DefaultTableModel) todoListTable.getModel();
          model.setRowCount(0);
          todos.forEach((todo)-> model.addRow(
            new Object[]{todo.getId(), todo.getDescription(), (todo.isStatus()) ? "fulfilled" : "pending"})
          );
          todoListTable.setModel(model);
          List<ToDo> pending = todos.stream()
                  .filter(todo->!todo.isStatus())
                  .collect(Collectors.toList());
          totalToDoPending.setText("" + pending.size());
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }
        reset();
    }

// Actualizar una tarea
    public void update(){
        String description = txtDescription.getText();
        boolean status = boolStatus.isSelected();
        int id = getId();
        
        if(description.isEmpty()) {
          JOptionPane.showMessageDialog(null, "Debes ingresar una descripción");
        }else if(id != -1){
           ToDo todo = new ToDo(id, description, status);
           dao.update(todo);
        }
    }
// Eliminar una tarea
    public void delete(){
        int idSelected = getId();
        if(idSelected!=-1){
           dao.delete(idSelected);
        }
    }
    
    public int getId(){
        int filaSeleccionada = todoListTable.getSelectedRow();
        if(filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una tarea");
            return -1;
        }else{
            int id = (int) todoListTable.getValueAt(filaSeleccionada, 0);
            return id;
        }
    }

// Resetear valores del formulario    
    public void reset(){
        txtId.setText("");
        txtDescription.setText("");
        boolStatus.setSelected(false);
        txtDescription.requestFocus();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        carreraLabel = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        conexionStatus = new javax.swing.JPanel();
        boolStatus = new javax.swing.JCheckBox();
        buttonsPanel = new javax.swing.JPanel();
        btnRead = new javax.swing.JButton();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        carrerasTableScrollPanel = new javax.swing.JScrollPane();
        todoListTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        totalToDoPending = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("TODOAPP");

        idLabel.setText("ID :");

        txtId.setEditable(false);

        carreraLabel.setText("Description :");

        javax.swing.GroupLayout conexionStatusLayout = new javax.swing.GroupLayout(conexionStatus);
        conexionStatus.setLayout(conexionStatusLayout);
        conexionStatusLayout.setHorizontalGroup(
            conexionStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        conexionStatusLayout.setVerticalGroup(
            conexionStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );

        boolStatus.setText("Status");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(conexionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carreraLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(headerPanelLayout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boolStatus)))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(229, 229, 229))))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addComponent(conexionStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel)
                    .addComponent(boolStatus))
                .addGap(18, 18, 18)
                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carreraLabel))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnRead.setText("READ");
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnCreate.setText("CREATE");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
        buttonsPanelLayout.setVerticalGroup(
            buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonsPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRead, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        todoListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "description", "status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        DefaultTableCellRenderer TablaRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                String status = (String) table.getValueAt(row, 2);
                Color fulfilled = new Color(204, 255, 204);
                Color pending = new Color(255, 255, 204);
                if (status.equals("fulfilled")) {
                    c.setBackground(fulfilled);
                    c.setForeground(table.getForeground());
                } else {
                    c.setBackground(pending);
                    c.setForeground(table.getForeground()); 
                }

                return c;
            }
        };

        todoListTable.setDefaultRenderer(Object.class, TablaRenderer);

        todoListTable.getColumnModel().getColumn(0).setCellRenderer(TablaRenderer);
        todoListTable.getColumnModel().getColumn(2).setCellRenderer(TablaRenderer);
        TablaRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        todoListTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                todoListTableMouseClicked(evt);
            }
        });
        carrerasTableScrollPanel.setViewportView(todoListTable);
        if (todoListTable.getColumnModel().getColumnCount() > 0) {
            todoListTable.getColumnModel().getColumn(0).setMaxWidth(50);
            todoListTable.getColumnModel().getColumn(2).setMaxWidth(100);
        }

        jLabel1.setText("TODO pending : ");

        totalToDoPending.setText("0");

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carrerasTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalToDoPending)
                .addGap(16, 16, 16))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carrerasTableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalToDoPending))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        read();
        reset();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        create();
        reset();
        read();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
        reset();
        read();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        delete();
        read();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void todoListTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_todoListTableMouseClicked
        int fila = todoListTable.getSelectedRow();
        if(fila!=-1){
            String id = todoListTable.getValueAt(fila, 0).toString();
            String description = todoListTable.getValueAt(fila, 1).toString();
            String status = todoListTable.getValueAt(fila, 2).toString();
            txtId.setText(id);
            txtDescription.setText(description);
            if(status=="fulfilled") boolStatus.setSelected(true);
            else boolStatus.setSelected(false);
        }
    }//GEN-LAST:event_todoListTableMouseClicked


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ToDoListApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox boolStatus;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel carreraLabel;
    private javax.swing.JScrollPane carrerasTableScrollPanel;
    private javax.swing.JPanel conexionStatus;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel title;
    private javax.swing.JTable todoListTable;
    private javax.swing.JLabel totalToDoPending;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
