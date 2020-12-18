package com.codegym.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "attach_service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachServiceId;
    private String attachServiceName;
    private double attachServiceCost;
    private int attachServiceUnit;
    private String attachServiceStatus;
    @OneToMany(mappedBy = "attachService",cascade = CascadeType.ALL)
    List<ContractDetail> listContractDetail;
}
