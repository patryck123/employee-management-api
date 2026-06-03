package com.patryck.employee.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
@Entity @Table(name = "employees") @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @NotBlank @Column(nullable = false) private String name;
    @Email @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String cpf;
    @Column(nullable = false) private String position;
    @Column(nullable = false) private String department;
    @Column(nullable = false, precision = 10, scale = 2) private BigDecimal salary;
    @Column(nullable = false) private LocalDate hireDate;
    @Enumerated(EnumType.STRING) @Builder.Default private EmployeeStatus status = EmployeeStatus.ACTIVE;
    private String phone;
    private String manager;
}
