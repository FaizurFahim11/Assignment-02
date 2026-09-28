import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


 
public class UserProfileApp extends JFrame {

    
    private final JTextField firstNameField = new JTextField(15);
    private final JTextField lastNameField  = new JTextField(15);

    private final JRadioButton maleRadio   = new JRadioButton("Male");
    private final JRadioButton femaleRadio = new JRadioButton("Female");
    private final JRadioButton otherRadio  = new JRadioButton("Other");
    private final ButtonGroup genderGroup  = new ButtonGroup();

    private final JTextField ageField   = new JTextField(15);
    private final JTextField phoneField = new JTextField(15);
    private final JTextField emailField = new JTextField(15);

    // Bonus: photo upload
    private final JLabel photoPreviewLabel = new JLabel("No photo selected", SwingConstants.CENTER);
    private final JButton choosePhotoButton = new JButton("Choose Photo...");
    private File selectedPhotoFile = null;

    // Error labels shown directly under each field
    private final Map<JComponent, JLabel> errorLabels = new HashMap<>();

    private final JButton submitButton = new JButton("Create Profile");
    private final JButton clearButton  = new JButton("Clear");

  
    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[A-Za-z][A-Za-z '-]{0,29}$");
    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^\\(?\\d{3}\\)?[-. ]?\\d{3}[-. ]?\\d{4}$");
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[\\w.+-]+@[\\w-]+\\.[A-Za-z]{2,}$");

    public UserProfileApp() {
        super("Create User Profile - Lab 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        add(buildFormPanel(), BorderLayout.CENTER);
        add(buildButtonPanel(), BorderLayout.SOUTH);

        registerValidationListeners();
        registerButtonActions();

        pack();
        setMinimumSize(new Dimension(480, 520));
        setLocationRelativeTo(null);
    }

    

    private JPanel buildFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 0, 6);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        addFieldRow(panel, gbc, row++, "First Name:", firstNameField);
        addFieldRow(panel, gbc, row++, "Last Name:", lastNameField);

       
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panel.add(new JLabel("Gender:"), gbc);

        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);

        gbc.gridx = 1; gbc.weightx = 1;
        panel.add(genderPanel, gbc);
        row++;

        JLabel genderError = new JLabel(" ");
        genderError.setForeground(Color.RED);
        genderError.setFont(genderError.getFont().deriveFont(11f));
        gbc.gridx = 1; gbc.gridy = row++; gbc.insets = new Insets(0, 6, 6, 6);
        panel.add(genderError, gbc);
       
        errorLabels.put(maleRadio, genderError);
        gbc.insets = new Insets(6, 6, 0, 6);

        addFieldRow(panel, gbc, row++, "Age:", ageField);
        addFieldRow(panel, gbc, row++, "Phone Number:", phoneField);
        addFieldRow(panel, gbc, row++, "Email:", emailField);

      
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panel.add(new JLabel("Photo (bonus):"), gbc);
        gbc.gridx = 1;
        panel.add(choosePhotoButton, gbc);
        row++;

        photoPreviewLabel.setPreferredSize(new Dimension(120, 120));
        photoPreviewLabel.setBorder(new LineBorder(Color.GRAY));
        gbc.gridx = 1; gbc.gridy = row++; gbc.insets = new Insets(6, 6, 6, 6);
        panel.add(photoPreviewLabel, gbc);

