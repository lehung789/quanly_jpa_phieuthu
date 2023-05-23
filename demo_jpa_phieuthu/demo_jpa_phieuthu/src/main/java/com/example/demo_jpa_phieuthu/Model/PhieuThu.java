package com.example.demo_jpa_phieuthu.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pheiuthu")
public class PhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  phieuthuid;

    @Column(name = " ngaylap")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate ngayLap;

    @Column(name = "nhanvienlap")
    private String nhanVienLap;

    @Column(name = "ghichu")
    private String ghiChu;

    @Column(name = "thanhtien")
    private int thanhTien;

    @OneToMany(mappedBy = "phieuThus",cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "phieuThus")
    List<ChiTietPhieuThu> chiTietPhieuThuList;

    public int getPhieuthuid() {
        return phieuthuid;
    }

    public void setPhieuthuid(int phieuthuid) {
        this.phieuthuid = phieuthuid;
    }

    public LocalDate getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(LocalDate ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNhanVienLap() {
        return nhanVienLap;
    }

    public void setNhanVienLap(String nhanVienLap) {
        this.nhanVienLap = nhanVienLap;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(int thanhTien) {
        this.thanhTien = thanhTien;
    }

    public List<ChiTietPhieuThu> getChiTietPhieuThuList() {
        return chiTietPhieuThuList;
    }

    public void setChiTietPhieuThuList(List<ChiTietPhieuThu> chiTietPhieuThuList) {
        this.chiTietPhieuThuList = chiTietPhieuThuList;
    }
}
