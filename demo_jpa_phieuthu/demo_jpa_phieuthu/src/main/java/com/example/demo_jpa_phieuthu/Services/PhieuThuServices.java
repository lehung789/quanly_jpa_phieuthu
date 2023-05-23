package com.example.demo_jpa_phieuthu.Services;

import com.example.demo_jpa_phieuthu.Model.ChiTietPhieuThu;
import com.example.demo_jpa_phieuthu.Model.NguyenLieu;
import com.example.demo_jpa_phieuthu.Model.PhieuThu;
import com.example.demo_jpa_phieuthu.Repository.ChiTietPhieuThuRepo;
import com.example.demo_jpa_phieuthu.Repository.NguyenLieuRepo;
import com.example.demo_jpa_phieuthu.Repository.PhieuThuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PhieuThuServices implements IPhieuThuServices {
    @Autowired
    PhieuThuRepo phieuThuRepo;
    @Autowired
    ChiTietPhieuThuRepo chiTietPhieuThuRepo;
    @Autowired
    NguyenLieuRepo nguyenLieuRepo;
    @Autowired
    ChiTietPhieuThuServices chiTietPhieuThuServices;

    @Override
    public PhieuThu themmoi(PhieuThu phieuThu) {
        phieuThuRepo.save(phieuThu);
        List<ChiTietPhieuThu> chiTietPhieuThuList = new ArrayList<ChiTietPhieuThu>(phieuThu.getChiTietPhieuThuList());
       for(ChiTietPhieuThu x : chiTietPhieuThuList){
           Optional<NguyenLieu > nguyenLieuOptional = nguyenLieuRepo.findById(x.getNguyenLieus().getNguyenlieuid());
           Optional<PhieuThu> phieuThuOptional = phieuThuRepo.findById(phieuThu.getPhieuthuid());
            NguyenLieu nguyenLieu =nguyenLieuOptional.get();
            PhieuThu phieuThu1 = phieuThuOptional.get();

           x.setPhieuThus(phieuThu1);

           nguyenLieu.setSoLuongKho(nguyenLieu.getSoLuongKho() - x.getSoLuongBan());
           phieuThu1.setThanhTien(phieuThu1.getThanhTien() + x.getSoLuongBan() * nguyenLieu.getGiaBan());

           chiTietPhieuThuRepo.save(x);
           phieuThuRepo.save(phieuThu1);
           nguyenLieuRepo.save(nguyenLieu);
       }
        return phieuThu;
    }

    @Override
    public PhieuThu remove(int id) {
        Optional<PhieuThu> phieuThuOptional = phieuThuRepo.findById(id);
        if(phieuThuOptional.isEmpty()){
            return null;
        }
        phieuThuRepo.delete(phieuThuOptional.get());
        return phieuThuOptional.get();
    }

    @Override
    public List<PhieuThu> getMoth(int thang) {
        List<PhieuThu> phieuThuList =new ArrayList<>();
        for(PhieuThu x : phieuThuRepo.findAll()){

           if((x.getNgayLap().getMonth().getValue()) == thang){

                phieuThuList.add(x);
            }
        }
        return phieuThuList;
    }
}