        return panel;
    }

   
    private void addFieldRow(JPanel panel, GridBagConstraints gbc, int row, String labelText, JTextField field) {
        gbc.gridx = 0; gbc.gridy = row; gbc.weightx = 0;
        panel.add(new JLabel(labelText), gbc);

        gbc.gridx = 1; gbc.weightx = 1;
        panel.add(field, gbc);

        JLabel error = new JLabel(" ");
        error.setForeground(Color.RED);
        error.setFont(error.getFont().deriveFont(11f));
        errorLabels.put(field, error);

        
        GridBagConstraints errGbc = (GridBagConstraints) gbc.clone();
        errGbc.gridy = row + 1;
        errGbc.insets = new Insets(0, 6, 6, 6);
        panel.add(error, errGbc);
    }

    private JPanel buildButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panel.add(submitButton);
        panel.add(clearButton);
        return panel;
    }

   

    private void registerValidationListeners() {
        
        addFocusValidation(firstNameField, this::validateFirstName);
        addFocusValidation(lastNameField, this::validateLastName);
        addFocusValidation(ageField, this::validateAge);
        addFocusValidation(phoneField, this::validatePhone);
        addFocusValidation(emailField, this::validateEmail);

        
        addLiveValidation(firstNameField, this::validateFirstName);
        addLiveValidation(lastNameField, this::validateLastName);
        addLiveValidation(ageField, this::validateAge);
        addLiveValidation(phoneField, this::validatePhone);
        addLiveValidation(emailField, this::validateEmail);

        ActionListener genderListener = e -> validateGender();
        maleRadio.addActionListener(genderListener);
        femaleRadio.addActionListener(genderListener);
        otherRadio.addActionListener(genderListener);
    }

    private void addFocusValidation(JTextField field, java.util.function.Supplier<Boolean> validator) {
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validator.get();
            }
        });
    }

    private void addLiveValidation(JTextField field, java.util.function.Supplier<Boolean> validator) {
        field.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validator.get(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validator.get(); }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validator.get(); }
        });
    }

    private void registerButtonActions() {
        choosePhotoButton.addActionListener(this::onChoosePhoto);
        submitButton.addActionListener(this::onSubmit);
        clearButton.addActionListener(this::onClear);
    }

   
    private boolean validateFirstName() {
        return validatePatternField(firstNameField, NAME_PATTERN,
                "First name is required and must contain only letters.");
    }

    private boolean validateLastName() {
        return validatePatternField(lastNameField, NAME_PATTERN,
                "Last name is required and must contain only letters.");
    }

    private boolean validateGender() {
        boolean valid = maleRadio.isSelected() || femaleRadio.isSelected() || otherRadio.isSelected();
        setError(maleRadio, valid ? null : "Please select a gender.");
        return valid;
    }

    private boolean validateAge() {
        String text = ageField.getText().trim();
        String message = null;
        if (text.isEmpty()) {
            message = "Age is required.";
        } else {
            try {
                int age = Integer.parseInt(text);
                if (age < 1 || age > 120) {
                    message = "Age must be between 1 and 120.";
                }
            } catch (NumberFormatException ex) {
                message = "Age must be a whole number.";
            }
        }
        setError(ageField, message);
        return message == null;
    }

    private boolean validatePhone() {
        return validatePatternField(phoneField, PHONE_PATTERN,
                "Enter a valid phone number, e.g. (123) 456-7890.");
    }

    private boolean validateEmail() {
        return validatePatternField(emailField, EMAIL_PATTERN,
                "Enter a valid email address, e.g. name@example.com.");
    }

    
    private boolean validatePatternField(JTextField field, Pattern pattern, String errorMessage) {
        String text = field.getText().trim();
        String message;
        if (text.isEmpty()) {
            message = "This field is required.";
        } else if (!pattern.matcher(text).matches()) {
            message = errorMessage;
        } else {
            message = null;
        }
        setError(field, message);
        return message == null;
    }

    
    private void setError(JComponent component, String message) {
        JLabel label = errorLabels.get(component);
        if (label != null) {
            label.setText(message == null ? " " : message);
        }
        if (component instanceof JTextField) {
            Border border = (message == null)
                    ? UIManager.getBorder("TextField.border")
                    : new LineBorder(Color.RED, 1);
            component.setBorder(border);
        }
    }

    
    private void onChoosePhoto(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
                "Image files", "jpg", "jpeg", "png", "gif"));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            selectedPhotoFile = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedPhotoFile.getPath());
            Image scaled = icon.getImage().getScaledInstance(110, 110, Image.SCALE_SMOOTH);
            photoPreviewLabel.setIcon(new ImageIcon(scaled));
            photoPreviewLabel.setText(null);
        }
    }

    private void onSubmit(ActionEvent e) {
        
        boolean firstNameOk = validateFirstName();
        boolean lastNameOk  = validateLastName();
        boolean genderOk    = validateGender();
        boolean ageOk        = validateAge();
        boolean phoneOk      = validatePhone();
        boolean emailOk      = validateEmail();

        boolean allValid = firstNameOk && lastNameOk && genderOk && ageOk && phoneOk && emailOk;

        if (!allValid) {
            JOptionPane.showMessageDialog(this,
                    "Please correct the highlighted fields before submitting.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        showProfileResult();
    }

    private void onClear(ActionEvent e) {
        firstNameField.setText("");
        lastNameField.setText("");
        genderGroup.clearSelection();
        ageField.setText("");
        phoneField.setText("");
        emailField.setText("");
        selectedPhotoFile = null;
        photoPreviewLabel.setIcon(null);
        photoPreviewLabel.setText("No photo selected");

        for (JComponent c : errorLabels.keySet()) {
            setError(c, null);
        }
    }

    
    private void showProfileResult() {
        String gender = maleRadio.isSelected() ? "Male" : femaleRadio.isSelected() ? "Female" : "Other";

        String summary = String.format(
                "First Name: %s%nLast Name: %s%nGender: %s%nAge: %s%nPhone: %s%nEmail: %s",
                firstNameField.getText().trim(),
                lastNameField.getText().trim(),
                gender,
                ageField.getText().trim(),
                phoneField.getText().trim(),
                emailField.getText().trim());

        JTextArea textArea = new JTextArea(summary);
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));

        JPanel content = new JPanel(new BorderLayout(15, 0));
        content.add(textArea, BorderLayout.CENTER);

        if (selectedPhotoFile != null) {
            ImageIcon icon = new ImageIcon(selectedPhotoFile.getPath());
            Image scaled = icon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            JLabel photoLabel = new JLabel(new ImageIcon(scaled));
            photoLabel.setBorder(new LineBorder(Color.GRAY));
            content.add(photoLabel, BorderLayout.WEST);
        }

        JOptionPane.showMessageDialog(this, content, "User Profile Created",
                JOptionPane.INFORMATION_MESSAGE);
    }

   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
                // fall back to default look and feel
            }
            new UserProfileApp().setVisible(true);
        });
    }
}
