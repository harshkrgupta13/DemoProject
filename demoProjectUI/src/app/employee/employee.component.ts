import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  employees: Employee[];

  constructor(private employeeService: EmployeeService, private router: Router) { }

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.employeeService.getEmployees().subscribe(data => { this.employees = data; });
  }

  createEmployee() {
    console.log("inside createEmployee()")
    this.router.navigate(['create-employee'])
  }

  updateEmployee(eid: any) {
    this.router.navigate(['update-employee', eid]);
  }

  deleteEmployee(eid: number) {
    console.log("inside deleteEmployee()");
    this.employeeService.deleteEmployee(eid).subscribe(data => {
      console.log(data);
      this.getEmployees();
    }
      , error => console.log(error));
  }

}
