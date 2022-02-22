import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from '../company/company.component';
import { CompanyDataService } from '../service/data/company-data.service';

@Component({
  selector: 'app-individual',
  templateUrl: './individual.component.html',
  styleUrls: ['./individual.component.css'],
})
export class IndividualComponent implements OnInit {
  id!: number;
  company: Company | any;
  turnover: number | any;
  val!: number;
  val1!: string;
  show: boolean = false;
  show1: boolean = false;
  max: number = -999999999999999;
  min: number = 9999999999999999;
  avg: number = 0;
  sum: number = 0;
  error: string = '';
  constructor(
    private svc: CompanyDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.company = new Company(0, '', '', 0, '', '', []);
    this.id = this.route.snapshot.params['id'];
    this.svc.getCompany(this.id).subscribe(
      (data) => {
        this.company = data;
        console.log(this.company);
        this.turnover = this.conversion(this.company.companyTurnover);
        this.maximum(this.company);
        this.minimum(this.company);
        this.average(this.company);
        this.show1 = true;
      },
      (error) => this.handleError(error)
    );
  }

  conversion(tu: number) {
    this.val = Math.abs(tu);
    if (this.val >= 10000000) {
      this.val1 = (this.val / 10000000).toFixed(2) + ' Cr';
    } else if (this.val >= 100000) {
      this.val1 = (this.val / 100000).toFixed(2) + ' Lac';
    }
    return this.val1;
  }
  maximum(c: Company) {
    for (let stock of c.stocks) {
      if (stock.stockPrice >= this.max) {
        this.max = stock.stockPrice;
      }
    }
  }
  minimum(c: Company) {
    for (let stock of c.stocks) {
      if (stock.stockPrice <= this.min) {
        this.min = stock.stockPrice;
        this.show = true;
      }
    }
  }

  average(c: Company) {
    for (let stock of c.stocks) {
      this.sum = this.sum + stock.stockPrice;
    }
    this.avg = this.sum / c.stocks.length;
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
    this.error = error.error.message;
  }
}
