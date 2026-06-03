package com.patryck.employee.controller;
import com.patryck.employee.entity.*;
import com.patryck.employee.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/employees") @RequiredArgsConstructor
@Tag(name = "Funcionários", description = "Gestão de RH e funcionários")
public class EmployeeController {
    private final EmployeeRepository repo;
    @PostMapping public ResponseEntity<?> create(@Valid @RequestBody Employee e) {
        if (repo.existsByEmail(e.getEmail())) return ResponseEntity.status(HttpStatus.CONFLICT).body("E-mail já cadastrado");
        if (repo.existsByCpf(e.getCpf())) return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado");
        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(e));
    }
    @GetMapping public ResponseEntity<List<Employee>> findAll() { return ResponseEntity.ok(repo.findAll()); }
    @GetMapping("/{id}") public ResponseEntity<Employee> findById(@PathVariable Long id) { return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); }
    @GetMapping("/department/{dept}") @Operation(summary = "Filtrar por departamento") public ResponseEntity<List<Employee>> byDept(@PathVariable String dept) { return ResponseEntity.ok(repo.findByDepartment(dept)); }
    @GetMapping("/status/{status}") public ResponseEntity<List<Employee>> byStatus(@PathVariable EmployeeStatus status) { return ResponseEntity.ok(repo.findByStatus(status)); }
    @GetMapping("/search") public ResponseEntity<List<Employee>> search(@RequestParam String name) { return ResponseEntity.ok(repo.findByNameContainingIgnoreCase(name)); }
    @PutMapping("/{id}") public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee updated) {
        if (!repo.existsById(id)) return ResponseEntity.notFound().build();
        updated.setId(id); return ResponseEntity.ok(repo.save(updated));
    }
    @PatchMapping("/{id}/status") public ResponseEntity<Employee> updateStatus(@PathVariable Long id, @RequestParam EmployeeStatus status) {
        return repo.findById(id).map(e -> { e.setStatus(status); return ResponseEntity.ok(repo.save(e)); }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id) { if (!repo.existsById(id)) return ResponseEntity.notFound().build(); repo.deleteById(id); return ResponseEntity.noContent().build(); }
}
