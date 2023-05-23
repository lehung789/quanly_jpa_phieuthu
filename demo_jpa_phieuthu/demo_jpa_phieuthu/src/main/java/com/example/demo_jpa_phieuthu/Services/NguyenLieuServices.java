package com.example.demo_jpa_phieuthu.Services;

import com.example.demo_jpa_phieuthu.Model.LoaiNguyenLieu;
import com.example.demo_jpa_phieuthu.Model.NguyenLieu;
import com.example.demo_jpa_phieuthu.Repository.LoaiNguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Repository.NguyenLieuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NguyenLieuServices implements INguyenLieuServices {
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    LoaiNguyenLieuRepo loaiNguyenLieuRepo;
    @Override
    public NguyenLieu themNgyenLieu(NguyenLieu nguyenlieumoi) {
        Optional<LoaiNguyenLieu> loaiNguyenLieu = loaiNguyenLieuRepo.findById(nguyenlieumoi.getLoaiNguyenLieus().getLoainguyenlieuid());
        if(loaiNguyenLieu.isEmpty()){
            return null;
        }
        else   nguyenLieuRepo.save(nguyenlieumoi);
        return nguyenlieumoi;
    }
}
