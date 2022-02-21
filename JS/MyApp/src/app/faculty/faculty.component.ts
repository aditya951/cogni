import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-faculty',
  templateUrl: './faculty.component.html',
  styleUrls: ['./faculty.component.css']
})
export class FacultyComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  faculty:any []=
  [
    {"empid":1, "domain":"Java","fullname":"John T","YOE":16},
    {"empid":2, "domain":"Python","fullname":"Chris E","YOE":21},
    {"empid":3, "domain":"Python","fullname":"Robert D","YOE":8},
    {"empid":4, "domain":"Java","fullname":"Chris H","YOE":30},
    {"empid":5, "domain":".Net","fullname":"Monica","YOE":1}
  ]
}
