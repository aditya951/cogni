import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { pupil } from './pupil';

@Component({
  selector: 'app-admission',
  templateUrl: './admission.component.html',
  styleUrls: ['./admission.component.css']
})
export class AdmissionComponent implements OnInit {

  constructor() { }
 

  ngOnInit(): void {
  }

  public subjects= ['Java','.Net','Python'];

  public model = new pupil('Noah', this.subjects[2]);
  name1:string |any;
  subject1:string |any;

 
public s1= [{"key1": "","key2": ""}];


  submitted= false;
  onSubmit()
  {
    this.submitted = true;
    // console.log(this.model.name);
    // console.log(this.model.subject);

    this.name1=this.model.name;
    this.subject1=this.model.subject;
    this.s1.push({key1:this.name1,key2:this.subject1});
    console.log(this.s1);
  }


}
