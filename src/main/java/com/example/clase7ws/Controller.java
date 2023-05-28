package com.example.clase7ws;

import com.example.clase7ws.entity.Employee;
import com.example.clase7ws.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/lab4")
public class Controller {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/listaSinPresi")
    public List<Employee> listaEmployee() {
        return employeeRepository.listaSinPresi();
    }
    @GetMapping("/informacionEmpleado")
    public Employee employee(@RequestParam("id") String id) {
        return employeeRepository.empleado(Integer.parseInt(id)).get(0);
    }
    @PostMapping(value = "/actualizar")
    public ResponseEntity<HashMap<String,String>> actualizar(@RequestBody Employee employee){
        HashMap<String,String> hashMap = new HashMap<>();

        Optional<Employee> optionalProduct = employeeRepository.findById(employee.getId());
        if(optionalProduct.isPresent()){
            Employee employeeOriginal = optionalProduct.get();

            if(employee.getMeeting()==0)
                employeeOriginal.setMeeting(employee.getMeeting());
            if(employee.getMeetingDate() == null)
                employeeOriginal.setMeetingDate(employee.getMeetingDate());


            employeeRepository.save(employee);
            hashMap.put("status", "actualizado");
            return ResponseEntity.status(HttpStatus.CREATED).body(hashMap);
        }else{
            hashMap.put("status","error");
            hashMap.put("msg","hubo algun error");
            return ResponseEntity.ok(hashMap);
        }
    }
}
