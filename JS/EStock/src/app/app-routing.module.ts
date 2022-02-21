import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CompanyComponent } from './company/company.component';
import { CreateComponent } from './create/create.component';
import { IndividualComponent } from './individual/individual.component';
import { NewCompanyComponent } from './new-company/new-company.component';
import { StockComponent } from './stock/stock.component';

const routes: Routes = [
  { path: '', component: CompanyComponent  },
  { path: 'companies', component: CompanyComponent},
  {path:'newCompany',component:NewCompanyComponent},
  {path:'create/:id',component:CreateComponent},
  {path:'show/:id',component:IndividualComponent},
  {path:'add/:id',component:StockComponent},
  { path: '**', component: CompanyComponent  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
