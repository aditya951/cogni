import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from '../company/company.component';
import { CompanyDataService } from '../service/data/company-data.service';

@Component({
  selector: 'app-new-company',
  templateUrl: './new-company.component.html',
  styleUrls: ['./new-company.component.css']
})
export class NewCompanyComponent implements OnInit {


  company: Company| any;
  turnover :boolean=false;
  
  constructor(private svc:CompanyDataService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.company=new Company(0,'','',0,"",'',[]);
  }

  createCompany(){

if(this.company.companyTurnover<100000000){
    this.turnover=true;
}
    
    this.svc.createCompany(this.company).subscribe(
      data=>{
        console.log(data)
        this.router.navigate(['companies'])
      }
    );

  }


}
