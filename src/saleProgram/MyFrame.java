package saleProgram;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class MyFrame extends JFrame{
	Connection conn=null;
	PreparedStatement state=null;
	ResultSet result=null;
	int id=-1;	
	
	JPanel clientP=new JPanel();
	JPanel productP=new JPanel();
	JPanel saleP=new JPanel();
	JPanel searchP=new JPanel();
	 
	JPanel clientUpP=new JPanel();
	JPanel clientMidP=new JPanel();
	JPanel clientDownP=new JPanel();
	
	JPanel productUpP=new JPanel();
	JPanel productMidP=new JPanel();
	JPanel productDownP=new JPanel();
	
	JLabel nameL=new JLabel("Контрагент:");
	JTextField nameTF=new JTextField();
	JLabel cityL=new JLabel("Град:");
	JTextField cityTF=new JTextField();
	JLabel addressL=new JLabel("Адрес:");
	JTextField addressTF=new JTextField();
	JLabel bulstatL=new JLabel("Булстат:");
	JTextField bulstatTF=new JTextField();
	JLabel ownerL=new JLabel("М.О.Л.:");
	JTextField ownerTF=new JTextField();
	
	JLabel productNameL=new JLabel("Име:");
	JTextField productNameTF=new JTextField();
	JLabel deliveryPriceL=new JLabel("Доставна цена:");
	JTextField deliveryPriceTF=new JTextField();
	JLabel priceL=new JLabel("Продажна цена:");
	JTextField priceTF=new JTextField();
	JLabel quantityL=new JLabel("Количество:");
	JTextField quantityTF=new JTextField();
	JLabel deliveryL=new JLabel("Доставчик:");
	JTextField deliveryTF=new JTextField();
	

	
	JButton addClientBtn=new JButton( "Добави");
	JButton editClientBtn=new JButton( "Редактирай");
	JButton deleteClientBtn=new JButton( "Изтрий");
	
	JButton addProductBtn=new JButton( "Добави");
	JButton editProductBtn=new JButton( "Редактирай");
	JButton deleteProductBtn=new JButton( "Изтрий");
	
	JTable clientsTable= new JTable();
	JScrollPane clientsScroll=new JScrollPane(clientsTable);
	
	JTable productsTable=new JTable();
	JScrollPane productsScroll=new JScrollPane(productsTable);
   
	
	//Sale Panel
	JPanel chooseClientP=new JPanel();
	JPanel chooseProductP=new JPanel();
	JPanel addToCartP=new JPanel();
	JPanel cartP=new JPanel();
	JPanel totalP=new JPanel();
	JPanel paymentP=new JPanel();
	JPanel saleButtonsP=new JPanel();
	JPanel dbP=new JPanel();
	
    JLabel clientL=new JLabel("Клиент:");
	JComboBox<String> companyCombo=new JComboBox<String>();
	
	JLabel productL=new JLabel("Продукт");
	JComboBox<String> productsCombo=new JComboBox<String>();
	JLabel saleQuantityL=new JLabel("Количество");
	JTextField saleQuantityTF=new JTextField();
	JLabel salePriceL=new JLabel("Цена");
	JTextField salePriceTF=new JTextField();
	
	JButton addToCartBtn=new JButton("Добави");
	JButton deleteCartBtn=new JButton("Премахни");
	
	JTable cartTable=new JTable();
	JScrollPane cartScroll=new JScrollPane(cartTable);

	JLabel totalL=new JLabel("Общо дължими");
	JLabel totalPriceL=new JLabel();
	
	ButtonGroup  radioButtons=new ButtonGroup();
	JRadioButton cashRB=new JRadioButton("Плащане в брой");
	JRadioButton bankRB= new JRadioButton("Плащане по банков път");
		
	JButton saveBtn=new JButton("ПРОДАЖБА");
	JButton editBtn=new JButton("Редактирай");
	JButton deleteBtn=new JButton("Изтрий");
	
	JTable saleTable=new JTable();
	JScrollPane saleScroll=new JScrollPane(saleTable);
	
	//search Panel
	JPanel searchSaleByCompanyP=new JPanel();
	JPanel searchProductsByDeliveryP=new JPanel();
	JPanel searchCompanyByOwnerP=new JPanel();
	JPanel searchByCompanyAndDateP=new JPanel();
	JPanel resultP=new JPanel();
	
	JLabel searchSaleByCompanyL=new JLabel("Избери фирма и намери всички нейни поръчки");
	JComboBox<String> companySearchCombo=new JComboBox<String>();
	JButton searchSaleByCompanyBtn=new JButton("Търси");
	
	JLabel searchProductL=new JLabel("Въведи доставчик и намери всички продукти, които доставя той");
	JTextField insertDeliveryTF=new JTextField();
	JButton searchProductBtn=new JButton("Търси");
	
	JLabel searchCompanyL=new JLabel("Въведи собственик и намери всички негови фирми");
	JTextField insertOwnerTF=new JTextField();
	JButton searchCompanyBtn=new JButton("Търси");
	
	JLabel insertCompanyL=new JLabel("Въведи фирма");
	JTextField insertCompanyTF=new JTextField();
	JLabel insertDateL=new JLabel("Въведи дата");
	JTextField insertDateTF=new JTextField();
	JButton searchByCompanyAndDateBtn=new JButton("Търси");
	
	JTable resultTable=new JTable();
	JScrollPane resultScroll=new JScrollPane(resultTable);
	
	JTabbedPane tab=new JTabbedPane();
	
	public MyFrame() {
		this.setSize(800,900);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tab.add(clientP,"Нов клиент");
		tab.add(productP,"Нов продукт");
		tab.add(saleP,"Продажба");
		tab.add(searchP,"Справки");
		
		//Client Panel
		clientP.setLayout(new GridLayout(3,1));
		
		//Client UP panel
		clientUpP.setLayout(new GridLayout(5,2));
		clientUpP.add(nameL);
		clientUpP.add(nameTF);
		clientUpP.add(cityL);
		clientUpP.add(cityTF);
		clientUpP.add(addressL);
		clientUpP.add(addressTF);
		clientUpP.add(bulstatL);
		clientUpP.add(bulstatTF);
		clientUpP.add(ownerL);
		clientUpP.add(ownerTF);
		
		
		//Client Mid Panel
		clientMidP.add(addClientBtn);
		addClientBtn.addActionListener(new AddClient());
		clientMidP.add(editClientBtn);
		editClientBtn.addActionListener(new EditClient());
		clientMidP.add(deleteClientBtn);
		deleteClientBtn.addActionListener(new DeleteClient());
		

		//Client Down Panel
		clientsScroll.setPreferredSize(new Dimension(750,200));
		clientDownP.add(clientsScroll);
		clientsTable.addMouseListener(new MouseClientAction());
		
		
		clientP.add(clientUpP);
		clientP.add(clientMidP);   
		clientP.add(clientDownP);
		
		refreshClientsTable();
		
		
		//Product panel
		productP.setLayout(new GridLayout(3,1));
		
		//Product UP panel
		productUpP.setLayout(new GridLayout(5,2));
		productUpP.add(productNameL);
		productUpP.add(productNameTF);
		productUpP.add(deliveryPriceL);
		productUpP.add(deliveryPriceTF);
		productUpP.add(priceL);
		productUpP.add(priceTF);
		productUpP.add(quantityL);
		productUpP.add(quantityTF);
		productUpP.add(deliveryL);
		productUpP.add(deliveryTF);
		
		
		//Product MID panel
		productMidP.add(addProductBtn);
		addProductBtn.addActionListener(new AddProduct());
		productMidP.add(editProductBtn);
		editProductBtn.addActionListener(new EditProduct());
		productMidP.add(deleteProductBtn);
		deleteProductBtn.addActionListener(new DeleteProduct());
		
		//Product DOWN panel
		productsScroll.setPreferredSize(new Dimension(750,200));
		productDownP.add(productsScroll);
		productsTable.addMouseListener(new MouseProductAction());
		refreshProductTable();
		
		productP.add(productUpP);
		productP.add(productMidP);
		productP.add(productDownP);
		
		
		//Sale Panel
		saleP.setLayout(new GridLayout(8,1));
		
		//Choose client panel
		chooseClientP.setLayout(new GridLayout(1,2));
		chooseClientP.add(clientL);	
		chooseClientP.add(companyCombo);
		refreshCompanyCombo();

		//Choose product Panel
		chooseProductP.setLayout(new GridLayout(2,3));
		chooseProductP.add(productL);
		chooseProductP.add(saleQuantityL);
		chooseProductP.add(salePriceL);
		chooseProductP.add(productsCombo);
		refreshProductsCombo();
		chooseProductP.add(saleQuantityTF);
		chooseProductP.add(salePriceTF);
		productsCombo.addActionListener(new DefaultPrice());
		
		//addToCartP
		addToCartP.setLayout(new GridLayout(1,2));
		addToCartP.add(addToCartBtn);
		addToCartBtn.addActionListener(new AddToCart());
		addToCartP.add(deleteCartBtn);
		deleteCartBtn.addActionListener(new DeleteCartItem());
		
		//cartP
		cartP.setLayout(new GridLayout(1,1));
		cartP.add(cartScroll);
		addColumn();
		
		//total panel
		totalP.setLayout(new GridLayout(1,2));
		totalP.add(totalL);
		totalP.add(totalPriceL);
		
		//payment panel
		paymentP.setLayout(new GridLayout(1,2));
		radioButtons.add(cashRB);
		radioButtons.add(bankRB);
		paymentP.add(cashRB);
		paymentP.add(bankRB);
		
		//sale Buttons panel
		saleButtonsP.setLayout(new GridLayout(1,3));
		saleButtonsP.add(saveBtn);
	    saveBtn.addActionListener(new SavePurchase());
	    saleButtonsP.add(editBtn);
	    editBtn.addActionListener(new EditSale());
	    saleButtonsP.add(deleteBtn);
	    deleteBtn.addActionListener(new DeleteSale());
		
		//Db panel
		dbP.setLayout(new GridLayout(1,1));
		dbP.add(saleScroll);
		saleTable.addMouseListener(new MouseSaleAction());
		refreshSaleTable();
		
		saleP.add(chooseClientP);
		saleP.add(chooseProductP);
		saleP.add(addToCartP);
		saleP.add(cartP);
		saleP.add(totalP);
		saleP.add(paymentP);
		saleP.add(saleButtonsP);
		saleP.add(dbP);
		
		//search panel
		searchP.setLayout(new GridLayout(5,1));
		
		searchSaleByCompanyP.setLayout(new GridLayout(3,1));
		searchSaleByCompanyP.add(searchSaleByCompanyL);
		searchSaleByCompanyP.add(companySearchCombo);
		refreshCompanySearchCombo();
		searchSaleByCompanyP.add(searchSaleByCompanyBtn);
		searchSaleByCompanyBtn.addActionListener(new SearchSaleByCompany());
		
		searchProductsByDeliveryP.setLayout(new GridLayout(3,1));
		searchProductsByDeliveryP.add(searchProductL);
		searchProductsByDeliveryP.add(insertDeliveryTF);
		searchProductsByDeliveryP.add(searchProductBtn);
		searchProductBtn.addActionListener(new SearchProductsByDelivery());
		
		searchCompanyByOwnerP.setLayout(new GridLayout(3,1));
		searchCompanyByOwnerP.add(searchCompanyL);
		searchCompanyByOwnerP.add(insertOwnerTF);
		searchCompanyByOwnerP.add(searchCompanyBtn);
		searchCompanyBtn.addActionListener(new SearchCompanyByOwner());
	
		searchByCompanyAndDateP.setLayout(new GridLayout(3,2));
		searchByCompanyAndDateP.add(insertCompanyL);
		searchByCompanyAndDateP.add(insertCompanyTF);
		searchByCompanyAndDateP.add(insertDateL);
		searchByCompanyAndDateP.add(insertDateTF);
		searchByCompanyAndDateP.add(searchByCompanyAndDateBtn);
		searchByCompanyAndDateBtn.addActionListener(new SearchByCompanyAndDate());
		
		resultP.setLayout(new GridLayout(1,1));
		resultP.add(resultScroll);
		
		searchP.add(searchSaleByCompanyP);
		searchP.add(searchProductsByDeliveryP);
		searchP.add(searchCompanyByOwnerP);
		searchP.add(searchByCompanyAndDateP);
		searchP.add(resultP);
	
		this.add(tab);
		this.setVisible(true);
	}
	
	public void refreshClientsTable() {
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement("select * from company");
			result=state.executeQuery();
			clientsTable.setModel(new MyModel(result));
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshProductTable() {
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement("select * from products");
			result=state.executeQuery();
			productsTable.setModel(new MyModel(result));
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void refreshSaleTable() {
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement("select * from sale");
			result=state.executeQuery();
			saleTable.setModel(new MyModel(result));
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void clearClientForm() {
		nameTF.setText("");
		cityTF.setText("");
		addressTF.setText("");
		bulstatTF.setText("");
		ownerTF.setText("");
	}

	public void clearProductForm() {
		productNameTF.setText("");
		deliveryPriceTF.setText("");
		priceTF.setText("");
		quantityTF.setText("");
		deliveryTF.setText("");
	}
	
	public void clearSaleForm() {

		saleQuantityTF.setText("");
		salePriceTF.setText("");
		totalPriceL.setText("");
		radioButtons.clearSelection();
		
		
		DefaultTableModel model= new DefaultTableModel();
		model=(DefaultTableModel)cartTable.getModel();
		for(int i=0;i<cartTable.getRowCount();i++) {
			model.removeRow(i);
			i--;
		}
		
	}
	public void refreshCompanyCombo() {
		String sql="select name from company order by name";
		conn=DBConnection.getConnection();
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			companyCombo.removeAllItems();
			while(result.next()) {
				item=result.getObject(1).toString();
				companyCombo.addItem(item);
			}
		
		}catch(SQLException ex){
			ex.printStackTrace();
		} 
	}
	
	public void refreshCompanySearchCombo() {
		String sql="select name from company order by name";
		conn=DBConnection.getConnection();
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			companySearchCombo.removeAllItems();
			while(result.next()) {
				item=result.getObject(1).toString();
				companySearchCombo.addItem(item);
			}
		
		}catch(SQLException ex){
			ex.printStackTrace();
		} 
	}
	
	public void refreshProductsCombo() {
		String sql="select product_name from products order by product_name";
		conn=DBConnection.getConnection();
		String item="";
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			productsCombo.removeAllItems();
			while(result.next()) {
				item=result.getObject(1).toString();
				productsCombo.addItem(item);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void addColumn(){
		DefaultTableModel model= new DefaultTableModel();
		
		model=(DefaultTableModel)cartTable.getModel();
		model.addColumn("Продукт");
		model.addColumn("Количество");
		model.addColumn("Ед. цена");
		model.addColumn("Общо");
	}

	public int findProductId(int i) {
		int product_id=0;
		String productName= cartTable.getValueAt(i, 0).toString();
		String sql="select id from products where product_name='"+productName+"'";
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				product_id=Integer.parseInt(result.getObject(1).toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return product_id;
	}

	public String findPaymentType() {
		String paymentType="";

		if(cashRB.isSelected()) {
			paymentType="Плащане в брой";
		}else if(bankRB.isSelected()) {
			paymentType="Плащане по банков път";
		}
		
		return paymentType;
	}
	
	public int findCompanyId() {
		int companyId=0;
		String choosenCompany=companyCombo.getSelectedItem().toString();
		String sql="select id from company where name='"+choosenCompany+"'";
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				companyId=Integer.parseInt(result.getObject(1).toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return companyId;
	}
	
	public int findCompanySearchId() {
		int companyId=0;
		String choosenCompany=companySearchCombo.getSelectedItem().toString();
		String sql="select id from company where name='"+choosenCompany+"'";
		conn=DBConnection.getConnection();
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				companyId=Integer.parseInt(result.getObject(1).toString());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return companyId;
	}
	
	public void DeleteAllCompaniesWithSpecialId(int id) {
		conn=DBConnection.getConnection();
		String sql="delete from sale where company_id=?";
		
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1,id);
			state.execute();
			refreshSaleTable();
			clearSaleForm();
			id=-1;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public void DeleteAllProductsWithSpecialId(int id) {
		conn=DBConnection.getConnection();
		String sql="delete from sale where product_id=?";
		
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1,id);
			state.execute();
			refreshSaleTable();
			clearSaleForm();
			id=-1;
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public String FindCompanyByID(int row) {
		String company="";
		int companyID=Integer.parseInt(saleTable.getValueAt(row,1).toString());
		conn=DBConnection.getConnection();
		String sql="select name from company where id="+companyID;
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				company=result.getObject(1).toString();
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return company;
	}
	
	public String FindProductByID(int row) {
		String product="";
		int productId=Integer.parseInt(saleTable.getValueAt(row,2).toString());
		conn=DBConnection.getConnection();
		String sql="select product_name from products where id="+productId;
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
				product=result.getObject(1).toString();
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return product;
	}
	public Integer findCurrentQuantity(int id) {
		int currentQuantity=0;
		conn=DBConnection.getConnection();
		String sql="select quantity from products where id="+id;
		
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			while(result.next()) {
			currentQuantity=Integer.parseInt(result.getObject(1).toString());
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return currentQuantity;
	}
	public void UpdateQuantity(int quantity , int id) {
		int updateQuantity=findCurrentQuantity(id)-quantity;
		conn=DBConnection.getConnection();
		String sql="update products set quantity=? where id=?";
		
		try {
			state=conn.prepareStatement(sql);
			state.setInt(1, updateQuantity);
			state.setInt(2,id);
			state.execute();
			refreshProductTable();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
	class AddClient implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			String sql="insert into company(name,city,address,bulstat,owner) values(?,?,?,?,?)";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1,nameTF.getText());
				state.setString(2,cityTF.getText());
				state.setString(3,addressTF.getText());
				state.setString(4,bulstatTF.getText());
				state.setString(5,ownerTF.getText());
				
				state.execute();
				refreshClientsTable();
				refreshCompanyCombo();
				refreshCompanySearchCombo();
				clearClientForm();
	
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	
	class AddProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="insert into products (product_name,delivery_price,price,quantity,delivery) values(?,?,?,?,?)";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1,productNameTF.getText());
				state.setDouble(2, Double.parseDouble(deliveryPriceTF.getText()));
				state.setDouble(3,Double.parseDouble(priceTF.getText()));
				state.setInt(4, Integer.parseInt(quantityTF.getText()));
				state.setString(5, deliveryTF.getText());
				
				state.execute();
				refreshProductTable();
				productsCombo.removeAllItems();
				clearProductForm();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	class DefaultPrice implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(productsCombo.getItemCount()>0) {
			String productName=productsCombo.getSelectedItem().toString();
			conn=DBConnection.getConnection();
			
			String sql="select * from products where product_name='"+productName+"'";
			
			String price="";
			
			try {	
				state=conn.prepareStatement(sql);
				result=state.executeQuery();
				if(result.next()) {
		        price=result.getDouble(4)+"";
				}
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			salePriceTF.setText(price);
			}else {
				refreshProductsCombo();
			}
		}
		
	}
	class MouseClientAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=clientsTable.getSelectedRow();
			id=Integer.parseInt(clientsTable.getValueAt(row, 0).toString());
			nameTF.setText(clientsTable.getValueAt(row, 1).toString());
			cityTF.setText(clientsTable.getValueAt(row, 2).toString());
			addressTF.setText(clientsTable.getValueAt(row, 3).toString());
			bulstatTF.setText(clientsTable.getValueAt(row, 4).toString());
			ownerTF.setText(clientsTable.getValueAt(row, 5).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	class MouseProductAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=productsTable.getSelectedRow();
			id=Integer.parseInt(productsTable.getValueAt(row, 0).toString());
			productNameTF.setText(productsTable.getValueAt(row, 1).toString());
			deliveryPriceTF.setText(productsTable.getValueAt(row, 2).toString());
			priceTF.setText(productsTable.getValueAt(row, 3).toString());
			quantityTF.setText(productsTable.getValueAt(row, 4).toString());
			deliveryTF.setText(productsTable.getValueAt(row, 5).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}		
	}
	
	class MouseSaleAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			int row=saleTable.getSelectedRow();
			id=Integer.parseInt(saleTable.getValueAt(row, 0).toString());
			saleQuantityTF.setText(saleTable.getValueAt(row, 3).toString());
			salePriceTF.setText(saleTable.getValueAt(row, 4).toString());
		
			if(saleTable.getValueAt(row, 6).toString().equals("Плащане в брой")){
				cashRB.setSelected(true);
			}else if(saleTable.getValueAt(row, 6).toString().equals("Плащане по банков път")) {
				bankRB.setSelected(true);
			}
			String company=FindCompanyByID(row);
			companyCombo.setSelectedItem(company);
			
			String product=FindProductByID(row);
			productsCombo.setSelectedItem(product);
		
		}
		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	class DeleteClient implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteAllCompaniesWithSpecialId(id);
			conn=DBConnection.getConnection();
			String sql="delete from company where id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				state.execute();
				refreshClientsTable();
				refreshCompanyCombo();
				refreshCompanySearchCombo();
				clearClientForm();
				id=-1;
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
	
	class DeleteProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DeleteAllProductsWithSpecialId(id);
			conn=DBConnection.getConnection();
			String sql="delete from products where id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				state.execute();
				refreshProductTable();
				productsCombo.removeAllItems();
				clearProductForm();
				id=-1;
			}catch (SQLException ex){
				ex.printStackTrace();
			}
			
		}
		
	}
	class EditClient implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="update company set name=?, city=?, address=?,bulstat=?,owner= ? where id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1,nameTF.getText());
				state.setString(2, cityTF.getText());
				state.setString(3, addressTF.getText());
				state.setString(4, bulstatTF.getText());
				state.setString(5, ownerTF.getText());
				state.setInt(6,id);
				
				state.execute();
				refreshClientsTable();
				refreshCompanyCombo();
				refreshCompanySearchCombo();
				clearClientForm();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	class EditProduct implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="update products set product_name=?,delivery_price=?,price=?,quantity=?,delivery=? where id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1,productNameTF.getText());
				state.setDouble(2, Double.parseDouble(deliveryPriceTF.getText()));
				state.setDouble(3, Double.parseDouble(priceTF.getText()));
				state.setInt(4, Integer.parseInt(quantityTF.getText()));
				state.setString(5,deliveryTF.getText());
				state.setInt(6, id);
				
				state.execute();
				refreshProductTable();
			    productsCombo.removeAllItems();
				clearProductForm();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	class AddToCart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			DefaultTableModel model= new DefaultTableModel();
			
			model=(DefaultTableModel)cartTable.getModel();
		
			model.addRow(new Object[] {
					productsCombo.getSelectedItem().toString(),
					saleQuantityTF.getText(),
					salePriceTF.getText(),
					Integer.parseInt(saleQuantityTF.getText())* Double.parseDouble(salePriceTF.getText())
					
			});
			
			double sum=0.0;
			for(int i=0;i<cartTable.getRowCount();i++) {
				sum+= Double.parseDouble(cartTable.getValueAt(i, 3).toString());
			}
			
			totalPriceL.setText(sum+"");
		}
		
	}
	
	class DeleteCartItem implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int selectedRow=cartTable.getSelectedRow();
			
			DefaultTableModel model= new DefaultTableModel();
			model=(DefaultTableModel)cartTable.getModel();
		
			model.removeRow(selectedRow);
			
		}	
	}
	
	class SavePurchase implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			for(int i=0; i<cartTable.getRowCount();i++) {
			conn=DBConnection.getConnection();
			
			int companyId=findCompanyId();
			int productId=findProductId(i);
			int quantityF=Integer.parseInt(cartTable.getValueAt(i,1).toString());
			double priceF=Double.parseDouble(cartTable.getValueAt(i,2).toString());
			double totalPriceF=Double.parseDouble(cartTable.getValueAt(i,3).toString());
			String paymentF=findPaymentType();
			long millis=System.currentTimeMillis();
			Date purchaseDate= new Date(millis);
			
			String sql ="insert into sale  (company_id,product_id,quantity,price,total_price,payment_type,purchase_date) values("+companyId+","+productId+","+quantityF+","+priceF+","+totalPriceF+",'"+paymentF+"','"+purchaseDate+"');";
			UpdateQuantity(quantityF,productId);
			
			try {
				state=conn.prepareStatement(sql);
				state.execute();
	
				
			}catch(SQLException ex){
				ex.printStackTrace();
			}
			
			}
			
			refreshCompanyCombo();	
			refreshSaleTable();
			clearSaleForm();
		
		
	}	
}
	class EditSale implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			
			int companyId=findCompanyId();
			int productId=findProductId(0);
			int quantityF=Integer.parseInt(cartTable.getValueAt(0,1).toString());
			double priceF=Double.parseDouble(cartTable.getValueAt(0,2).toString());
			double totalPriceF=Double.parseDouble(cartTable.getValueAt(0,3).toString());
			String paymentF=findPaymentType();
			long millis=System.currentTimeMillis();
			Date purchaseDate= new Date(millis);
			
			String sql="update sale set company_id="+companyId+",product_id="+productId+",quantity="+quantityF+",price="+priceF+",total_price="+totalPriceF+",payment_type='"+paymentF+"',purchase_date='"+purchaseDate+"'where id="+id+";";
			
			try {
				state=conn.prepareStatement(sql);
				state.execute();
				refreshSaleTable();
				clearSaleForm();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	class DeleteSale implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="delete from sale where id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setInt(1,id);
				state.execute();
				refreshSaleTable();
				clearSaleForm();
				id=-1;
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class SearchSaleByCompany implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			int id=findCompanySearchId() ;
			
			conn=DBConnection.getConnection();
			String sql="select * from sale where company_id=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setInt(1, id);
				result=state.executeQuery();
				resultTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class SearchProductsByDelivery implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="select * from products where delivery=?";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1, insertDeliveryTF.getText());
				result=state.executeQuery();
				resultTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class SearchCompanyByOwner implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="select * from company where owner=?;";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1, insertOwnerTF.getText());
				result=state.executeQuery();
				resultTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class SearchByCompanyAndDate implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			conn=DBConnection.getConnection();
			String sql="select c.name,c.bulstat,s.product_id ,s.quantity,s.purchase_date from sale s inner join company  c on s.company_id=c.id where c.name=? and s.purchase_date=?;";
			
			try {
				state=conn.prepareStatement(sql);
				state.setString(1, insertCompanyTF.getText());
				state.setString(2,insertDateTF.getText() );
				result=state.executeQuery();
				resultTable.setModel(new MyModel(result));
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}


