import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { course } from './course';
import { CourseService } from './course.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  constructor(private http:HttpClient, private _courseService: CourseService)
  { }

  ngOnInit(): void {
  }

  data: any ={};
  c: course = new course();
   courses: Array<course> =[];
 
  //Subscribe


  addCourseDetails()
  {
    this._courseService.addCourse(this.c).subscribe(data=>
      {
        this.courses.push(data);
      },
      error=>
      {
        console.log(error);
      })
      this.c = new course();
  }

  viewAllCourse()
  {
    this._courseService.getAllCourse().subscribe(data=>
      {
        this.courses=data;
      },
      error=>
      {
        console.log("error");
      })
  }
   
  deleteCourse(id:number)
  {
    this._courseService.deleteCourse(id).subscribe(data=>
      {
        console.log("Record is deleted!",data);
        let courseIndex = this.courses.findIndex(c=>c.id === id);
        console.log(courseIndex);
        this.courses.splice(courseIndex,1);
        this.viewAllCourse();
      },
      error=>
      {
        console.log("error");
      }
     
      )
  }


}
