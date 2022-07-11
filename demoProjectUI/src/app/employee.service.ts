import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private getEmployeeUrl = "http://localhost:8080/employee";
  private getEmployeesListUrl = "http://localhost:8080/employee/list";

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(`${this.getEmployeesListUrl}`);
  }

  createEmployee(employee: Employee): Observable<any> {
    return this.http.post(`${this.getEmployeeUrl}`, employee)
  };

  getEmployeeById(eid: any): Observable<Employee> {
    return this.http.get<Employee>(`${this.getEmployeeUrl}/${eid}`);
  }

  updateEmployee(eid: any, employee: Employee): Observable<any> {
    return this.http.put(`${this.getEmployeeUrl}/${eid}`, employee);
  }

  deleteEmployee(eid: any): Observable<Object> {
    return this.http.delete(`${this.getEmployeeUrl}/${eid}`);
  }

}
