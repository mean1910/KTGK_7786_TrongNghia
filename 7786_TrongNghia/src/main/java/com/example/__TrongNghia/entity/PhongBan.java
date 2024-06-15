package com.example.__TrongNghia.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "PhongBan")
public class PhongBan {

    @Id
    @Column(name = "Ma_Phong", length = 2)
    private String maPhong;

    @Column(name = "Ten_Phong", length = 100)
    private String tenPhong;

    @OneToMany(mappedBy = "phongBan")
    private Set<NhanVien> nhanViens;
}

