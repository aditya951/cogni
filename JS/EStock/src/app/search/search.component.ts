import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from '../company/company.component';
import { CompanyDataService } from '../service/data/company-data.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
})
export class SearchComponent implements OnInit {
  companies: Company[] = [];
  name!: string;
  message!: string;
  show: boolean = false;

  constructor(
    private svc: CompanyDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
    this.svc.retrieveByName(this.name).subscribe(
      (data) => {
        this.companies = data;
        console.log(this.companies);
        if (this.companies.length == 0) {
          this.show = false;
          this.message = 'No Company with this name';
        } else this.show = true;
      },
      (error) => this.handleError(error)
    );
  }

  handleError(error: any) {
    console.log(error);
    console.log(error.error);
    console.log(error.error.message);
  }
}
