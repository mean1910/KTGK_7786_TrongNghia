package com.example.__TrongNghia.service;

import com.example.__TrongNghia.entity.PhongBan;
import com.example.__TrongNghia.repository.PhongBanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PhongBanService {


    @Autowired
    private PhongBanRepository phongBanRepository;

    public List<PhongBan> getAllPhongBan() {
        return phongBanRepository.findAll();
    }

    public Optional<PhongBan> getPhongBanById(String id) {
        return phongBanRepository.findById(id);
    }

    public PhongBan savePhongBan(PhongBan phongBan) {
        return phongBanRepository.save(phongBan);
    }

    public void deletePhongBanById(String id) {
        phongBanRepository.deleteById(id);
    }
}
