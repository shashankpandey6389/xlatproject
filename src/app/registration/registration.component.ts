import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EcomService } from '../services/ecom.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {
  registerForm!:FormGroup
  constructor(private formBuilder: FormBuilder,private service:EcomService ,private router:Router) { }

  ngOnInit(): void {
    this.registerForm = this.formBuilder.group({
      email: ['', [Validators.required,Validators.email]],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      phoneNumber: ['', Validators.required],
      password:['',Validators.required]
      
    });
  }
  register()
  {
    this.service.register(this.registerForm.value).subscribe({
      next(value) {
        console.log(value);
        
      },
    })
    this.router.navigate(['/login']);

}
}