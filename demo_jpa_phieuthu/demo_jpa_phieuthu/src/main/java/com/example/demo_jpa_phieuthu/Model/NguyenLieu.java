package com.example.demo_jpa_phieuthu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "nguyenlieu")
public class NguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nguyenlieuid;

    @Column(name = "tennguyenlieu")
    private String tenNguyenLieu;

    @Column(name = "giaban")
    private int giaBan;

    @Column(name = "donvitinn")
    private String donViTinh;

    @Column(name = "soluongkho")
    private int soLuongKho;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "loainguyenlieuid")
    @JsonIgnoreProperties("nguyenLieuList")
    private LoaiNguyenLieu loaiNguyenLieus;

    public int getNguyenlieuid() {
        return nguyenlieuid;
    }

    public void setNguyenlieuid(int nguyenlieuid) {
        this.nguyenlieuid = nguyenlieuid;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuongKho() {
        return soLuongKho;
    }

    public void setSoLuongKho(int soLuongKho) {
        this.soLuongKho = soLuongKho;
    }

    public LoaiNguyenLieu getLoaiNguyenLieus() {
        return loaiNguyenLieus;
    }

    public void setLoaiNguyenLieus(LoaiNguyenLieu loaiNguyenLieus) {
        this.loaiNguyenLieus = loaiNguyenLieus;
    }
}
