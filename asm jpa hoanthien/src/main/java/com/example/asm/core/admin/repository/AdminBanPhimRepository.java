package com.example.asm.core.admin.repository;

import com.example.asm.core.admin.model.response.AdminBanPhimThongKeResponse;
import com.example.asm.entity.BanPhim;
import com.example.asm.repository.BanPhimRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminBanPhimRepository extends BanPhimRepository {
    List<BanPhim> findAll(Specification<BanPhim> specification);

    Page<BanPhim> findAll(Specification<BanPhim> banPhimSpecification, Pageable pageable);



}
