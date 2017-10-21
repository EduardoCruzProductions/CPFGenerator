package main;

import entidades.Bench;
import entidades.Cpf;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import util.ValidaCPF;

public class MainTela extends javax.swing.JFrame {

    public static List<Bench> listBench = new ArrayList<>();
    
    private boolean onExecut = false;
    private List<Cpf> listCpf = new ArrayList<>();
    private Integer tentativas = 0;
    private Integer acertos = 0;
    private Integer erros = 0;
    private Integer resultadosIguais = 0;

    Thread processThread;

    private long timeStart;
    private long timeStop;
    private float currentTimeInSeconds = 0;
    
    public MainTela() {
        initComponents();
        amont();
        manageBtn("restart");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnStop = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbTentativas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbErros = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbAcertos = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lbResultadosIguais = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbResultValid = new javax.swing.JLabel();
        btnBench = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);

        btnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/stop.png"))); // NOI18N
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnRestart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/restart.png"))); // NOI18N
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Tentativas:");

        lbTentativas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbTentativas.setText("0");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Erros:");

        lbErros.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbErros.setForeground(new java.awt.Color(255, 0, 0));
        lbErros.setText("0");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Acertos:");

        lbAcertos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbAcertos.setForeground(new java.awt.Color(0, 51, 255));
        lbAcertos.setText("0");

        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/start.png"))); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Resultados Iguais:");

        lbResultadosIguais.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbResultadosIguais.setText("0");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        jLabel7.setText("Resultados Válidos:");

        lbResultValid.setFont(new java.awt.Font("Dialog", 1, 22)); // NOI18N
        lbResultValid.setForeground(new java.awt.Color(0, 51, 255));
        lbResultValid.setText("0");

        btnBench.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bench.png"))); // NOI18N
        btnBench.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBenchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBench)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRestart)
                        .addGap(18, 18, 18)
                        .addComponent(btnStop)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTentativas))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbErros))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbAcertos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbResultadosIguais))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbResultValid)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnRestart, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnStop)
                            .addComponent(btnStart)))
                    .addComponent(btnBench))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTentativas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbErros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbResultadosIguais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbAcertos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lbResultValid))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        
        manageBtn("stop");
        
        onExecut = false;
        try {

            processThread.join();
            amont();

        } catch (InterruptedException ex) {

            JOptionPane.showMessageDialog(null, "Erro de interrupção de processo!\n" + ex.getMessage(), "InternalSystem", JOptionPane.ERROR_MESSAGE);

        }
        
        timeStop = System.currentTimeMillis();
        currentTimeInSeconds += (timeStop - timeStart)/1000;
        
        System.out.println(currentTimeInSeconds);
        
    }//GEN-LAST:event_btnStopActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        manageBtn("start");
        
        onExecut = true;

        processThread = new Thread() {

            public void run() {

                process();

            }

        };

        processThread.start();
        
        timeStart = System.currentTimeMillis();

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed

        manageBtn("restart");
        addData();
        clear();
        
    }//GEN-LAST:event_btnRestartActionPerformed

    private void btnBenchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBenchActionPerformed
        
        System.out.println("Tentativas/s: "+listBench.get(0).getTentativasPSecond());
        System.out.println("Erros/s: "+listBench.get(0).getErrosPSecond());
        System.out.println("Acertos/s: "+listBench.get(0).getAcertosPSecond());
        
        System.out.println("");
        
        System.out.println("Acertos: "+listBench.get(0).getProporcaoAcerto()+"%");
        System.out.println("Erros: "+listBench.get(0).getProporcaoErros()+"%");
        
    }//GEN-LAST:event_btnBenchActionPerformed

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
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainTela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBench;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbAcertos;
    private javax.swing.JLabel lbErros;
    private javax.swing.JLabel lbResultValid;
    private javax.swing.JLabel lbResultadosIguais;
    private javax.swing.JLabel lbTentativas;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void amont() {

        lbAcertos.setText(acertos.toString());
        lbErros.setText(erros.toString());
        lbTentativas.setText(tentativas.toString());
        lbResultadosIguais.setText(resultadosIguais.toString());

        lbResultValid.setText(Integer.toString(listCpf.size()));

        updateTable();

    }
    
    private void clear(){
        
        listCpf.clear();
        onExecut = false;
        tentativas = 0;
        acertos = 0;
        erros = 0;
        resultadosIguais = 0;
        
        timeStart = 0;
        timeStop = 0;
        currentTimeInSeconds = 0.f;

        processThread = null;
        
        amont();
        
    }
    
    private void manageBtn(String status){
        
        switch(status){
            
            case "start":
                
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
                btnRestart.setEnabled(false);
                btnBench.setEnabled(false);
                
                break;
            
            case "stop":
                
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
                btnRestart.setEnabled(true);
                btnBench.setEnabled(false);
                
                break;
                
            case "restart":
                
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
                btnRestart.setEnabled(false);
                btnBench.setEnabled(true);
                break;
                
        }
        
    }

    private void updateProgress() {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                lbAcertos.setText(acertos.toString());
                lbErros.setText(erros.toString());
                lbTentativas.setText(tentativas.toString());
                lbResultadosIguais.setText(resultadosIguais.toString());

                lbResultValid.setText(Integer.toString(listCpf.size()));

            }

        });

    }

    private void updateTable() {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Index");
        modelo.addColumn("CPF");

        for (Cpf cpf : listCpf) {

            modelo.addRow(new Object[]{
                cpf.getIndex(),
                ValidaCPF.imprimeCPF(cpf.getCpf())

            });

        }

        table.setModel(modelo);

    }

    private void process() {

        while (onExecut) {

            tentativas++;

            Random r = new Random();

            int[] vet = new int[11];

            String t = "";

            for (int i = 0; i < vet.length; i++) {

                t += Integer.toString(r.nextInt(10));

            }

            if (ValidaCPF.isCPF(t)) {

                acertos++;

                boolean nExist = true;

                for (Cpf c : listCpf) {

                    if (c.getCpf().equals(t)) {
                        nExist = false;
                        resultadosIguais++;
                        break;
                    }

                }

                if (nExist) {

                    Cpf c = new Cpf();

                    if (listCpf.isEmpty()) {

                        c.setIndex(0);

                    } else {

                        c.setIndex(listCpf.size());
                        
                    }

                    c.setCpf(t);

                    listCpf.add(c);

                }

            } else {

                erros++;

            }

            updateProgress();

        }

    }

    private void addData(){
        
        Bench b = new Bench();
        b.setAcertos(acertos);
        b.setErros(erros);
        b.setListCpf(listCpf);
        b.setResultadosIguais(resultadosIguais);
        b.setTime(currentTimeInSeconds);
        b.setTentativas(tentativas);
        
        listBench.add(b);
       
    }
    
}
