import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit , OnDestroy{

  constructor() { }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }

  ngOnInit(): void {
    //code
  }
 // public firstname: any;
  //public password:any;
  loginForm = new FormGroup(
{
     firstname: new FormControl('',Validators.required),
    password: new FormControl('',Validators.minLength(8))
}
  )

  public display:any =null;
  getData()
  {
    this.display = JSON.stringify(this.loginForm.value);
    console.log(this.loginForm.value);
  }
}
