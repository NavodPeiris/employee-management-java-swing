import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmployeeGUI extends javax.swing.JFrame {

    public EmployeeGUI() {
        initComponents();
        connectToDB();
        LoadSsnData();
        fetchData();
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void connectToDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/employeedb", "root", "");
        } catch (Exception ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void LoadSsnData(){
        try{
            pst = con.prepareStatement("SELECT Ssn FROM Employees");
            rs = pst.executeQuery();
            txtSearchSsn.removeAllItems();
            txtDeleteSsn.removeAllItems();
            while(rs.next()){
                txtSearchSsn.addItem(rs.getString(1));
                txtDeleteSsn.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fetchData(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM Employees");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)tblEmployee.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v = new Vector();
                for(int a=1;a<=q;a++){
                    v.add(rs.getString("Ssn"));
                    v.add(rs.getString("Fname"));
                    v.add(rs.getString("Minit"));
                    v.add(rs.getString("Lname"));
                    v.add(rs.getString("Bdate"));
                    v.add(rs.getString("Address"));
                    v.add(rs.getString("Sex"));
                    v.add(rs.getString("Salary"));
                    v.add(rs.getString("Super_ssn"));
                    v.add(rs.getString("Dno"));
                }
                df.addRow(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void clearForm(){
        txtSsn.setText("");
        txtFname.setText("");
        txtMinit.setText("");
        txtLname.setText("");
        txtBdate.setText("");
        txtAddress.setText("");
        txtSex.setText("");
        txtSalary.setText("");
        txtSuperssn.setText("");
        txtDno.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtSsn = new javax.swing.JTextField();
        txtFname = new javax.swing.JTextField();
        txtMinit = new javax.swing.JTextField();
        txtLname = new javax.swing.JTextField();
        txtBdate = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtSex = new javax.swing.JTextField();
        txtSalary = new javax.swing.JTextField();
        txtSuperssn = new javax.swing.JTextField();
        txtDno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSearchSsn = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmployee = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtDeleteSsn = new javax.swing.JComboBox<>();
        btnDelete = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Ssn");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Fname");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Minit");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Lname");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Bdate");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Address");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Sex");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Salary");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Super_ssn");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Dno");

        txtSsn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSsnActionPerformed(evt);
            }
        });

        txtLname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLnameActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Ssn");

        txtSearchSsn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClear)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Employee Database GUI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tblEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ssn", "Fname", "Minit", "Lname", "Bdate", "Address", "Sex", "Salary", "Super_ssn", "Dno"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEmployee);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Delete by Ssn");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Ssn");

        txtDeleteSsn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Search by Ssn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSsn)
                                    .addComponent(txtFname)
                                    .addComponent(txtMinit)
                                    .addComponent(txtLname)
                                    .addComponent(txtBdate)
                                    .addComponent(txtAddress)
                                    .addComponent(txtSex)
                                    .addComponent(txtSalary)
                                    .addComponent(txtSuperssn)
                                    .addComponent(txtDno, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtDeleteSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnSearch)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnDelete))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSearchSsn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSearchSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMinit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtBdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtDeleteSsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSuperssn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSsnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSsnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSsnActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            int ssn = -1;
            String Fname = "";
            String Minit = "";
            String Lname = "";
            String Bdate = "";
            String Address = "";
            String Sex = "";
            int Salary = -1;
            String Super_ssn = "";
            int Dno = -1;
            
            try{
                ssn = Integer.parseInt(txtSsn.getText());
                if(ssn < 0){
                    JOptionPane.showMessageDialog(this, "Ssn should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Ssn should be a positive number and not Empty");
                return;
            }
            
            Fname = txtFname.getText();
            Minit = txtMinit.getText();
            Lname = txtLname.getText();
            Bdate = txtBdate.getText();
            Address = txtAddress.getText();
            Sex = txtSex.getText();
            
            try{
                Salary = Integer.parseInt(txtSalary.getText());
                if(Salary < 0){
                    JOptionPane.showMessageDialog(this, "Salary should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Salary should be a positive number and not Empty");
                return;
            }
            
            Super_ssn = txtSuperssn.getText();   //Super_ssn can be empty
            
            try{
                Dno = Integer.parseInt(txtDno.getText());
                if(Dno < 0){
                    JOptionPane.showMessageDialog(this, "Dno should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Dno should be a positive number and not Empty");
                return;
            }
            
            if(Fname.equals("")){
                JOptionPane.showMessageDialog(this, "Fname should not be empty");
                return;
            }
            else if(Minit.equals("")){
                JOptionPane.showMessageDialog(this, "Minit should not be empty");
                return;
            }
            else if(Lname.equals("")){
                JOptionPane.showMessageDialog(this, "Lname should not be empty");
                return;
            }
            else if(Bdate.equals("")){
                JOptionPane.showMessageDialog(this, "Bdate should not be empty");
                return;
            }
            else if(Address.equals("")){
                JOptionPane.showMessageDialog(this, "Address should not be empty");
                return;
            }
            else if(Sex.equals("")){
                JOptionPane.showMessageDialog(this, "Sex should not be empty");
                return;
            }
            
            
            if (!txtSuperssn.getText().equals("")){
                pst = con.prepareStatement("INSERT INTO Employees (Ssn, Fname, Minit, Lname, Bdate, Address, Sex, Salary, Super_ssn, Dno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                
                pst.setInt(1, ssn);
                pst.setString(2, Fname);
                pst.setString(3, Minit);
                pst.setString(4, Lname);
                pst.setString(5, Bdate);
                pst.setString(6, Address);
                pst.setString(7, Sex);
                pst.setInt(8, Salary);
                pst.setString(9, Super_ssn);
                pst.setInt(10, Dno);
            }
            else{
                pst = con.prepareStatement("INSERT INTO Employees (Ssn, Fname, Minit, Lname, Bdate, Address, Sex, Salary, Dno) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
                pst.setInt(1, ssn);
                pst.setString(2, Fname);
                pst.setString(3, Minit);
                pst.setString(4, Lname);
                pst.setString(5, Bdate);
                pst.setString(6, Address);
                pst.setString(7, Sex);
                pst.setInt(8, Salary);
                pst.setInt(9, Dno);
            }
           
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "record inserted successfully");
                clearForm();
                LoadSsnData();
                fetchData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
             
        } catch (Exception ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String ssn = txtSearchSsn.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM Employees WHERE Ssn = ?");
            pst.setString(1, ssn);
            rs = pst.executeQuery();
            
            if(rs.next() == true){
                txtSsn.setText(rs.getString(1));
                txtFname.setText(rs.getString(2));
                txtMinit.setText(rs.getString(3));
                txtLname.setText(rs.getString(4));
                txtBdate.setText(rs.getString(5));
                txtAddress.setText(rs.getString(6));
                txtSex.setText(rs.getString(7));
                txtSalary.setText(rs.getString(8));
                txtSuperssn.setText(rs.getString(9));
                txtDno.setText(rs.getString(10));
            }
            else{
                JOptionPane.showMessageDialog(this, "No data to show");
            }
        } catch (Exception ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            int ssn = -1;
            String Fname = "";
            String Minit = "";
            String Lname = "";
            String Bdate = "";
            String Address = "";
            String Sex = "";
            int Salary = -1;
            String Super_ssn = "";
            int Dno = -1;
            
            try{
                ssn = Integer.parseInt(txtSsn.getText());
                if(ssn < 0){
                    JOptionPane.showMessageDialog(this, "Ssn should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Ssn should be a positive number and not Empty");
                return;
            }
            
            Fname = txtFname.getText();
            Minit = txtMinit.getText();
            Lname = txtLname.getText();
            Bdate = txtBdate.getText();
            Address = txtAddress.getText();
            Sex = txtSex.getText();
            
            try{
                Salary = Integer.parseInt(txtSalary.getText());
                if(Salary < 0){
                    JOptionPane.showMessageDialog(this, "Salary should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Salary should be a positive number and not Empty");
                return;
            }
            
            Super_ssn = txtSuperssn.getText();   //Super_ssn can be empty
            
            try{
                Dno = Integer.parseInt(txtDno.getText());
                if(Dno < 0){
                    JOptionPane.showMessageDialog(this, "Dno should be a positive number");
                    return;
                }
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(this, "Dno should be a positive number and not Empty");
                return;
            }
            
            if(Fname.equals("")){
                JOptionPane.showMessageDialog(this, "Fname should not be empty");
                return;
            }
            else if(Minit.equals("")){
                JOptionPane.showMessageDialog(this, "Minit should not be empty");
                return;
            }
            else if(Lname.equals("")){
                JOptionPane.showMessageDialog(this, "Lname should not be empty");
                return;
            }
            else if(Bdate.equals("")){
                JOptionPane.showMessageDialog(this, "Bdate should not be empty");
                return;
            }
            else if(Address.equals("")){
                JOptionPane.showMessageDialog(this, "Address should not be empty");
                return;
            }
            else if(Sex.equals("")){
                JOptionPane.showMessageDialog(this, "Sex should not be empty");
                return;
            }
            
            if (!txtSuperssn.getText().equals("")){
                pst = con.prepareStatement("UPDATE Employees SET Fname = ?, Minit = ?, Lname = ?, Bdate = ?, Address = ?, Sex = ?, Salary = ?, Super_ssn = ?, Dno = ? WHERE Ssn = ?");
            
                pst.setString(1, Fname);
                pst.setString(2, Minit);
                pst.setString(3, Lname);
                pst.setString(4, Bdate);
                pst.setString(5, Address);
                pst.setString(6, Sex);
                pst.setInt(7, Salary);
                pst.setString(8, Super_ssn);
                pst.setInt(9, Dno);
                pst.setInt(10, ssn);
            }
            else{
                pst = con.prepareStatement("UPDATE Employees SET Fname = ?, Minit = ?, Lname = ?, Bdate = ?, Address = ?, Sex = ?, Salary = ?, Dno = ? WHERE Ssn = ?");
            
                pst.setString(1, Fname);
                pst.setString(2, Minit);
                pst.setString(3, Lname);
                pst.setString(4, Bdate);
                pst.setString(5, Address);
                pst.setString(6, Sex);
                pst.setInt(7, Salary);
                pst.setInt(8, Dno);
                pst.setInt(9, ssn);
            }
           
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "record updated successfully");
                clearForm();
                LoadSsnData();
                fetchData();
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
             
        } catch (Exception ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String ssn = txtDeleteSsn.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM Employees WHERE Ssn = ?");
            
            pst.setString(1, ssn);
            
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "record Deleted successfully");
                LoadSsnData();
                fetchData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Failed");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtLnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLnameActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearForm();
    }//GEN-LAST:event_btnClearActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmployee;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBdate;
    private javax.swing.JComboBox<String> txtDeleteSsn;
    private javax.swing.JTextField txtDno;
    private javax.swing.JTextField txtFname;
    private javax.swing.JTextField txtLname;
    private javax.swing.JTextField txtMinit;
    private javax.swing.JTextField txtSalary;
    private javax.swing.JComboBox<String> txtSearchSsn;
    private javax.swing.JTextField txtSex;
    private javax.swing.JTextField txtSsn;
    private javax.swing.JTextField txtSuperssn;
    // End of variables declaration//GEN-END:variables
}
