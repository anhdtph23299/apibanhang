package com.example.asm.repository;

import com.example.asm.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Long> {

    @Query(value = """
                    SELECT COUNT(ghct.IdGioHang) FROM dbo.GioHang gh JOIN dbo.GioHangChiTiet ghct ON ghct.IdGioHang = gh.id\s
                    JOIN dbo.KhachHang kh ON kh.id = gh.IdKH WHERE gh.TrangThai = 0 AND kh.id=:idkh
            """, nativeQuery = true)
    Long timSoLuongTrongGio(@Param("idkh") Long idKH);

}
