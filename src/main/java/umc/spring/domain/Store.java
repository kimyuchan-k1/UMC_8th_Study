package umc.spring.domain;


import jakarta.persistence.*;
import jakarta.persistence.criteria.Join;
import lombok.*;
import umc.spring.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String address;

    private Float score;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;


    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") +
                '}';
    }
}
