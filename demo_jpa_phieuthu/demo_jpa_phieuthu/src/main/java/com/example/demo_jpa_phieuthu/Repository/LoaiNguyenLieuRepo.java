package com.example.demo_jpa_phieuthu.Repository;

import com.example.demo_jpa_phieuthu.Model.LoaiNguyenLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiNguyenLieuRepo extends JpaRepository<LoaiNguyenLieu,Integer> {
}
