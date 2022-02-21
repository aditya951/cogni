import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { course } from './course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  constructor(private http: HttpClient)
  {

   }

  public dbUrl = "http://localhost:3000/course/";

//Observable

  addCourse(c:course): Observable<course>
  {
    return this.http.post<course>(this.dbUrl,c);

  }

  getAllCourse(): Observable<Array<course>>
  {
    return this.http.get<Array<course>>(this.dbUrl);

  }
  deleteCourse(id:number): Observable<course>
  {
    return this.http.delete<course>(`${this.dbUrl}/${id}`);
     
   
  }
}
