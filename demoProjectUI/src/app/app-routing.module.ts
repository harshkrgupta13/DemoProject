import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { LoginComponent } from './login/login.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { SignupComponent } from './signup/signup.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path:'',component:LoginComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path:'employees',canActivate:[AuthGuard],component:EmployeeComponent},  
  {path:'create-employee',canActivate:[AuthGuard],component:CreateEmployeeComponent},
  {path:'update-employee/:eid',canActivate:[AuthGuard],component:UpdateEmployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
