package com.example.__TrongNghia.controller;

import com.example.__TrongNghia.entity.NhanVien;
import com.example.__TrongNghia.entity.PhongBan;
import com.example.__TrongNghia.service.NhanVienService;
import com.example.__TrongNghia.service.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private PhongBanService phongBanService;

    @GetMapping("/list")
    public String listNhanVien(Model model, @RequestParam(defaultValue = "0") int page) {
        int pageSize = 5;

        Page<NhanVien> danhSachNhanVienPage = nhanVienService.getAllNhanVienPaged(page, pageSize);

        List<NhanVien> danhSachNhanVien = danhSachNhanVienPage.getContent();

        model.addAttribute("danhSachNhanVien", danhSachNhanVien);

        // Add other pagination-related attributes if needed
        model.addAttribute("totalPages", ((Page<?>) danhSachNhanVienPage).getTotalPages());
        model.addAttribute("currentPage", page);

        return "nhanvien/list";
    }

    @GetMapping("/add")
    public String addNhanVienForm(Model model) {
        model.addAttribute("nhanvien", new NhanVien());
        List<PhongBan> phongBans = phongBanService.getAllPhongBan();
        model.addAttribute("phongBans", phongBans);
        return "nhanvien/add";
    }


    @PostMapping("/add")
    public String addNhanVienSubmit(@ModelAttribute("nhanvien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanviens/list";
    }

    @GetMapping("/edit/{maNV}")
    public String editNhanVienForm(@PathVariable("maNV") String maNV, Model model) {
        Optional<NhanVien> optionalNhanVien = nhanVienService.getNhanVienByMaNV(maNV);
        if (optionalNhanVien.isPresent()) {
            model.addAttribute("nhanvien", optionalNhanVien.get());
            List<PhongBan> phongBans = phongBanService.getAllPhongBan();
            model.addAttribute("phongBans", phongBans);
            return "nhanvien/edit";
        } else {
            return "redirect:/nhanviens/list";
        }
    }

    @PostMapping("/edit/{maNV}")
    public String editNhanVienSubmit(@PathVariable("maNV") String maNV, @ModelAttribute("nhanvien") NhanVien nhanVien) {
        nhanVienService.saveNhanVien(nhanVien);
        return "redirect:/nhanviens/list";
    }

    @GetMapping("/delete/{maNV}")
    public String deleteNhanVien(@PathVariable("maNV") String maNV) {
        nhanVienService.deleteNhanVienByMaNV(maNV);
        return "redirect:/nhanviens/list";
    }
}
