import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CompanyDataService } from '../service/data/company-data.service';

export class Stock {
  constructor(
    public id: number,
    public stockPrice: number,
    public date: Date
  ) {}
}
export class Company {
  constructor(
    public companyCode: number,
    public companyName: string,
    public companyCEO: string,
    public companyTurnover: number,
    public companyWebsite: string,
    public stockExchangeName: string,
    //public stocks:
    public stocks: Stock[] // public List<Stock> stocks=new ArrayList<>();
  ) {}
}

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css'],
})
export class CompanyComponent implements OnInit {
  companies: Company[] = [];
  //company: Company=new Company();
  // =[
  //   new Company(58,'adobe','zack',1000,"adobe.com",'nse',[new Stock(2,56,new Date())]),
  //   new Company(59,'google','zack',100450,"google.com",'nse',[]),
  //   new Company(60,'IBM','zack',1005424527854240,"IBM.com",'nse',[])
  // ]

  id: number = 8;
  company!: Company;
  message: string | undefined;
  search: string = '';

  constructor(public sevc: CompanyDataService, private router: Router) {}

  ngOnInit(): void {
    this.refreshpage();
  }

  refreshpage() {
    this.sevc.retriveAllComapny().subscribe(
      (response) => {
        //console.log(response);
        this.companies = response;
      },
      (error) => this.handleError(error)
    );
  }

  // getMessage(){

  //    this.sevc.retriveAllComapny().subscribe(
  //      response =>this.handleSuccessResponse(response),
  //      error =>this.handleError(error)

  //      );

  // }
  deleteCompany(id: number) {
    console.log(`delete clicked ${id}`);
    var txt;
    if (confirm('Are u sure, u want to delete!')) {
      this.sevc.deleteCompany(id).subscribe((response) => {
        console.log(response);
        this.message = `delete of company ${id} successful`;
        this.refreshpage();
      });
    } else {
      txt = 'You pressed Cancel!';
    }
  }

  updateCompany(id: number) {
    console.log(`update clicked ${id}`);
    this.router.navigate(['create', id]);
  }
  AddStock(id: number) {
    console.log(`add stock clicked ${id}`);
    this.router.navigate(['add', id]);
  }

  createoneCompany() {
    console.log(`create clicked`);

    this.router.navigate(['newCompany']);
  }

  searchCompany() {
    console.log('search clicked');
    console.log(this.search);
    if (this.search.length > 0) this.router.navigate(['search', this.search]);
  }

  // handleSuccessResponse(response: any){
  //   // console.log(response);
  //   // console.log(response[0].companyName);
  //   this.companies=response;
  //   console.log(this.companies);
  // }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }
}
