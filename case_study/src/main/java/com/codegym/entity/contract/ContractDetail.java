package com.codegym.entity.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity(name = "contract_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;
    @Min(value = 1,message = "Please enter quantity")
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "attach_service_id",referencedColumnName = "attachServiceId")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id",referencedColumnName = "contractId")
    private Contract contract;

}
