package com.example.demo_jpa_phieuthu.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitietphieuthu")

public class ChiTietPhieuThu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int chitietphieuthuid;

    @Column(name = "soluongban")
    private int soLuongBan;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "phieuthuid")
    private PhieuThu phieuThus;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nguyenlieuid")
    private NguyenLieu nguyenLieus;

    public int getChitietphieuthuid() {
        return chitietphieuthuid;
    }

    public void setChitietphieuthuid(int chitietphieuthuid) {
        this.chitietphieuthuid = chitietphieuthuid;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public PhieuThu getPhieuThus() {
        return phieuThus;
    }

    public void setPhieuThus(PhieuThu phieuThus) {
        this.phieuThus = phieuThus;
    }

    public NguyenLieu getNguyenLieus() {
        return nguyenLieus;
    }

    public void setNguyenLieus(NguyenLieu nguyenLieus) {
        this.nguyenLieus = nguyenLieus;
    }
}
