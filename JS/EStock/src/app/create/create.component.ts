import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from '../company/company.component';
import { CompanyDataService } from '../service/data/company-data.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  id!: number;
  company!: Company;
  turnover: boolean | any;

  constructor(
    private svc: CompanyDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.company = new Company(
      59,
      'google',
      'zack',
      100450,
      'google.com',
      'nse',
      []
    );
    this.id = this.route.snapshot.params['id'];
    this.svc.getCompany(this.id).subscribe(
      (data) => {
        this.company = data;
        console.log(this.company);
      },
      (error) => this.handleError(error)
    );
  }

  updateCompany() {
    if (this.company.companyTurnover < 100000000) {
      this.turnover = true;
    } else {
      this.svc.updateCompany(this.id, this.company).subscribe((data) => {
        console.log(data);
        this.router.navigate(['companies']);
      });
    }
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }
}
