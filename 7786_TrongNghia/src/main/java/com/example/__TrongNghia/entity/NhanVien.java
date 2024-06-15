package com.example.__TrongNghia.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "NhanVien")
@Data
public class NhanVien {

    @Id
    @Column(name = "Ma_NV", length = 3)
    @NotNull
    private String maNV;

    @Column(name = "Ten_NV", length = 100)
    @NotNull
    private String tenNV;

    @Column(name = "Phai", length = 3)
    private String phai;

    @Column(name = "Noi_Sinh", length = 200)
    private String noiSinh;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private PhongBan phongBan;

    @Column(name = "Luong")
    private int luong;
}

