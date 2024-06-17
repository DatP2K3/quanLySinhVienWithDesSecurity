/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhviendes;

import java.util.ArrayList;

/**
 *
 * @author datph
 */
public class SinhVien {
    private String maSV;
    private String hoTenSV;
    private String gioiTinh;
    private int tuoi;
    private String lop;
    private String khoa;
    private String email;
    private String sdt;
    private String diaChi;
    private String hinhAnh;
    public static ArrayList<SinhVien> lsv = new ArrayList<>();
    
    public SinhVien(String maSV, String nameSV, String gioiTinh, int tuoi, String classSV, String khoa, String email, String sdt, String address, String hinhAnh) {
        this.maSV = maSV;
        this.hoTenSV = nameSV;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.lop = classSV;
        this.khoa= khoa;
        this.email = email;
        this.sdt = sdt;
        this.diaChi = address;
        this.hinhAnh = hinhAnh;
    }
    
    public String getMaSV() {
       return maSV;
    }

    public String getHoTenSV() {
       return hoTenSV;
    }

    public String getGioiTinh() {
       return gioiTinh;
    }

    public int getTuoi() {
       return tuoi;
    }

    public String getLop() {
       return lop;
    }

    public String getKhoa() {
       return khoa;
    }

    public String getEmail() {
       return email;
    }

    public String getSdt() {
       return sdt;
    }

    public String getDiaChi() {
       return diaChi;
    }

    public String getHinhAnh() {
       return hinhAnh;
    }
    
    public void setMaSV(String maSV) {
       this.maSV = maSV;
    }

    public void setHoTenSV(String hoTenSV) {
       this.hoTenSV = hoTenSV;
    }

    public void setGioiTinh(String gioiTinh) {
       this.gioiTinh = gioiTinh;
    }

    public void setTuoi(int tuoi) {
       this.tuoi = tuoi;
    }

    public void setLop(String lop) {
       this.lop = lop;
    }

    public void setKhoa(String khoa) {
       this.khoa = khoa;
    }

    public void setEmail(String email) {
       this.email = email;
    }

    public void setSdt(String sdt) {
       this.sdt = sdt;
    }

    public void setDiaChi(String diaChi) {
       this.diaChi = diaChi;
    }
    
    public void setHinhAnh(String hinhAnh) {
       this.hinhAnh = hinhAnh;
    }
    
    public static SinhVien getSinhVienByMaSV(String MaSV) {
        for(SinhVien sv : lsv) {
            if(sv.getMaSV().equalsIgnoreCase(MaSV)) {
                return sv;
            }
        }
        return null;
    }
    
    public static boolean deleteSVByMaSV(String MaSV) {
        for(SinhVien sv : lsv) {
            if(sv.getMaSV().equalsIgnoreCase(MaSV)) {
                lsv.remove(sv);
                return true;
            }
        }
        return false;
    }
    
    public static boolean updateSVByMaSV(String MaSV, SinhVien newSV) {
        for(SinhVien sv : lsv) {
            if(sv.getMaSV().equalsIgnoreCase(MaSV)) {
                sv.setHoTenSV(newSV.getHoTenSV());
                sv.setGioiTinh(newSV.getGioiTinh());
                sv.setTuoi(newSV.getTuoi());
                sv.setLop(newSV.getLop());
                sv.setKhoa(newSV.getKhoa());
                sv.setEmail(newSV.getEmail());
                sv.setSdt(newSV.getSdt());
                sv.setDiaChi(newSV.getDiaChi());
                sv.setHinhAnh(newSV.getHinhAnh());
                return true;
            }
        }
        return false;
    }
}
