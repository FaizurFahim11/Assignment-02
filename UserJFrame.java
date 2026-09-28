package ui;


import java.awt.Image;
import model.User;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;


public class UserJFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserJFrame.class.getName());
private File selectedPhoto; // to store uploaded photo
    private File photo;

   
    public UserJFrame() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        Age = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        textName = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        Name = new javax.swing.JLabel();
        College = new javax.swing.JLabel();
        PhoneNumber = new javax.swing.JLabel();
        textPhoneNumber = new javax.swing.JFormattedTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Photo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        UploadPhoto = new javax.swing.JButton();
        photoUpload = new javax.swing.JLabel();
        textName1 = new javax.swing.JTextField();
        Name1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Age.setText("Age:");

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel());

        Name.setText("First Name:");

        College.setText("Gender");

        PhoneNumber.setText("Phone:");

        try {
            textPhoneNumber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        textPhoneNumber.setToolTipText("123-456-7890");
        textPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPhoneNumberActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Male ");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Continent:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Africa", "Antarctica", "Asia", "Europe", "North America", "South America", "Australia" }));

        jLabel2.setText("Experience:");

        Photo.setText("Photo:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        UploadPhoto.setText("Upload Photo");
        UploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadPhotoActionPerformed(evt);
            }
        });

        Name1.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(Submit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Photo)
                                .addGap(32, 32, 32))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Name1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(photoUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                .addComponent(textName1, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(UploadPhoto)))
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Age)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(College)
                                    .addComponent(PhoneNumber)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)))
                            .addComponent(Name))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Age)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(College))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PhoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Photo)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UploadPhoto))
                .addGap(18, 18, 18)
                .addComponent(photoUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Submit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
                                     

    String errorTitle = "Ooops";

    try {
        String firstName = textName.getText();
        String lastName = textName1.getText();
        int age = (int) jSpinner1.getValue();
        String gender = jRadioButton1.isSelected() ? "Male"
    : jRadioButton2.isSelected() ? "Female"
    : null;
        String phone = textPhoneNumber.getText();
        String continent = (String) jComboBox1.getSelectedItem();
        String experience = jTextArea1.getText();
        String photoPath = jTextField1.getText();

        // Validate first name
        if (firstName == null || firstName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid First Name Provided", errorTitle, ERROR_MESSAGE);
            return;
        }

        // Validate last name
        if (lastName == null || lastName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Invalid Last Name Provided", errorTitle, ERROR_MESSAGE);
            return;
        }

        // Validate phone
        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Invalid Phone Number", errorTitle, ERROR_MESSAGE);
            return;
        }

        // Build student and send to parent
        Student student = new Student();
        student.setName(firstName.trim() + " " + lastName.trim());
        student.setAge(age);
       student.setGender(gender);
        student.setPhone(phone);
        student.setContinent(continent);
        student.setExperience(experience);
        student.setPhotoPath(photoPath);

      String successMessage = "First Name: " + firstName.trim()
    + "\nLast Name: " + lastName.trim()
    + "\nAge: " + age
   + "\nGender: " + (gender == null ? "Not selected" : gender)
    + "\nPhone: " + phone
    + "\nContinent: " + (continent == null ? "Not selected" : continent)
    + "\nExperience: " + (experience == null || experience.trim().isEmpty() ? "None" : experience)
    + "\nPhoto Path: " + (photoPath == null || photoPath.trim().isEmpty() ? "Not uploaded" : photoPath);
      
        // Build the photo icon (if one was uploaded)
        ImageIcon photoIcon = null;
        if (photoPath != null && !photoPath.trim().isEmpty()) {
            ImageIcon rawIcon = new ImageIcon(photoPath);
            Image scaled = rawIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            photoIcon = new ImageIcon(scaled);
        }

        JOptionPane.showMessageDialog(
            this,
            successMessage,
            "Success",
            JOptionPane.INFORMATION_MESSAGE,
            photoIcon
        );

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Invalid Age Provided", errorTitle, ERROR_MESSAGE);
    }  

    }//GEN-LAST:event_SubmitActionPerformed

    private void textPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPhoneNumberActionPerformed

        String phone = textPhoneNumber.getText();
        if (!phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid phone number (e.g., 123-456-7890)",
                "Invalid Phone", ERROR_MESSAGE);
            textPhoneNumber.requestFocus();
        }
    }//GEN-LAST:event_textPhoneNumberActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
    
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
   
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void UploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadPhotoActionPerformed

        JFileChooser chooser = new JFileChooser();
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            jTextField1.setText(selectedFile.getAbsolutePath());

            // Load and scale image to fit label
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            Image scaledImage = icon.getImage().getScaledInstance(photoUpload.getWidth(), photoUpload.getHeight(), Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);

            photoUpload.setIcon(icon);
            photoUpload.setText(""); // remove placeholder text
        }

    }//GEN-LAST:event_UploadPhotoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new UserJFrame().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Age;
    private javax.swing.JLabel College;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Name1;
    private javax.swing.JLabel PhoneNumber;
    private javax.swing.JLabel Photo;
    private javax.swing.JButton Submit;
    private javax.swing.JButton UploadPhoto;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel photoUpload;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textName1;
    private javax.swing.JFormattedTextField textPhoneNumber;
    // End of variables declaration//GEN-END:variables
}