package com.linh.controller;

import com.linh.mode.Product;
import com.linh.model.dao.ImplementProduct;
import com.linh.model.dao.ProductDAO;
import com.linh.model.table.TableModel;
import com.linh.view.PanelForm;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author Thien Linh
 */
public class Controller {
    private final PanelForm panel;
    private List<Product> list;
    private final ImplementProduct implementProduct;
    
    public Controller(PanelForm panel) {
        this.panel = panel;
        implementProduct = new ProductDAO();
        list = implementProduct.getAllProduct();
    }
    
    public void reset(){
        panel.getTxtId().setText("");
        panel.getTxtHoVaTen().setText("");
        panel.getTxtTenDangNhap().setText("");
        panel.getTxtMatKhau().setText("");
        panel.getTxtSoDienThoai().setText("");
        panel.getTxtBienSoXe().setText("");
        panel.getTxtEmail().setText("");
        panel.getTxtKhac().setText("");
        
        
        panel.getjTable1().clearSelection();
    }
    
    public void isiTabel(){
        list = implementProduct.getAllProduct();
        panel.getjTable1().setModel(new TableModel(list));
        
    }
    
    public  void getDataField(){
        
        int row = panel.getjTable1().getSelectedRow();
        
        if (row != -1){
            
            panel.getTxtId().setText(list.get(row).getId());
            panel.getTxtHoVaTen().setText(list.get(row).getHoVaTen());
            panel.getTxtTenDangNhap().setText(list.get(row).getTenDangNhap());
            panel.getTxtMatKhau().setText(list.get(row).getMatKhau());
            panel.getTxtSoDienThoai().setText(list.get(row).getSoDienThoai());
            panel.getTxtBienSoXe().setText(list.get(row).getBienSoXe());
            panel.getTxtEmail().setText(list.get(row).getEmail());
            panel.getTxtKhac().setText(list.get(row).getKhac());
        }
       
    }
    
    public void insert(){
        
        Product product = new Product();
        product.setId(panel.getTxtId().getText());
        product.setHoVaTen(panel.getTxtHoVaTen().getText());
        product.setTenDangNhap(panel.getTxtTenDangNhap().getText());
        product.setMatKhau(panel.getTxtMatKhau().getText());
        product.setSoDienThoai(panel.getTxtSoDienThoai().getText());
        product.setBienSoXe(panel.getTxtBienSoXe().getText());
        product.setEmail(panel.getTxtEmail().getText());
        product.setKhac(panel.getTxtKhac().getText());
        
        implementProduct.input(product);
    }

    public void update(){
        
        Product product = new Product();
        product.setId(panel.getTxtId().getText());
        product.setHoVaTen(panel.getTxtHoVaTen().getText());
        product.setTenDangNhap(panel.getTxtTenDangNhap().getText());
        product.setMatKhau(panel.getTxtMatKhau().getText());
        product.setSoDienThoai(panel.getTxtSoDienThoai().getText());
        product.setBienSoXe(panel.getTxtBienSoXe().getText());
        product.setEmail(panel.getTxtEmail().getText());
        product.setKhac(panel.getTxtKhac().getText());
        
        implementProduct.update(product);
    
    }
    
    public void delete(){
        
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Khong co du lieu de xoa....? ",null, JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String ID = panel.getTxtId().getText();
        
        implementProduct.delete(ID);
        
    }
    
    
    public void getData(){
        
        if (panel.getTxtId().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(panel, "Dien ten vao du lieu ban muon tim kiem ? ", null, JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String nama = panel.getTxtId().getText();
        
        implementProduct.getProduct(nama);
        isiTabelCari(nama);
    }

   public void isiTabelCari(String ID){
        
        list = implementProduct.getProduct(ID);
        panel.getjTable1().setModel(new TableModel(list));
    }
}