/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.monster.vista;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import ec.edu.monster.modelo.ConversionModelo;
import ec.edu.monster.controlador.ConversionController;

/**
 *
 * @author johan
 */
public class MenuView extends javax.swing.JFrame {
    
    FondoPanel fondo = new FondoPanel();
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JPanel menuPanel;
    private TemperaturaView temperaturaView;
    private LongitudView longitudView;
    private MasaView masaView;
    private ConversionModelo conversionModel;
    private ConversionController temperaturaController;
    private ConversionController longitudController;
    private ConversionController masaController;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MenuView.class.getName());

    /**
     * Creates new form MenuFrame
     */
    public MenuView() {
        initComponents();
        setupCardLayout();
    }
    
    private void setupCardLayout() {
        // Crear el modelo de conversión
        conversionModel = new ConversionModelo();
        
        // Crear el CardLayout y panel principal
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setOpaque(false);
        
        // Crear el panel del menú
        menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new java.awt.BorderLayout());
        menuPanel.add(fondo, java.awt.BorderLayout.CENTER);
        
        // Crear las vistas de conversión
        temperaturaView = new TemperaturaView();
        longitudView = new LongitudView();
        masaView = new MasaView();
        
        // Crear los controladores
        temperaturaController = new ConversionController(conversionModel, temperaturaView);
        longitudController = new ConversionController(conversionModel, longitudView);
        masaController = new ConversionController(conversionModel, masaView);
        
        // Agregar paneles al CardLayout
        mainPanel.add(menuPanel, "MENU");
        mainPanel.add(temperaturaView.getContentPane(), "TEMPERATURA");
        mainPanel.add(longitudView.getContentPane(), "LONGITUD");
        mainPanel.add(masaView.getContentPane(), "MASA");
        
        // Establecer el panel principal como contenido
        this.setContentPane(mainPanel);
        
        // Configurar el tamaño de la ventana
        this.setSize(700, 450);
        this.setLocationRelativeTo(null);
        
        // Agregar botones de regreso a cada vista
        addBackButtons();
        
        // Mostrar el menú inicialmente
        cardLayout.show(mainPanel, "MENU");
    }
    
    private void addBackButtons() {
        // Botón de regreso para temperatura
        JButton backTemperatura = new JButton("← Volver");
        backTemperatura.setSize(120, 30);
        backTemperatura.setLocation(570, 350); // Esquina inferior derecha
        backTemperatura.setBackground(new java.awt.Color(102, 0, 102)); // Color morado
        backTemperatura.setForeground(java.awt.Color.WHITE); // Texto blanco
        backTemperatura.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        temperaturaView.getContentPane().setLayout(null); // Usar layout absoluto
        temperaturaView.getContentPane().add(backTemperatura);
        
        // Botón de regreso para longitud
        JButton backLongitud = new JButton("← Volver");
        backLongitud.setSize(120, 30);
        backLongitud.setLocation(570, 350); // Esquina inferior derecha
        backLongitud.setBackground(new java.awt.Color(102, 0, 102)); // Color morado
        backLongitud.setForeground(java.awt.Color.WHITE); // Texto blanco
        backLongitud.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        longitudView.getContentPane().setLayout(null); // Usar layout absoluto
        longitudView.getContentPane().add(backLongitud);
        
        // Botón de regreso para masa
        JButton backMasa = new JButton("← Volver");
        backMasa.setSize(120, 30);
        backMasa.setLocation(570, 350); // Esquina inferior derecha
        backMasa.setBackground(new java.awt.Color(102, 0, 102)); // Color morado
        backMasa.setForeground(java.awt.Color.WHITE); // Texto blanco
        backMasa.addActionListener(e -> cardLayout.show(mainPanel, "MENU"));
        masaView.getContentPane().setLayout(null); // Usar layout absoluto
        masaView.getContentPane().add(backMasa);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTemperatura = new javax.swing.JButton();
        btnMasa = new javax.swing.JButton();
        btnLongitud = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnTemperatura.setBackground(new java.awt.Color(255, 255, 153));
        btnTemperatura.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnTemperatura.setText("Temperatura");
        btnTemperatura.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTemperatura.setBorderPainted(false);
        btnTemperatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTemperaturaActionPerformed(evt);
            }
        });

        btnMasa.setBackground(new java.awt.Color(255, 255, 153));
        btnMasa.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnMasa.setText("Masa");
        btnMasa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnMasa.setBorderPainted(false);
        btnMasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMasaActionPerformed(evt);
            }
        });

        btnLongitud.setBackground(new java.awt.Color(255, 255, 153));
        btnLongitud.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        btnLongitud.setText("Longitud");
        btnLongitud.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLongitud.setBorderPainted(false);
        btnLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLongitudActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Elije una opción");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setText("CONVERSIÓN DE UNIDADES ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(btnTemperatura)
                        .addGap(77, 77, 77)
                        .addComponent(btnMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addComponent(jLabel1)))
                .addContainerGap(147, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(jLabel2)
                    .addContainerGap(201, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMasa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(172, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(311, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTemperaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTemperaturaActionPerformed
        // Cambiar al panel de temperatura
        cardLayout.show(mainPanel, "TEMPERATURA");
    }//GEN-LAST:event_btnTemperaturaActionPerformed

    private void btnLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLongitudActionPerformed
        // Cambiar al panel de longitud
        cardLayout.show(mainPanel, "LONGITUD");
    }//GEN-LAST:event_btnLongitudActionPerformed

    private void btnMasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMasaActionPerformed
        // Cambiar al panel de masa
        cardLayout.show(mainPanel, "MASA");
    }//GEN-LAST:event_btnMasaActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuView().setVisible(true));
    }

    public JButton getBtnLongitud() {
        return btnLongitud;
    }

    public void setBtnLongitud(JButton btnLongitud) {
        this.btnLongitud = btnLongitud;
    }

    public JButton getBtnMasa() {
        return btnMasa;
    }

    public void setBtnMasa(JButton btnMasa) {
        this.btnMasa = btnMasa;
    }

    public JButton getBtnTemperatura() {
        return btnTemperatura;
    }

    public void setBtnTemperatura(JButton btnTemperatura) {
        this.btnTemperatura = btnTemperatura;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLongitud;
    private javax.swing.JButton btnMasa;
    private javax.swing.JButton btnTemperatura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    
    class FondoPanel extends JPanel
    {
        private Image imagen;
        
        public FondoPanel() {
            // Cargar la imagen una sola vez en el constructor
            try {
                imagen = new ImageIcon(getClass().getResource("/ec/edu/monster/images/fondo.jpg")).getImage();
                if (imagen == null) {
                    System.err.println("No se pudo cargar la imagen fondo.jpg");
                }
            } catch (Exception e) {
                System.err.println("Error al cargar la imagen: " + e.getMessage());
            }
            setOpaque(false);
        }
        
        @Override
        public void paint(Graphics g)
        {
            if (imagen != null) {
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            }
            super.paint(g);
        }
    }
}
