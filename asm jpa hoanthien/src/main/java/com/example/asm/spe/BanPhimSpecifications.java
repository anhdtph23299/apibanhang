package com.example.asm.spe;

import com.example.asm.core.admin.model.request.SearchThuocTinhCustomModel;
import com.example.asm.entity.BanPhim;
import com.example.asm.entity.Hang;
import com.example.asm.entity.KieuKetNoi;
import com.example.asm.entity.LoaiBanPhim;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class BanPhimSpecifications {
    public static Specification<BanPhim> giaBetween(BigDecimal minPrice, BigDecimal maxPrice) {
        return new Specification<BanPhim>() {
            @Override
            public Predicate toPredicate(Root<BanPhim> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.between(root.get("donGia"), minPrice, maxPrice);
            }
        };
    }

    public static Specification<BanPhim> searchThuocTinh(SearchThuocTinhCustomModel model) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();

            if (model.getTenBanPhim() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("tenBanPhim"),
                        "%" + model.getTenBanPhim()+"%"));
            }

            if (model.getMin() != null && model.getMax() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.between(root.get("donGia"),
                        model.getMin(), model.getMax()));
            }
            if (model.getDenNen() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("denNen"),
                        model.getDenNen()));
            }

            Join<BanPhim, LoaiBanPhim> joinLoai = root.join("loaiBanPhim");
            Join<BanPhim, Hang> joinHang = root.join("hang");
            Join<BanPhim, KieuKetNoi> joinKieu = root.join("kieuKetNoi");
            if (model.getLoaiBanPhim() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.
                        lower(joinLoai.get("tenLoai")), "%" + model.getLoaiBanPhim().toLowerCase() + "%"));
            }
            if (model.getHang() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.
                        lower(joinHang.get("tenHang")), "%" + model.getHang().toLowerCase() + "%"));
            }
            if (model.getLoaiBanPhim() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.
                        lower(joinKieu.get("tenKieu")), "%" + model.getKieuKetNoi().toLowerCase() + "%"));
            }

            return predicate;
        };
    }
}
