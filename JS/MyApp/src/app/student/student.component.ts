import { Component, OnInit } from '@angular/core';
import { student } from './student';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

 

  ngOnInit(): void {
  }

  stuObj: student |any;

//stuObj.age = 21;
constructor()
{
  this.stuObj= new student('John','john@gmail.com',21);
 

}

updateName($event:any)
{
  this.stuObj.sname=$event.target.value;
}
updateEmail($event:any)
{
  this.stuObj.email=$event.target.value;
}
updateAge($event:any)
{
  this.stuObj.age=$event.target.value;
}
}
