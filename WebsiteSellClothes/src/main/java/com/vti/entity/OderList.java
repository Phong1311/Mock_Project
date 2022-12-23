package com.vti.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "OderList")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderList implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "oderId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @CreatedDate
    @Column(name = "oderDate")
    private LocalDateTime oderDate;

    @Column(name = "oderValue", nullable = false)
    private int describe;

    @Column(name = "`status`", nullable = false)
    @Convert(converter = OderListStatusConvert.class)
    private Status status;


    public enum Status {
        WAITING("WAITING"), DELIVERY("DELIVERY"), DELIVERED("DELIVERED"), CANCELED("CANCELED");

        private String value;

        private Status(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Status toEnum(String sqlValue) {
            for (Status type : Status.values()) {
                if (type.getValue().equals(sqlValue)) {
                    return type;
                }
            }
            return null;
        }

    }

    @OneToMany(mappedBy = "oderList")
    private List<OderDetail> oderDetails;
}