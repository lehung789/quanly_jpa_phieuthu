package com.example.demo_jpa_phieuthu.Services;

import com.example.demo_jpa_phieuthu.Model.PhieuThu;

import java.time.LocalDate;
import java.util.List;

public interface IPhieuThuServices {
   PhieuThu themmoi (PhieuThu phieuThu);
   PhieuThu remove (int id);
   List<PhieuThu> getMoth(int thang);

}
