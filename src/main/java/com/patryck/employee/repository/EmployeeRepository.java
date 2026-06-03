package com.patryck.employee.repository;
import com.patryck.employee.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartment(String department);
    List<Employee> findByStatus(EmployeeStatus status);
    List<Employee> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
