package com.springboot21.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "asset_types")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name") private String name;
    @Column(name = "description") private String description;
    @Column(name = "created_at") private LocalDateTime created_at;
    @Column(name = "updated_at") private LocalDateTime updated_at;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private List<Asset> assets;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        created_at = now;
        updated_at = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updated_at = LocalDateTime.now();
    }

}
