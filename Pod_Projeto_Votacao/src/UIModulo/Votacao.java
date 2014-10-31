package UIModulo;

import ServerModule.AcessStatus;
import ServerModule.Vote;
import xmlConvert.StringByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.bind.JAXBException;
import xmlConvert.VoteXmlConvert;

/**
 *
 * @author Fatinha de Sousa
 */
public class Votacao extends javax.swing.JDialog {

    private AcessStatus acess;
    
    public Votacao(AcessStatus acess) {
        this.acess = acess;
        this.setVisible(true);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jBVotar = new javax.swing.JButton();
        jTNumeroVoto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText("Boca de Urna");

        jBVotar.setText("Votar");
        jBVotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVotarActionPerformed(evt);
            }
        });

        jTNumeroVoto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBSair)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBVotar)
                        .addGap(291, 291, 291))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(276, Short.MAX_VALUE)
                .addComponent(jTNumeroVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(260, 260, 260))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jBSair))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jTNumeroVoto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jBVotar)
                .addGap(68, 68, 68))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        
        dispose();
    }//GEN-LAST:event_jBSairActionPerformed

    private void jBVotarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVotarActionPerformed
        try {
            
            Socket socket = new Socket("localhost", 10001);
            
            if(this.acess.getStatus().equalsIgnoreCase("F")){
                String voto = jTNumeroVoto.getText();
                String usuario = this.acess.getAccess();

                byte b[] = null;
                Vote vote = new Vote();
                vote.setUser(usuario);
                vote.setvalue(voto);

                String codigo = StringByte.convertByteString(VoteXmlConvert.ObjXml(vote), "VOT;");

                b = StringByte.convertStringByte(codigo);

                socket.getOutputStream().write(b);
                socket.getOutputStream().flush();

                InputStream input = socket.getInputStream();
                ByteArrayOutputStream temp = new ByteArrayOutputStream();
                byte[] msg = new byte[1];

                while(input.read(msg) != -1){
                    temp.write(msg);
                }

                String mensagem = temp.toString();
                JOptionPane.showMessageDialog(null, mensagem);
             }else{
                String voto = jTNumeroVoto.getText();
                String usuario = this.acess.getAccess();

                byte b[] = null;
                Vote vote = new Vote();
                vote.setUser(usuario);
                vote.setvalue(voto);

                String codigo = StringByte.convertByteString(VoteXmlConvert.ObjXml(vote), "VOT;");

                b = StringByte.convertStringByte(codigo);

                socket.getOutputStream().write(b);
                socket.getOutputStream().flush();
                
                JOptionPane.showMessageDialog(null, "Voce Nao Pode Votar! ");
            }
        } catch (IOException ex) {
            Logger.getLogger(Votacao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(Votacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBVotarActionPerformed

    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBSair;
    private javax.swing.JButton jBVotar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTNumeroVoto;
    // End of variables declaration//GEN-END:variables
}
