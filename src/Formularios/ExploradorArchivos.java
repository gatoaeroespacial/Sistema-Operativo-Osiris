package Formularios;

import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

public class ExploradorArchivos extends javax.swing.JFrame {

    private File rootDirectory;

    public ExploradorArchivos(String rootPath) {
        initComponents();
        initComponents2();
        setLocationRelativeTo(null); // Centrar la ventana
        rootDirectory = new File(rootPath);
        populateTree(rootDirectory);

        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    File selectedFile = (File) selectedNode.getUserObject();
                    populateTable(selectedFile);
                    updatePathLabel(selectedFile);
                }
            }
        });

        fileTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int row = fileTable.getSelectedRow();
                    if (row != -1) {
                        String fileName = (String) fileTable.getValueAt(row, 0);
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
                        File currentFile = (File) selectedNode.getUserObject();
                        File selectedFile = new File(currentFile, fileName);
                        if (selectedFile.isDirectory()) {
                            populateTable(selectedFile);
                            updateTree(selectedNode, selectedFile);
                            fileTree.setSelectionPath(fileTree.getSelectionPath().pathByAddingChild(new DefaultMutableTreeNode(selectedFile)));
                            updatePathLabel(selectedFile);
                        } else {
                            openFile(selectedFile);
                        }
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                if (evt.isPopupTrigger()) {
                    int row = fileTable.rowAtPoint(evt.getPoint());
                    fileTable.setRowSelectionInterval(row, row);
                    showContextMenu(evt, row);
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navigateUp();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFiles(searchField.getText());
            }
        });
    }

    private void populateTree(File rootFile) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootFile.getName());
        root.setUserObject(rootFile);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        createNodes(root, rootFile);
        fileTree.setModel(treeModel);
        fileTree.setCellRenderer(new CustomTreeCellRenderer());
    }

    private void createNodes(DefaultMutableTreeNode node, File fileRoot) {
        File[] files = fileRoot.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
                    childNode.setUserObject(file);
                    node.add(childNode);
                    createNodes(childNode, file);
                }
            }
        }
    }

    private void updateTree(DefaultMutableTreeNode node, File directory) {
        node.removeAllChildren();
        createNodes(node, directory);
        ((DefaultTreeModel) fileTree.getModel()).reload(node);
    }

    private void populateTable(File directory) {
        DefaultTableModel model = (DefaultTableModel) fileTable.getModel();
        model.setRowCount(0);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    model.addRow(new Object[]{file.getName(), file.length()});
                }
            }
        }
    }

    private void openFile(File file) {
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePathLabel(File directory) {
        pathLabel.setText(directory.getAbsolutePath());
    }

    private void navigateUp() {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        if (selectedNode != null) {
            File selectedFile = (File) selectedNode.getUserObject();
            File parentFile = selectedFile.getParentFile();
            if (parentFile != null && !parentFile.equals(rootDirectory)) {
                populateTable(parentFile);
                updatePathLabel(parentFile);
                // Navigate to parent in tree
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                if (parentNode != null) {
                    fileTree.setSelectionPath(fileTree.getSelectionPath().getParentPath());
                }
            }
        }
    }

    private void searchFiles(String query) {
        DefaultTableModel model = (DefaultTableModel) fileTable.getModel();
        model.setRowCount(0);
        searchDirectory(rootDirectory, query, model);
    }

    private void searchDirectory(File directory, String query, DefaultTableModel model) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchDirectory(file, query, model);
                } else {
                    if (file.getName().contains(query)) {
                        model.addRow(new Object[]{file.getName(), file.length()});
                    }
                }
            }
        }
    }

    private void showContextMenu(MouseEvent evt, int row) {
        JPopupMenu contextMenu = new JPopupMenu();
        JMenuItem renameItem = new JMenuItem("Cambiar Nombre");
        JMenuItem deleteItem = new JMenuItem("Eliminar");
        JMenuItem copyPathItem = new JMenuItem("Copiar Ruta de Acceso");

        renameItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                renameFile(row);
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile(row);
            }
        });

        copyPathItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copyFilePath(row);
            }
        });

        contextMenu.add(renameItem);
        contextMenu.add(deleteItem);
        contextMenu.add(copyPathItem);
        contextMenu.show(fileTable, evt.getX(), evt.getY());
    }

    private void renameFile(int row) {
        String fileName = (String) fileTable.getValueAt(row, 0);
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        File currentFile = (File) selectedNode.getUserObject();
        File fileToRename = new File(currentFile, fileName);

        String newName = JOptionPane.showInputDialog("Nuevo Nombre:", fileName);
        if (newName != null && !newName.trim().isEmpty()) {
            File renamedFile = new File(currentFile, newName);
            if (fileToRename.renameTo(renamedFile)) {
                populateTable(currentFile);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo renombrar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void deleteFile(int row) {
        String fileName = (String) fileTable.getValueAt(row, 0);
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        File currentFile = (File) selectedNode.getUserObject();
        File fileToDelete = new File(currentFile, fileName);

        int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar " + fileName + "?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (fileToDelete.delete()) {
                populateTable(currentFile);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void copyFilePath(int row) {
        String fileName = (String) fileTable.getValueAt(row, 0);
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
        File currentFile = (File) selectedNode.getUserObject();
        File file = new File(currentFile, fileName);

        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }

    private class CustomTreeCellRenderer implements TreeCellRenderer {

        private JLabel label;

        CustomTreeCellRenderer() {
            label = new JLabel();
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            File file = (File) node.getUserObject();
            label.setText(file.getName());
            label.setIcon(UIManager.getIcon(file.isDirectory() ? "FileView.directoryIcon" : "FileView.fileIcon"));
            return label;
        }
    }

    // Variables declaration
    private javax.swing.JTree fileTree;
    private javax.swing.JTable fileTable;
    private javax.swing.JScrollPane treeScrollPane;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchButton;

    // initComponents method
    private void initComponents2() {
        splitPane = jSplitPane1;
        treeScrollPane = jScrollPane1;
        fileTree = jTree1;
        tableScrollPane = jScrollPane2;
        fileTable = jTable1;
        backButton = new JButton("<--");
        pathLabel = new JLabel();
        searchField = new JTextField(20);
        searchButton = new JButton("Buscar");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        treeScrollPane.setViewportView(fileTree);
        splitPane.setLeftComponent(treeScrollPane);

        fileTable.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Size"}
        ) {
            boolean[] canEdit = new boolean[]{
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        fileTable.setBorder(null);
        System.out.println(fileTable.getColumn("Size"));
        

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        
        cellRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        fileTable.getColumn("Size").setCellRenderer(cellRenderer);

        cellRenderer.setBorder(null);
        fileTable.setDefaultRenderer(Object.class, cellRenderer);

        tableScrollPane.setViewportView(fileTable);
        splitPane.setRightComponent(tableScrollPane);

        JPanel topPanel = new JPanel();
        topPanel.add(backButton);
        topPanel.add(pathLabel);
        topPanel.add(searchField);
        topPanel.add(searchButton);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                        .addComponent(topPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE))
        );

        pack();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExploradorArchivos("C:\\Users\\juanm\\Documents").setVisible(true);
            }
        });
    }

//generated code

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSplitPane1 = new javax.swing.JSplitPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTree1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}


// new ExploradorArchivos("C:\\Users\\juanm\\Documents").setVisible(true);
