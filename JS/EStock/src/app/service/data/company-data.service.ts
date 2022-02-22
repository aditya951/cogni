import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Company, Stock } from 'src/app/company/company.component';

@Injectable({
  providedIn: 'root',
})
export class CompanyDataService {
  constructor(private http: HttpClient) {}

  retriveAllComapny() {
    return this.http.get<Company[]>(
      'http://localhost:8082/api/v1.0/market/company/getall'
    );
    console.log('from service estock');
  }

  // http://localhost:8082/api/v1.0/market/company/a
  retrieveByName(name: string) {
    return this.http.get<Company[]>(
      `http://localhost:8082/api/v1.0/market/company/${name}`
    );
  }

  // http://localhost:8082/api/v1.0/market/company/info/8
  executeOneCompany(id: number) {
    return this.http.get<Company>(
      `http://localhost:8082/api/v1.0/market/company/info/${id}`
    );
  }

  // http://localhost:8082/api/v1.0/market/company/delete/5

  deleteCompany(id: number) {
    return this.http.delete(
      `http://localhost:8082/api/v1.0/market/company/delete/${id}`
    );
  }

  getCompany(id: number) {
    return this.http.get<Company>(
      `http://localhost:8082/api/v1.0/market/company/info/${id}`
    );
  }

  // http://localhost:8082/api/v1.0/market/update
  updateCompany(id: number, company: Company) {
    return this.http.put<Company>(
      'http://localhost:8082/api/v1.0/market/update',
      company
    );
  }

  //http://localhost:8082/api/v1.0/market/company/register
  createCompany(company: Company) {
    return this.http.post(
      'http://localhost:8082/api/v1.0/market/company/register',
      company
    );
  }

  //http://localhost:8082/api/v1.0/market/stock/put/22

  AddStock(id: number, stock: Stock) {
    return this.http.put<Stock>(
      `http://localhost:8082/api/v1.0/market/stock/put/${id}`,
      stock
    );
  }
}
