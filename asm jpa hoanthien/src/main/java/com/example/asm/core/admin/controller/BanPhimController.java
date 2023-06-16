package com.example.asm.core.admin.controller;

import com.example.asm.core.admin.model.request.SearchThuocTinhCustomModel;
import com.example.asm.entity.BanPhim;
import com.example.asm.core.admin.service.BanPhimService;
import com.example.asm.core.admin.service.HangService;
import com.example.asm.core.admin.service.KieuKetNoiService;
import com.example.asm.core.admin.service.LoaiBanPhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/banphim")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class BanPhimController {
    @Autowired
    private BanPhimService banPhimService;

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping()
    public Page<BanPhim> viewAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer soTrang,
            @RequestParam(name = "size", required = false, defaultValue = "3") Integer size
    ) {
        if (soTrang < 1) {
            soTrang = 1;
        }

        Pageable pageable = PageRequest.of(soTrang - 1, size);
        Page<BanPhim> page = banPhimService.getAll(pageable);
        return page;
    }
    @GetMapping("/getall")
    public List<BanPhim> getALl(){
        return banPhimService.getAll();
    }
    //
    @PostMapping("/findthuoctinh")
    public Page<BanPhim> findThuocTinh(@RequestBody SearchThuocTinhCustomModel thuocTinhCustomModel,
                                       @RequestParam(name = "page", required = false, defaultValue = "1") Integer soTrang,
                                       @RequestParam(name = "size", required = false, defaultValue = "3") Integer size
    ) {
        if (soTrang < 1) {
            soTrang = 1;
        }
        Pageable pageable = PageRequest.of(soTrang-1, size);
        Page<BanPhim> page = banPhimService.findByThuocTinh(thuocTinhCustomModel, pageable);
        return page;
    }

    //
    @PostMapping("/add")
    public ResponseEntity<BanPhim> add(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart("requestData") BanPhim banPhim) throws IOException {
        banPhim.setImages(file.getBytes());
        return ResponseEntity.ok(banPhimService.saveOrUpdate(banPhim));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BanPhim> update(@RequestPart(value = "file", required = false) MultipartFile file, @RequestPart("requestData") BanPhim banPhim,
                                          @PathVariable(value = "id") Long id
//                         @RequestParam("anh") MultipartFile anh
    ) throws IOException {
        banPhim.setId(id);
        banPhim.setImages(file.getBytes());
        return ResponseEntity.ok(banPhimService.saveOrUpdate(banPhim));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        BanPhim banPhim = new BanPhim();
        banPhim.setId(id);
        banPhimService.delete(banPhim);
    }

    @GetMapping("/detail/{id}")
    public BanPhim detail(@PathVariable(value = "id") Long id) {
        BanPhim banPhim = banPhimService.findByMaSanPham(id);
//        model.addAttribute("banPhim",banPhim);
        return banPhim;
    }

    @PostMapping("/testupload")
    public BanPhim testUpload(@RequestPart("file") MultipartFile file, @RequestPart("requestData") BanPhim banPhim) throws IOException {
        System.out.println("hello " + file.getBytes());
        System.out.println(banPhim);
        return null;
    }


}
