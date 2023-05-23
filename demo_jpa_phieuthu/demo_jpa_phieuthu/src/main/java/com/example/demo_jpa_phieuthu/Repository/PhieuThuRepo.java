package com.example.demo_jpa_phieuthu.Repository;

import com.example.demo_jpa_phieuthu.Model.PhieuThu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieuThuRepo extends JpaRepository<PhieuThu,Integer> {
}
