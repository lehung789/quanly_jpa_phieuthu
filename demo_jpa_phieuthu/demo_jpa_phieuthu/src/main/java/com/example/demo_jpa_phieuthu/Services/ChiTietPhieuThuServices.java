package com.example.demo_jpa_phieuthu.Services;

import com.example.demo_jpa_phieuthu.Model.ChiTietPhieuThu;
import com.example.demo_jpa_phieuthu.Model.NguyenLieu;
import com.example.demo_jpa_phieuthu.Model.PhieuThu;
import com.example.demo_jpa_phieuthu.Repository.ChiTietPhieuThuRepo;
import com.example.demo_jpa_phieuthu.Repository.NguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Repository.PhieuThuRepo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChiTietPhieuThuServices  implements IChiTietPhieuThuServices{
    @Autowired
    ChiTietPhieuThuRepo chiTietPhieuThuRepo;
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    PhieuThuRepo phieuThuRepo;
    @Override
    public ChiTietPhieuThu phieuthumoi(ChiTietPhieuThu chitiet) {
        Optional<NguyenLieu> nguyenLieuOp = nguyenLieuRepo.findById(chitiet.getNguyenLieus().getNguyenlieuid());
       if(nguyenLieuOp.isEmpty())
       {
           return  null;
       }
       Optional<PhieuThu> phieuThuOp = phieuThuRepo.findById(chitiet.getPhieuThus().getPhieuthuid());
       if(phieuThuOp.isEmpty())
       {
           return null;
       }
       NguyenLieu nguyenLieu = nguyenLieuOp.get();
       PhieuThu phieuThu = phieuThuOp.get();
       if(nguyenLieu.getSoLuongKho() > chitiet.getSoLuongBan())
       {
           chiTietPhieuThuRepo.save(chitiet);

           phieuThu.setThanhTien(phieuThu.getThanhTien() + chitiet.getSoLuongBan()*nguyenLieu.getGiaBan());
           phieuThuRepo.save(phieuThu);

           nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - chitiet.getSoLuongBan());
           nguyenLieuRepo.save(nguyenLieu);
       }
        return chitiet;
    }
}
