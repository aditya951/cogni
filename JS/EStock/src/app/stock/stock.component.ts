import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Stock } from '../company/company.component';
import { CompanyDataService } from '../service/data/company-data.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class StockComponent implements OnInit {


  id!:number;
  stock!: Stock;


  constructor(private svc:CompanyDataService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {

    this.stock=new Stock(0,0,new Date());
    this.id=this.route.snapshot.params['id']
  }

  addStock(){
    this.svc.AddStock(this.id,this.stock).subscribe(
      data=>{
        console.log(data);
        this.router.navigate(['companies']);
      }
    );

  }

  

}
