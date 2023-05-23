package com.example.demo_jpa_phieuthu.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "loainguyenlieu")
public class LoaiNguyenLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loainguyenlieuid;

    @Column(name = "tenloai")
    private String tenLoai;

    @Column(name = "mota")
    private String moTa;

    @OneToMany(mappedBy = "loaiNguyenLieus", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("loaiNguyenLieus")
    private List<NguyenLieu> nguyenLieuList;

    public int getLoainguyenlieuid() {
        return loainguyenlieuid;
    }

    public void setLoainguyenlieuid(int loainguyenlieuid) {
        this.loainguyenlieuid = loainguyenlieuid;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public List<NguyenLieu> getNguyenLieuList() {
        return nguyenLieuList;
    }

    public void setNguyenLieuList(List<NguyenLieu> nguyenLieuList) {
        this.nguyenLieuList = nguyenLieuList;
    }
}
