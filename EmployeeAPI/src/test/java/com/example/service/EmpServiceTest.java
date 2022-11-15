package com.example.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.dto.EmployeeRequestDTO;
import com.example.entity.Employee;
import com.example.exception.EmployeeAPIException;
import com.example.repository.EmpRepository;

@SpringBootTest
class EmpServiceTest {
	
	@InjectMocks
	EmpService empService;
	
	@Mock
	EmpRepository empRepo;

	@Test
	void testAssignProjectInProjectAPIEmpNotInDbScenario() {
		when(empRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		assertThrows(EmployeeAPIException.class, ()->empService.assignProjectInProjectAPI(11,ArgumentMatchers.anyInt()));
	}
	@Test
	void testAssignProjectInProjectAPIWithZeroEmpId() {
		assertThrows(EmployeeAPIException.class, ()->empService.assignProjectInProjectAPI(0, 0));
	}
	@Test
	void testaddEmpToRepoWithEmpAlreadyAvailable() {
		when(empRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(new Employee()));
		assertThrows(EmployeeAPIException.class, ()->empService.addEmpToRepo(new EmployeeRequestDTO()));
	}
//	@Test
//	void testaddEmpToRepoWithSuccess() {
//		when(empRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
//		when(empRepo.save(ArgumentMatchers.any())).thenReturn(new Employee());
//		Employee addEmpToRepo = empService.addEmpToRepo(new EmployeeRequestDTO());
//		assertNotNull(addEmpToRepo);
//	}
	@Test
	void testaddEmpToRepoWithSuccess() {
		when(empRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		Employee e=new Employee();
		e.setEmpId(113);
		when(empRepo.save(ArgumentMatchers.any())).thenReturn(e);
		EmployeeRequestDTO employeeRequestDTO=new EmployeeRequestDTO();
		employeeRequestDTO.setEmpId(113);
		Employee addEmpToRepo = empService.addEmpToRepo(employeeRequestDTO);
		assertEquals(employeeRequestDTO.getEmpId(),addEmpToRepo.getEmpId());
	}	
}
