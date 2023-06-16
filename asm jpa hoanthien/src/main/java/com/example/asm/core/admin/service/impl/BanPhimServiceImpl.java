package com.example.asm.core.admin.service.impl;

import com.example.asm.core.admin.repository.AdminBanPhimRepository;
import com.example.asm.core.admin.service.BanPhimService;
import com.example.asm.core.admin.model.request.SearchThuocTinhCustomModel;
import com.example.asm.entity.BanPhim;
import com.example.asm.spe.BanPhimSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BanPhimServiceImpl implements BanPhimService {
    @Autowired
    private AdminBanPhimRepository banPhimRepository;

    private int soPhanTuTrongTrang = 3;

    @Override
    public BanPhim saveOrUpdate(BanPhim banPhim) {
        banPhim.setTrangThai(0);
        return banPhimRepository.save(banPhim);
    }

    @Override
    public void delete(BanPhim banPhim) {
        banPhimRepository.delete(banPhim);
    }

    @Override
    public Page<BanPhim> findByThuocTinh(SearchThuocTinhCustomModel model, Pageable pageable) {
        Specification<BanPhim> banPhimSpecification = BanPhimSpecifications.searchThuocTinh(model);
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return banPhimRepository.findAll(banPhimSpecification, pageable);
    }


    @Override
    public Page<BanPhim> getAll(Pageable pageable) {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(),sort);
        return banPhimRepository.findAll(pageable);
    }


    @Override
    public BanPhim findByMaSanPham(Long maSanPham) {
        BanPhim banPhim = new BanPhim();
        banPhim.setId(maSanPham);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("id", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<BanPhim> example = Example.of(banPhim, matcher);
        return banPhimRepository.findOne(example).orElse(null);
    }

    @Override
    public List<BanPhim> findTop3ByTenSanPham(String tenSanPham) {
        BanPhim product = new BanPhim();
        product.setTenBanPhim(tenSanPham);
        product.setTrangThai(0);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("tenBanPhim", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("trangThai", ExampleMatcher.GenericPropertyMatchers.exact());

        Example<BanPhim> example = Example.of(product, matcher);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        return banPhimRepository.findAll(example, sort).stream().limit(soPhanTuTrongTrang).collect(Collectors.toList());
    }

    @Override
    public List<BanPhim> chiaTrang(Long soTrang) {
        BanPhim banPhimExample = new BanPhim();
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<BanPhim> example = Example.of(banPhimExample, matcher);

        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(Math.toIntExact(soTrang), soPhanTuTrongTrang, sort);

        Page<BanPhim> sanPhamPage = banPhimRepository.findAll(example, pageable);
        return sanPhamPage.getContent();
    }

    @Override
    public Long tongSoTrang() {
        Long phanTu = banPhimRepository.count();
        Long totalPages = phanTu / soPhanTuTrongTrang;
        if (phanTu % soPhanTuTrongTrang != 0) {
            totalPages++;
        }
        return totalPages;
    }

    @Override
    public Integer tongSoTrangCoPhanTu(int phanTu) {
        int totalPages = phanTu / soPhanTuTrongTrang;
        if (phanTu % soPhanTuTrongTrang != 0) {
            totalPages++;
        }
        return totalPages;
    }

    @Override
    public Integer getSizeByTen(String ten) {
        BanPhim banPhim = new BanPhim();
        banPhim.setTenBanPhim(ten);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("tenBanPhim", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<BanPhim> example = Example.of(banPhim, matcher);
        return banPhimRepository.findAll(example).size();
    }

    @Override
    public Integer getSizeKhoangGia(BigDecimal min, BigDecimal max) {
        Specification<BanPhim> specification = BanPhimSpecifications.giaBetween(min, max);
        return banPhimRepository.findAll(specification).size();
    }

    @Override
    public List<BanPhim> findBanPhimByKhoang(BigDecimal min, BigDecimal max) {
        Specification<BanPhim> specification = BanPhimSpecifications.giaBetween(min, max);
        return banPhimRepository.findAll(specification);
    }

    @Override
    public List<BanPhim> dsBanPhimBanChay() {
        return null;
    }

    @Override
    public List<BanPhim> getAll() {
        return banPhimRepository.findAll();
    }

}
