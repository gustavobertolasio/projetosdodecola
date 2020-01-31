package com.example.Project.domain.dto.request;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.example.Project.domain.validators.DateRange;
import com.example.Project.domain.validators.Phone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientCreateRequest {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "phone is required")
    @Phone()
    private String phone;    
  
    @DateRange
    private Date data;
}