import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'MyApp';


  public company ="Cognizant";

  public btnTxt ="Press Me!";
  public btnCssStyle="btn btn-danger";

  public disabledStatus= false;

  constructor()
  {
    this.company = "Cognizant solutions";
  }

  updateCompany($event:any)
  {
    this.company = $event.target.value;
    console.log(this.company);

  }
   showMsg=($event:any)=>
   {
     console.log("Button is presses...........!");
     this.btnTxt="Generating log file..........please wait!";
     console.log($event);

     setTimeout(()=>
     {
       this.btnTxt="Report is created!"
     },8000)
     
   }
}
