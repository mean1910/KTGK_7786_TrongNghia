package com.example.__TrongNghia.service;

import com.example.__TrongNghia.entity.NhanVien;
import com.example.__TrongNghia.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }

    public void saveNhanVien(NhanVien nhanVien) {
        nhanVienRepository.save(nhanVien);
    }

    public void deleteNhanVienByMaNV(String maNV) {
        nhanVienRepository.deleteById(maNV);
    }

    public Optional<NhanVien> getNhanVienByMaNV(String maNV) {
        return nhanVienRepository.findById(maNV);
    }


    public Page<NhanVien> getAllNhanVienPaged(int page, int size) {
        return nhanVienRepository.findAll(PageRequest.of(page, size));
    }


    public long countAllNhanVien() {
        return nhanVienRepository.count();
    }
}
