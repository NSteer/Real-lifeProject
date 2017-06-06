
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author conno
 */
public class FileChooser extends javax.swing.JFrame {

    String[] fileArray;
    int count;

    /**
     * Creates new form FileChooser
     */
    public FileChooser() {
        initComponents();

        fileArray = new String[10];
        count = Integer.parseInt(CV_count.getText());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        CV_count = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        JobForm = new javax.swing.JMenuItem();
        Add_CV = new javax.swing.JMenuItem();
        Remove_CV = new javax.swing.JMenuItem();
        Remove_ALL = new javax.swing.JMenuItem();
        Results = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();

        fileChooser.setDialogTitle("This is my open dialog.");
        fileChooser.setFileFilter(new MyCustomFilter());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textarea.setColumns(20);
        textarea.setRows(5);
        textarea.setText("Add CV's to compare to the Job Requirements.\nMaximum 10 at a time.");
        jScrollPane1.setViewportView(textarea);

        CV_count.setText("0");

        jLabel1.setText("CVs Loaded:");

        FileMenu.setText("File");

        JobForm.setText("Job Form");
        JobForm.setEnabled(false);
        JobForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JobFormActionPerformed(evt);
            }
        });
        FileMenu.add(JobForm);

        Add_CV.setText("Add CV");
        Add_CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Add_CVActionPerformed(evt);
            }
        });
        FileMenu.add(Add_CV);

        Remove_CV.setText("Remove CV");
        Remove_CV.setEnabled(false);
        Remove_CV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_CVActionPerformed(evt);
            }
        });
        FileMenu.add(Remove_CV);

        Remove_ALL.setText("Remove All");
        Remove_ALL.setEnabled(false);
        Remove_ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Remove_ALLActionPerformed(evt);
            }
        });
        FileMenu.add(Remove_ALL);

        Results.setText("Results");
        Results.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResultsActionPerformed(evt);
            }
        });
        FileMenu.add(Results);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        FileMenu.add(Exit);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CV_count, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CV_count)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void JobFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JobFormActionPerformed
        // TODO add your handling code here:

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            Converter.start(file.getAbsolutePath());

            try {
                // What to do with the file, e.g. display it in a TextArea
                textarea.read(new FileReader(file.getAbsolutePath() + ".txt"), null);
            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_JobFormActionPerformed

    private void Add_CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Add_CVActionPerformed
        // TODO add your handling code here:

        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileArray[count] = file.getAbsolutePath();
            count++;
            if (count == 10) {
                Add_CV.setEnabled(false);
            }
        } else {
            System.out.println("File access cancelled by user.");
        }
        CV_count.setText("" + count + "");
        Remove_CV.setEnabled(true);
        Remove_ALL.setEnabled(true);

    }//GEN-LAST:event_Add_CVActionPerformed

    private void ResultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResultsActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < count; i++) {
            textarea.append("\n\n" + fileArray[i] + "\n");
            Converter.start(fileArray[i]);
        }

        /*try {
                // What to do with the file, e.g. display it in a TextArea
                textarea.read(new FileReader(file.getAbsolutePath() + ".txt"), null);
            } catch (IOException ex) {
                System.out.println("problem accessing file" + file.getAbsolutePath());
            }*/
    }//GEN-LAST:event_ResultsActionPerformed

    private void Remove_CVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_CVActionPerformed
        // TODO add your handling code here:
        fileArray[count] = "";
        count = count - 1;
        if (count == 0) {
            Remove_CV.setEnabled(false);
            textarea.setText("Add CV's to compare to the Job Requirements.\nMaximum 10 at a time.");
        }
        CV_count.setText("" + count + "");
    }//GEN-LAST:event_Remove_CVActionPerformed

    private void Remove_ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Remove_ALLActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < count; i++) {
            fileArray[i] = "";
        }
        Remove_CV.setEnabled(false);
        Remove_ALL.setEnabled(false);
        count = 0;
        CV_count.setText("" + count + "");
        textarea.setText("Add CV's to compare to the Job Requirements.\nMaximum 10 at a time.");
    }//GEN-LAST:event_Remove_ALLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FileChooser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int count = 1;
                new FileChooser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Add_CV;
    private javax.swing.JLabel CV_count;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem JobForm;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem Remove_ALL;
    private javax.swing.JMenuItem Remove_CV;
    private javax.swing.JMenuItem Results;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea textarea;
    // End of variables declaration//GEN-END:variables

    class MyCustomFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".pdf") || file.getAbsolutePath().endsWith(".doc") || file.getAbsolutePath().endsWith(".docx");
        }

        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Text documents (*.PDF)(*.Docx)(*.Doc)(*.txt)";
        }
    }
}